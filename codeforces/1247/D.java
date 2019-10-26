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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), K = in.nextInt();
            Integer a[] = in.nextIntArray(N);
            Hashtable<BigInteger, Integer> haveTable = new Hashtable<>();
            long ans = 0;
            for (int i = 0; i < N; i++) {
                Hashtable<Integer, Integer> factorization = MathUtils.primeFactorization(a[i]);
                BigInteger have = BigInteger.ONE, need = BigInteger.ONE;
                for (int key : factorization.keySet()) {
                    long val = factorization.get(key) % K;
                    if (val > 0) {
                        have = have.multiply(BigInteger.valueOf((long) Math.pow(key, val)));
                        need = need.multiply(BigInteger.valueOf((long) Math.pow(key, K - val)));
                    }
                }
                if (haveTable.containsKey(need)) {
                    ans += haveTable.get(need);
                }
                if (haveTable.containsKey(have)) {
                    haveTable.put(have, haveTable.get(have) + 1);
                } else {
                    haveTable.put(have, 1);
                }
            }
            out.printLine(ans);
        }

    }

    static class MathUtils {
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

        public Integer[] nextIntArray(int size) {
            Integer array[] = new Integer[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
        }

    }
}

