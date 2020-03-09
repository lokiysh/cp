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
        long MOD = 998244353;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            if (N == 2) {
                out.printLine(0);
                return;
            }

            long[] factorials = new long[M + 1];
            long twoPow[] = new long[M + 1];
            factorials[0] = 1;
            for (int i = 1; i <= M; i++) {
                factorials[i] = (factorials[i - 1] * i) % MOD;
            }
            twoPow[0] = 1;
            for (int i = 1; i <= M; i++) {
                twoPow[i] = (twoPow[i - 1] * 2) % MOD;
            }
            long ans = 0;
            for (int i = N - 1; i <= M; i++) {
                long p = factorials[i - 1];
                p = (p * extendedGcd(factorials[N - 2], MOD)[1]) % MOD;
                p = (p * extendedGcd(factorials[i - 1 - N + 2], MOD)[1]) % MOD;
                p = (p * (N - 2)) % MOD;
//            p = (p * (N - 2)) % MOD;
                p = (p * twoPow[N - 3]) % MOD;
                ans = (ans + p) % MOD;
            }
            out.printLine(ans);
        }

        public Long[] extendedGcd(long p, long q) {
            if (q == 0) {
                return new Long[]{p, 1L, 0L};
            }

            Long array[] = extendedGcd(q, p % q);
            long d = array[0] % MOD;
            long a = array[2] % MOD;
            long b = (array[1] % MOD) - (p / q) * a;
            while (b < 0) {
                b += MOD;
            }
            return new Long[]{d, a, b};
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

