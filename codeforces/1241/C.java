import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
            int Q = in.nextInt();
            while (Q-- > 0) {
                int N = in.nextInt();
                Integer p[] = in.nextIntArray(N);
                for (int i = 0; i < N; i++) {
                    p[i] /= 100;
                }
                int x = in.nextInt(), a = in.nextInt(), y = in.nextInt(), b = in.nextInt();
                long k = in.nextLong();
                Arrays.sort(p, Collections.reverseOrder());
                int low = 0, high = N;
                int ans = Constants.INT_INFINITY;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (possible(mid, p, k, x, a, y, b, N)) {
                        ans = Math.min(ans, mid);
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                if (ans == Constants.INT_INFINITY) {
                    ans = -1;
                }
                out.printLine(ans);
            }
        }

        public boolean possible(int mid, Integer[] prices, long k, int x, int a, int y, int b, int N) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= mid; i++) {
                int q = 0;
                if (i % a == 0) {
                    q += x;
                }
                if (i % b == 0) {
                    q += y;
                }
                if (q > 0) {
                    list.add(q);
                }
            }
            Collections.sort(list, Collections.reverseOrder());
            int i = 0;
            for (long element : list) {
                k -= element * prices[i++];
            }
            return k <= 0;
        }

    }

    static class Constants {
        public static final Integer INT_INFINITY = (int) 2e9;

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

