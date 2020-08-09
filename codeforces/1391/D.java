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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            int a[][] = new int[N][M];
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < N; i++) {
                String s = in.next();
                for (int j = 0; j < M; j++) {
                    a[i][j] = s.charAt(j) - '0';
                }
                str.append(s);
            }
            if (N == 1 || M == 1) {
                out.printLine(0);
                return;
            }
            if (N >= 4 && M >= 4) {
                out.printLine(-1);
                return;
            }
            if (N > M) {
                int b[][] = new int[M][N];
                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        b[i][j] = a[j][i];
                    }
                }
                a = b;
                N = a.length;
                M = a[0].length;
            }
            int temp[][] = new int[N][M];
            int required[] = new int[M];
            int ans = N * M;
            for (int i = (1 << N) - 1; i >= 0; i--) {
                String s = Integer.toBinaryString(i);
                while (s.length() < N) {
                    s = "0" + s;
                }
                Arrays.fill(required, 0);
                int current = 0;
                for (int j = 0; j < N; j++) {
                    temp[j][0] = s.charAt(j) - '0';
                    if (temp[j][0] != a[j][0]) {
                        current++;
                    }
                }
                for (int x = 1; x < N; x++) {
                    boolean odd = (temp[x][0] + temp[x - 1][0]) % 2 == 0 ? false : true;
                    for (int y = 1; y < M; y++) {
                        odd = !odd;
                        boolean k = (a[x][y] + a[x - 1][y]) % 2 == 1;
                        if (k != odd) {
                            required[y] = 1;
                        }
                    }
                }

                for (int y = 1; y < M; y++) {
                    current += required[y];
                }
                ans = Math.min(ans, current);

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

