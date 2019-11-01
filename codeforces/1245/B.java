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
        TaskB solver = new TaskB();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
            String s = in.next();
            char ans[] = new char[N];
            Arrays.fill(ans, ' ');
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) == 'R') {
                    if (b > 0) {
                        ans[i] = 'P';
                        b--;
                        count++;
                    }
                } else if (s.charAt(i) == 'P') {
                    if (c > 0) {
                        ans[i] = 'S';
                        c--;
                        count++;
                    }
                } else {
                    if (a > 0) {
                        ans[i] = 'R';
                        a--;
                        count++;
                    }
                }
            }
            if (count >= (int) Math.ceil(N / 2.0)) {
                out.printLine("YES");
                for (int i = 0; i < N; i++) {
                    if (ans[i] == ' ') {
                        if (a > 0) {
                            ans[i] = 'R';
                            a--;
                        } else if (b > 0) {
                            ans[i] = 'P';
                            b--;
                        } else {
                            ans[i] = 'S';
                            c--;
                        }
                    }
                    out.print(ans[i]);
                }
                out.printLine();
            } else {
                out.printLine("NO");
            }
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

