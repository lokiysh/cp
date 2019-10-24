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
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String s = in.next();
            int N = s.length();
            int odd = N, even = N;
            for (int i = 0; i < N; i++) {
                if (even == N && (s.charAt(i) - '0') % 2 == 0) {
                    even = i;
                } else if (odd == N && (s.charAt(i) - '0') % 2 == 1) {
                    odd = i;
                }
            }

            StringBuilder str = new StringBuilder();
            int num = 0;
            while (num < N) {
                if (odd == N) {
                    str.append(s.charAt(even));
                    even = nextIndex(s, 0, even + 1, N);
                    num++;
                } else if (even == N) {
                    str.append(s.charAt(odd));
                    odd = nextIndex(s, 1, odd + 1, N);
                    num++;
                } else if (s.charAt(even) < s.charAt(odd)) {
                    str.append(s.charAt(even));
                    even = nextIndex(s, 0, even + 1, N);
                    num++;
                } else {
                    str.append(s.charAt(odd));
                    odd = nextIndex(s, 1, odd + 1, N);
                    num++;
                }
            }
            out.printLine(str);
        }

        public int nextIndex(String s, int parity, int index, int N) {
            for (int i = index; i < N; i++) {
                if ((s.charAt(i) - '0') % 2 == parity) {
                    return i;
                }
            }
            return N;
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

    }
}

