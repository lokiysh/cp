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
 *
 * @author phantom11
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        boolean possible;
        int K;
        long[] stepsPossible = new long[100];

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long x = in.nextInt(), y = in.nextInt();
            long steps[] = new long[100];
            steps[0] = x;

            recur(x, y, steps, 1);
            if (possible) {
                out.printLine("YES");
                out.printLine(K);
                for (int i = 0; i < K; i++) {
                    out.print(stepsPossible[i] + " ");
                }
            } else {
                out.printLine("NO");
            }
        }

        public void recur(long x, long y, long steps[], int k) {
            if (x == y) {
                possible = true;
                for (int i = 0; i < steps.length; i++) {
                    stepsPossible[i] = steps[i];
                }
                K = k;
                return;
            }
            if (x > y || possible) return;
            steps[k] = 2 * x;
            recur(2 * x, y, steps, k + 1);
            steps[k] = 10 * x + 1;
            recur(10 * x + 1, y, steps, k + 1);
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
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
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

