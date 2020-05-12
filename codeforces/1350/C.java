import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.util.Collections;
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
            int N = in.nextInt();
            int a[] = new int[N];
            a[0] = in.nextInt();
            long gcd = a[0];
            for (int i = 1; i < N; i++) {
                a[i] = in.nextInt();
                gcd = MathUtils.gcd(gcd, a[i]);
            }
            for (int i = 0; i < N; i++) {
                a[i] /= gcd;
            }
            Hashtable<Long, Integer> frquency = new Hashtable<>();
            for (int i = 0; i < N; i++) {
                Hashtable<Long, Integer> fact = MathUtils.primeFactorization(a[i]);
                for (long key : fact.keySet()) {
                    int value = fact.get(key);
                    long p = 1;
                    for (int j = 1; j <= value; j++) {
                        p *= key;
                        if (frquency.containsKey(p)) {
                            frquency.put(p, frquency.get(p) + 1);
                        } else {
                            frquency.put(p, 1);
                        }
                    }
                }
            }
            List<Long> possible = new ArrayList<>();
            for (long key : frquency.keySet()) {
                if (frquency.get(key) >= N - 1) {
                    possible.add(key);
                }
            }
            Collections.sort(possible);
            int size = possible.size();
            for (int i = 0; i < size; i++) {
                boolean status = true;
                for (int j = i + 1; j < size; j++) {
                    if (possible.get(j) % possible.get(i) == 0) {
                        status = false;
                        break;
                    }
                }
                if (status) {
                    gcd *= possible.get(i);
                }
            }
            out.printLine(gcd);
        }

    }

    static class MathUtils {
        public static long gcd(long a, long b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        public static Hashtable<Long, Integer> primeFactorization(long n) {
            Hashtable<Long, Integer> table = new Hashtable<>();
            for (long i = 2; i <= n / i; i++) {
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

