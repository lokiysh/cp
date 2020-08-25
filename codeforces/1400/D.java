import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskD solver = new TaskD();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            int a[] = new int[N];
            List<Integer> list[] = new List[N + 1];
            for (int i = 0; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
                list[a[i]].add(i);
            }
            int prefix[][] = new int[N + 1][N];
            for (int i = 1; i <= N; i++) {
                prefix[i][0] = a[0] == i ? 1 : 0;
                for (int j = 1; j < N; j++) {
                    prefix[i][j] = prefix[i][j - 1];
                    if (a[j] == i) {
                        prefix[i][j]++;
                    }
                }
            }
            long ans = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        long k = prefix[i][N - 1];
                        if (k >= 4) {
                            ans += k * (k - 1) * (k - 2) * (k - 3) / 24;
                        }
                    } else {
                        if (prefix[i][N - 1] >= 2 && prefix[j][N - 1] >= 2) {
                            if (prefix[i][N - 1] >= prefix[j][N - 1]) {
                                int k = prefix[j][N - 1];
                                for (int k1 = 0; k1 < k; k1++) {
                                    for (int k2 = k1 + 1; k2 < k; k2++) {
                                        int x = prefix[i][list[j].get(k1)];
                                        int y = prefix[i][list[j].get(k2)] - x;
                                        ans += x * y;
                                    }
                                }
                            } else {
                                int k = prefix[i][N - 1];
                                for (int k1 = 0; k1 < k; k1++) {
                                    for (int k2 = k1 + 1; k2 < k; k2++) {
                                        int x = prefix[j][list[i].get(k2)] - prefix[j][list[i].get(k1)];
                                        int y = prefix[j][N - 1] - prefix[j][list[i].get(k2)];
                                        ans += x * y;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            out.printLine(ans);
        }

    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer tokenizer = null;

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(in.readLine());
                }
                return tokenizer.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class OutputWriter {
        PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

