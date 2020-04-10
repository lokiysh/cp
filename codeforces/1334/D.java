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
        TaskD solver = new TaskD();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            long L = in.nextLong(), R = in.nextLong();
            long index = 1, increment = 2 * (N - 1), num = 1, right = -1;
            while (index < L) {
                if (index + increment <= L) {
                    index += increment;
                    increment -= 2;
                    num++;
                } else {
                    right = num + 1;
                    while (index < L) {
                        if (L - index >= 2) {
                            index += 2;
                            right++;
                        } else {
                            index += 2;
                            out.print(right + " ");
                            right++;
                        }
                    }
                    for (long i = right; i <= N; i++) {
                        if (index > R) {
                            out.printLine();
                            return;
                        }
                        out.print(num + " ");
                        index++;
                        if (index > R) {
                            out.printLine();
                            return;
                        }
                        out.print(i + " ");
                        index++;
                    }
                    num++;
                    break;
                }
            }
            for (long i = num; i < N; i++) {
                for (long j = i + 1; j <= N; j++) {
                    if (index > R) {
                        out.printLine();
                        return;
                    }
                    out.print(i + " ");
                    index++;
                    if (index > R) {
                        out.printLine();
                        return;
                    }
                    out.print(j + " ");
                    index++;
                }
            }

            if (index <= R) {
                out.print("1");
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

