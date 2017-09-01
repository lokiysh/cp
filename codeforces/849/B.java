import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), i, j;
            Integer a[] = in.nextIntArray(n);
            int yDiff = a[2] - a[1];
            int xDiff = 1;
            boolean status = true;
            for (i = 3; i < n; i++) {
                if (a[i] - a[i - 1] != yDiff) {
                    status = false;
                    break;
                }
            }
            if (status && a[1] - a[0] != yDiff) {
                out.printLine("Yes");
                //DebugUtils.debug("1");
                return;
            }
            double slopes[] = new double[n];
            for (i = 1; i < n; i++) {
                slopes[i] = (double) (a[i] - a[0]);
                slopes[i] /= i;
            }
            //DebugUtils.debug(slopes);
            for (i = 1; i < n; i++) {
                ArrayList<Integer> line2 = new ArrayList<>();
                int count = 0;
                for (j = 1; j < n; j++) {
                    if (j != i && slopes[i] != slopes[j]) {
                        line2.add(j);
                        count++;
                    }
                }

                if (count == 1) {
                    out.printLine("Yes");
                    //DebugUtils.debug("2", i, line2);
                    return;
                }
                if (count > 1) {
                    double slope = a[line2.get(1)] - a[line2.get(0)];
                    slope /= line2.get(1) - line2.get(0);
                    if (slope == slopes[i]) {
                        status = true;
                        for (j = 2; j < count; j++) {
                            double k = a[line2.get(j)] - a[line2.get(0)];
                            k /= line2.get(j) - line2.get(0);
                            if (k != slope) {
                                status = false;
                                break;
                            }
                        }
                        if (status) {
                            out.printLine("Yes");
                            //DebugUtils.debug("3", i);
                            return;
                        }
                    }
                }
            }
            out.printLine("No");
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

