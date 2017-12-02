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
 *
 * @author phantom11
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
            int n = in.nextInt(), m = in.nextInt(), c = in.nextInt(), i, j;
            int a[] = new int[n];
            Arrays.fill(a, -1);
            for (i = 0; i < m; i++) {
                int k = in.nextInt();
                int ans = -1;
                if (k * 2 <= c) {
                    for (j = 0; j < n; j++) {
                        if (a[j] > k || a[j] == -1) {
                            ans = j;
                            break;
                        }
                    }
                } else {
                    for (j = n - 1; j >= 0; j--) {
                        if (a[j] == -1 || a[j] < k) {
                            ans = j;
                            break;
                        }
                    }
                }
                if (ans == -1) {
                    ans = n - 1;
                }
                a[ans] = k;
                out.printLine(ans + 1);
                out.flush();
                if (isWinning(a)) {
                    break;
                }
            }
        }

        public boolean isWinning(int a[]) {
            if (a[0] == -1) {
                return false;
            }
            for (int i = 1; i < a.length; i++) {
                if (a[i] == -1 || a[i] < a[i - 1]) {
                    return false;
                }
            }
            return true;
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

        public void flush() {
            writer.flush();
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

