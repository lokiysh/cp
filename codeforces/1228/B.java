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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int h = in.nextInt(), w = in.nextInt();
            int a[][] = new int[h][w];
            Integer r[] = in.nextIntArray(h);
            Integer c[] = in.nextIntArray(w);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < r[i]; j++) {
                    a[i][j] = 1;
                }
                if (r[i] < w) {
                    a[i][r[i]] = 2;
                }
            }
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < c[i]; j++) {
                    if (a[j][i] == 2) {
                        out.printLine(0);
                        return;
                    }
                    a[j][i] = 1;
                }
                if (c[i] < h) {
                    if (a[c[i]][i] == 1) {
                        out.printLine(0);
                        return;
                    }
                    a[c[i]][i] = 2;
                }
            }
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (a[i][j] == 0) {
                        count++;
                    }
                }
            }
            out.printLine(MathUtils.fastExponentization(2, count));
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

        public Integer[] nextIntArray(int size) {
            Integer array[] = new Integer[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
        }

    }
}

