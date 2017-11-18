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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            Integer A[] = in.nextIntArray(N);
            int i;
            long gcd = A[0];
            for (i = 1; i < N; i++) {
                gcd = IntegerUtils.gcd(gcd, A[i]);
            }
            if (gcd > 1) {
                out.printLine(-1);
                return;
            }
            if (N == 1) {
                out.printLine(0);
                return;
            }
            int hasOne = 0;
            for (i = 0; i < N; i++) {
                if (A[i] == 1) {
                    hasOne++;
                }
            }
            if (hasOne > 0) {
                out.printLine(N - hasOne);
                return;
            }
            int j, ans = Integer.MAX_VALUE;
            for (i = 0; i < N; i++) {
                gcd = A[i];
                for (j = i + 1; j < N; j++) {
                    gcd = IntegerUtils.gcd(gcd, A[j]);
                    if (gcd == 1) {
                        ans = Math.min(ans, j - i - 1);
                        break;
                    }
                }
            }
            out.printLine(ans + N);

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

    static class IntegerUtils {
        public static long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
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
}

