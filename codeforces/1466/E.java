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
        TaskE solver = new TaskE();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            long a[] = new long[N];
            int bitCount[] = new int[60];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextLong();
                for (int j = 0; j < 60; j++) {
                    bitCount[j] += (a[i] & (1L << j)) > 0 ? 1 : 0;
                }
            }

            long MOD = (long) (Math.pow(10, 9)) + 7;

            long ans = 0;
            for (int i = 0; i < N; i++) {
                long p = calcAnd(bitCount, a[i], MOD);
                long q = calcOr(bitCount, a[i], MOD, N);
                ans += (p * q);
                ans %= MOD;
            }
            out.printLine(ans);
        }

        public long calcAnd(int bitCount[], long q, long mod) {
            long ans = 0;
            for (int i = 0; i < 60; i++) {
                if (((1L << i) & q) > 0) {
                    long k = (1L << i) % mod;
                    ans += bitCount[i] * k;
                    ans %= mod;
                }
            }
            return ans;
        }

        public long calcOr(int bitCount[], long q, long mod, int N) {
            long ans = 0;
            for (int i = 0; i < 60; i++) {
                long k = (1L << i) % mod;
                if (((1L << i) & q) > 0) {
                    ans += N * k;
                } else {
                    ans += bitCount[i] * k;
                }
                ans %= mod;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

