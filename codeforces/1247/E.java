import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            int map[][] = new int[N + 2][M + 2];
            for (int i = 1; i <= N; i++) {
                String s = in.next();
                for (int j = 1; j <= M; j++) {
                    map[i][j] = s.charAt(j - 1) == 'R' ? 1 : 0;
                }
            }
            if (map[N][M] == 1) {
                out.printLine(0);
                return;
            }
            if (N == 1 && M == 1) {
                out.printLine(1);
                return;
            }
            int rocksDown[][] = new int[N + 2][M + 2];
            int rocksRight[][] = new int[N + 2][M + 2];
            for (int i = N; i > 0; i--) {
                for (int j = M; j > 0; j--) {
                    rocksRight[i][j] = map[i][j] + rocksRight[i][j + 1];
                    rocksDown[i][j] = map[i][j] + rocksDown[i + 1][j];
                }
            }
            long R[][] = new long[N + 2][M + 2], D[][] = new long[N + 2][M + 2];
            for (int i = N; i > 0; i--) {
                for (int j = M; j > 0; j--) {
                    if (i == N && j == M) {
                        continue;
                    }
                    D[i][j] = D[i + 1][j] + R[i + 1][j];
                    R[i][j] = D[i][j + 1] + R[i][j + 1];
                    if (i + 1 <= N && map[i + 1][j] == 1) {
                        D[i][j] -= R[N + 1 - rocksDown[i + 1][j]][j];
                    }
                    if (j + 1 <= M && map[i][j + 1] == 1) {
                        R[i][j] -= D[i][M + 1 - rocksRight[i][j + 1]];
                    }
                    if (j == M) {
                        D[i][j] = rocksDown[i + 1][j] == 0 ? 1 : 0;
                    }
                    if (i == N) {
                        R[i][j] = rocksRight[i][j + 1] == 0 ? 1 : 0;
                    }
                    D[i][j] = (D[i][j] + Constants.PRIME_MOD) % Constants.PRIME_MOD;
                    R[i][j] = (R[i][j] + Constants.PRIME_MOD) % Constants.PRIME_MOD;
                }
            }
//        DebugUtils.debug(R);
//        DebugUtils.debug(D);
            long ans = (D[1][1] + R[1][1]) % Constants.PRIME_MOD;
            out.printLine(ans);
        }

    }

    static class Constants {
        public static final long PRIME_MOD = (long) 1e9 + 7;

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
}

