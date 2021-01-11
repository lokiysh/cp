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
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            char start = in.next().charAt(0), end = in.next().charAt(0);
            int n = in.nextInt() % 4;
            char a[] = new char[]{'^', '>', 'v', '<'};
            int cw = 0, ccw = 0;
            int sIndex = 0, eIndex = 0;
            for (int i = 0; i < 4; i++) {
                if (a[i] == start) {
                    sIndex = i;
                }
            }

            for (int i = 0; i < 4; i++) {
                if (a[i] == end) {
                    eIndex = i;
                }
            }
            int p = sIndex, q = n;
            while (q > 0) {
                q--;
                p++;
                if (p == 4) {
                    p = 0;
                }
            }
            if (p == eIndex) {
                cw = 1;
            }
            p = sIndex;
            q = n;
            while (q > 0) {
                q--;
                p--;
                if (p == -1) {
                    p = 3;
                }
            }
            if (p == eIndex) {
                ccw = 1;
            }
            if (cw == 1 && ccw == 1) {
                out.printLine("undefined");
            } else if (cw == 1) {
                out.printLine("cw");
            } else {
                out.printLine("ccw");
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

