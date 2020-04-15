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
        TaskD solver = new TaskD();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int R = in.nextInt(), B = in.nextInt(), G = in.nextInt();
            long r[] = new long[R], b[] = new long[B], g[] = new long[G];
            for (int i = 0; i < R; i++) {
                r[i] = in.nextInt();
            }
            for (int i = 0; i < B; i++) {
                b[i] = in.nextInt();
            }
            for (int i = 0; i < G; i++) {
                g[i] = in.nextInt();
            }
            Arrays.sort(r);
            Arrays.sort(b);
            Arrays.sort(g);
            long x = Math.min(find(r, b, g), find(b, r, g));
            x = Math.min(find(g, r, b), x);
            out.printLine(x);
        }

        public long find(long a[], long b[], long c[]) {
            int N = a.length;
            long ans = Long.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                long p = a[i];
                long q = findLess(b, p), r = findMore(c, p);
                if (q > 0 && r > 0) {
                    ans = Math.min(findValue(p, q, r), ans);
                }
                q = findMore(b, p);
                r = findLess(c, p);
                if (q > 0 && r > 0) {
                    ans = Math.min(findValue(p, q, r), ans);
                }
            }
            return ans;
        }

        public long findValue(long p, long q, long r) {
            return (p - q) * (p - q) + (p - r) * (p - r) + (q - r) * (q - r);
        }

        public long findLess(long a[], long val) {
            int low = 0, high = a.length - 1;
            long ans = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (a[mid] > val) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                    if (ans == -1) {
                        ans = a[mid];
                    } else if (val - ans > val - a[mid]) {
                        ans = a[mid];
                    }
                }
            }
            return ans;
        }

        public long findMore(long a[], long val) {
            int low = 0, high = a.length - 1;
            long ans = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (a[mid] < val) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                    if (ans == -1) {
                        ans = a[mid];
                    } else if (ans - val > a[mid] - val) {
                        ans = a[mid];
                    }
                }
            }
            return ans;
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

