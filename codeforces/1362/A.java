import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
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
            long a = in.nextLong(), b = in.nextLong();
            HashSet<Long> set = new HashSet<>();
            int operations = 0;
            set.add(a);
            while (a != b) {
                boolean found = false;
                if (a < b) {
                    for (int i = 8; i >= 2; i /= 2) {
                        if (a * i <= b) {
                            a *= i;
                            if (set.contains(a)) {
                                out.printLine(-1);
                                return;
                            }
                            found = true;
                            operations++;
                            set.add(a);
                            break;
                        }
                    }
                } else {
                    for (int i = 8; i >= 2; i /= 2) {
                        if (a % i == 0 && a / i >= b) {
                            a /= i;
                            if (set.contains(a)) {
                                out.printLine(-1);
                                return;
                            }
                            found = true;
                            operations++;
                            set.add(a);
                            break;
                        }
                    }
                }
                if (!found) {
                    out.printLine(-1);
                    return;
                }
            }
            out.printLine(operations);
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

