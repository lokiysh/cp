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
import java.math.BigInteger;
import java.io.BufferedReader;
import java.util.Hashtable;
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
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int x = in.nextInt();
            long n = in.nextLong();
            Hashtable<Integer, Integer> primeFactor = MathUtils.primeFactorization(x);
            BigInteger N = BigInteger.valueOf(n);
            long ans = 1;
            for (Integer px : primeFactor.keySet()) {
                long count = 0;
                BigInteger powerBig = BigInteger.valueOf(px);
                BigInteger power = powerBig;
                while (true) {
                    if (power.compareTo(N) > 0) {
                        break;
                    }
                    long z = n / power.longValue();
                    count += z;
                    power = power.multiply(powerBig);
                }
                long m = MathUtils.fastExponentization(px, count);
                ans = (ans * m) % Constants.PRIME_MOD;
            }
            out.printLine(ans);
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

    static class MathUtils {
        public static long fastExponentization(long base, long exp) {
            long result = 1;
            while (exp > 0) {
                if (exp % 2 == 1) {
                    result = (result * base) % Constants.PRIME_MOD;
                }
                base = (base * base) % Constants.PRIME_MOD;
                exp /= 2;
            }
            return result % Constants.PRIME_MOD;
        }

        public static Hashtable<Integer, Integer> primeFactorization(int n) {
            Hashtable<Integer, Integer> table = new Hashtable<>();
            for (int i = 2; i <= n / i; i++) {
                int count = 0;
                while (n % i == 0) {
                    count++;
                    n /= i;
                }
                if (count > 0) {
                    table.put(i, count);
                }
            }
            if (n > 1) {
                table.put(n, 1);
            }
            return table;
        }

    }

    static class Constants {
        public static final long PRIME_MOD = (long) 1e9 + 7;

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

