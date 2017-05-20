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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), i;
            Item a[] = new Item[n];
            for (i = 0; i < n; i++) {
                a[i] = new Item(in.nextInt());
            }
            Arrays.sort(a);
            long MOD = (long) 1e9 + 7;
            long pow[] = new long[n];

            pow[0] = 1;
            for (i = 1; i < n; i++) {
                pow[i] = (pow[i - 1] * 2) % MOD;
            }
            if (n == 1) {
                out.printLine(0);
                return;
            }
            int diffL = 0, diffR = n - 1;
            int left = 0, right = n - 1;
            long ans = 0;
            long multiplier = (pow[n - 1] - 1 + MOD) % MOD;
            while (left < right) {
                //DebugUtils.debug(multiplier);
                ans += a[right].x * multiplier;
                ans -= a[left].x * multiplier;
                while (ans < 0) {
                    ans += MOD;
                }
                ans %= MOD;
                multiplier -= pow[left];
                multiplier -= pow[right - 1];
                while (multiplier < 0) {
                    multiplier += MOD;
                }
                left++;
                right--;
            }
            out.printLine(ans);
        }

        class Item implements Comparable<Item> {
            int x;

            public Item(int x) {
                this.x = x;
            }

            public int compareTo(Item p) {
                return this.x - p.x;
            }

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

