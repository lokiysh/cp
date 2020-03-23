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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt(), K = in.nextInt();
            int initial[][] = new int[K][2], fin[][] = new int[K][2];
            for (int i = 0; i < K; i++) {
                initial[i][0] = in.nextInt();
                initial[i][1] = in.nextInt();
            }
            for (int i = 0; i < K; i++) {
                fin[i][0] = in.nextInt();
                fin[i][1] = in.nextInt();
            }
            out.printLine((N - 1) + (M - 1) + M * N);
            for (int i = 1; i < N; i++) {
                out.print("U");
            }
            for (int i = 1; i < M; i++) {
                out.print("L");
            }
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    if (i % 2 == 0) {
                        out.print("R");
                    } else {
                        out.print("L");
                    }
                }
                out.print("D");
            }
            out.printLine();
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

