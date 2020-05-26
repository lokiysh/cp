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
            int N = in.nextInt();
            long X = in.nextLong();
            long d[] = new long[N];
            long monthHugs[] = new long[N];
            for (int i = 0; i < N; i++) {
                d[i] = in.nextInt();
                monthHugs[i] = (d[i] * (d[i] + 1)) / 2;
            }
            long ans = 0;
            int index = N - 1;
            long c = 0;
            long lastMonth = 0;
            int lastMonthIndex = 0;
            while (c < X) {
                if ((X - c) >= d[index]) {
                    c += d[index];
                    ans += monthHugs[index];
                    lastMonthIndex = index;
                    index--;
                } else {
                    ans += lastX(X - c, d[index]);
                    lastMonth = d[index] - (X - c);
                    lastMonthIndex = index;

                    break;
                }
            }
            long prev = ans;
            for (int i = N - 2; i >= 0; i--) {
                long current = prev - monthHugs[i + 1];
                c = d[i + 1];
                if (lastMonth >= c) {
                    current += lastX(c, lastMonth);
                    lastMonth -= c;
                    if (lastMonth == 0) {
                        lastMonthIndex = (lastMonthIndex - 1 + N) % N;
                        lastMonth = d[lastMonthIndex];
                    }
                } else {
                    current += (lastMonth * (lastMonth + 1)) / 2;
                    c -= lastMonth;
                    lastMonthIndex = (lastMonthIndex - 1 + N) % N;
                    lastMonth = d[lastMonthIndex];
                    while (c > 0) {
                        if (d[lastMonthIndex] <= c) {
                            c -= d[lastMonthIndex];
                            current += monthHugs[lastMonthIndex];
                            lastMonthIndex = (lastMonthIndex - 1 + N) % N;
                            if (c == 0) {
                                lastMonth = d[lastMonthIndex];
                            }
                        } else {
                            current += lastX(c, d[lastMonthIndex]);
                            lastMonth = d[lastMonthIndex] - c;
                            break;
                        }
                    }
                }
                ans = Math.max(ans, current);
                prev = current;
            }
            out.printLine(ans);

        }

        public long lastX(long x, long n) {
            long total = (n * (n + 1)) / 2;
            long prev = ((n - x) * (n - x + 1)) / 2;
            return total - prev;
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

