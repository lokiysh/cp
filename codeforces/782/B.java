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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), x[] = new int[n], v[] = new int[n];
            int i;
            for (i = 0; i < n; i++) {
                x[i] = in.nextInt();
            }
            for (i = 0; i < n; i++) {
                v[i] = in.nextInt();
            }
            double low = 0, high = 2e9, mid, ans = high, limit = 1e-6;
            int times = 0;
            while ((high - low) > limit) {
                times++;
                mid = (low + high) / 2;
                if (check(mid, v, x)) {
                    high = mid;
                    ans = Math.min(ans, high);
                } else {
                    low = mid;
                }
            }
            out.printLine(ans);
        }

        public boolean check(double time, int v[], int x[]) {
            double minX = Double.MAX_VALUE, maxX = Double.MAX_VALUE, curLeft, curRight;
            int i, n = v.length;
            for (i = 0; i < n; i++) {
                curLeft = x[i] - v[i] * time;
                curRight = x[i] + v[i] * time;
                if (i == 0) {
                    minX = curLeft;
                    maxX = curRight;
                } else {
                    if (curLeft > maxX || curRight < minX) {
                        return false;
                    }
                    minX = Math.max(minX, curLeft);
                    maxX = Math.min(maxX, curRight);
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

