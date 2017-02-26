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
            String X = in.next(), Y = in.next();
            int n = X.length(), i, a[] = new int[n];
            for (i = n - 1; i >= 0; i--) {
                a[i] = in.nextInt() - 1;
            }
            int low = Y.length(), high = n, mid, times = 0, ans = n;
            while (low <= high && times <= 50) {
                times++;
                mid = (low + high) / 2;
                if (check(mid, a, X, Y)) {
                    high = mid - 1;
                    ans = Math.min(ans, mid);
                } else {
                    low = mid + 1;
                }
            }
            //DebugUtils.debug(ans);
            out.printLine(n - ans);

        }

        public boolean check(int x, int a[], String X, String Y) {
            StringBuilder s = new StringBuilder("");
            int i, y = Y.length();
            int p = 0;
            int n[] = new int[x];
            for (i = 0; i < x; i++) {
                n[i] = a[i];
            }
            Arrays.sort(n);
            int match = 0;
            for (i = 0; i < y; i++) {
                while (p < x && X.charAt(n[p]) != Y.charAt(i)) {
                    p++;
                }
                if (p < x && X.charAt(n[p]) == Y.charAt(i)) {
                    match++;
                }
                p++;
            }
            //DebugUtils.debug(x, p);
            return match >= y;
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

