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
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            long k = in.nextLong();
            Integer a[] = in.nextIntArray(N);
            Arrays.sort(a);
            int i = 0, j = N - 1;
            int minDifference = a[j] - a[i];
            while (k > 0) {
                while (i < N - 1 && a[i] == a[i + 1]) {
                    i++;
                }
                while (j > 0 && a[j] == a[j - 1]) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                if (i + 1 < N - j) {
                    long c = a[i + 1] - a[i];
                    if (k < c * (i + 1)) {
                        minDifference -= k / (i + 1);
                        break;
                    }
                    k -= c * (i + 1);
                    i++;
                    minDifference = a[j] - a[i];
                } else {
                    long c = a[j] - a[j - 1];
                    if (k < c * (N - j)) {
                        minDifference -= k / (N - j);
                        break;
                    }
                    k -= c * (N - j);
                    j--;
                    minDifference = a[j] - a[i];
                }
            }
            out.printLine(minDifference);
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

        public Integer[] nextIntArray(int size) {
            Integer array[] = new Integer[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
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

