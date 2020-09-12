import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
        TaskA solver = new TaskA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int answer = 0;
            int N = in.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            boolean pA[] = new boolean[101], pB[] = new boolean[101];
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    Arrays.fill(pA, false);
                    Arrays.fill(pB, false);
                    for (int k = 0; k < N; k++) {
                        if (a[k] < i && !pA[a[k]]) {
                            pA[a[k]] = true;
                        } else if (a[k] < j && !pB[a[k]]) {
                            pB[a[k]] = true;
                        } else if (a[k] == i) {
                            pB[a[k]] = true;
                        } else if (a[k] == j) {
                            pA[a[k]] = true;
                        } else {
                            pA[a[k]] = true;
                        }
                    }
                    int x = findMex(pA) + findMex(pB);
                    answer = Math.max(x, answer);
                }
            }
            out.printLine(answer);
        }

        public int findMex(boolean a[]) {
            for (int i = 0; i <= 100; i++) {
                if (!a[i]) {
                    return i;
                }
            }
            return 0;
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

