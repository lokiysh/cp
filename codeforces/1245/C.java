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
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String s = in.next();
            int N = s.length();
            long fib[] = new long[Math.max(4, N + 1)];
            fib[2] = 2;
            fib[3] = 3;
            for (int i = 4; i <= N; i++) {
                fib[i] = (fib[i - 1] + fib[i - 2]) % Constants.PRIME_MOD;
            }
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) == 'm' || s.charAt(i) == 'w') {
                    out.printLine(0);
                    return;
                }
            }

            long ans = 1;
            int i = 0, count = 0;
            char last = ' ';
            while (i < N) {
                if (s.charAt(i) == 'u' || s.charAt(i) == 'n') {
                    last = s.charAt(i);
                    count = 0;
                    while (i < N && s.charAt(i) == last) {
                        count++;
                        i++;
                    }
                    if (count >= 2) {
                        ans = (ans * fib[count]) % Constants.PRIME_MOD;
                    }
                } else {
                    i++;
                }
            }
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

    }
}

