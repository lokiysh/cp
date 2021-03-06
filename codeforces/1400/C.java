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
        TaskC solver = new TaskC();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String s = in.next();
            int X = in.nextInt();
            int N = s.length();
            int a[] = new int[N];
            Arrays.fill(a, -1);
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) == '0') {
                    if (i - X >= 0) {
                        a[i - X] = 0;
                    }
                    if (i + X < N) {
                        a[i + X] = 0;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) == '1') {
                    boolean found = false;
                    if (i - X >= 0 && a[i - X] != 0) {
                        a[i - X] = 1;
                        found = true;
                    }
                    if (i + X < N && a[i + X] != 0) {
                        a[i + X] = 1;
                        found = true;
                    }
                    if (!found) {
                        out.printLine(-1);
                        return;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (a[i] >= 0) {
                    out.print(a[i]);
                } else {
                    out.print(1);
                }
            }
            out.printLine();
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

