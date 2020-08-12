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
        Taskc solver = new Taskc();
        solver.solve(1, in, out);
        out.close();
    }

    static class Taskc {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            int a[] = new int[N], b[] = new int[M];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < M; i++) {
                b[i] = in.nextInt();
            }
            int ands[][] = new int[N][M];
            boolean zeros[] = new boolean[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    ands[i][j] = a[i] & b[j];
                    if (ands[i][j] == 0) {
                        zeros[i] = true;
                    }
                }
            }
            boolean allZeros = true;
            for (int i = 0; i < N; i++) {
                if (!zeros[i]) {
                    allZeros = false;
                    break;
                }
            }
            if (allZeros) {
                out.printLine(0);
                return;
            }
            for (int i = 1; i < 512; i++) {
                boolean found = true;

                for (int j = 0; j < N; j++) {
                    boolean foundInRow = false;
                    for (int k = 0; k < M; k++) {
                        if ((ands[j][k] & i) == ands[j][k]) {
                            foundInRow = true;
                            break;
                        }
                    }
                    if (!foundInRow) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    out.printLine(i);
                    return;
                }
            }
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

