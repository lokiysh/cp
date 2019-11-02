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
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int array[] = new int[100];
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < 10; j++) {
                    int k = in.nextInt();
                    if (i % 2 == 0) {
                        int index = i * 10 + j;
                        if (k % 2 == 0) {
                            array[index] = index + k * 10;
                        } else {
                            array[index] = index + (k + 1) * 10 - 2 * (j + 1) + 1;
                        }
                    } else {
                        int index = (i + 1) * 10 - j - 1;
                        if (k % 2 == 0) {
                            array[index] = index + k * 10;
                        } else {
                            array[index] = index + (k - 1) * 10 + 2 * (j + 1) - 1;
                        }
                    }
                }
            }
            double dp[] = new double[100];
            dp[99] = 0;
            for (int i = 98; i >= 0; i--) {
                dp[i] = 1;
                for (int r = 1; r <= 6; r++) {
                    if (i + r >= 100) {
                        continue;
                    }
                    dp[i] += Math.min(dp[i + r], dp[array[i + r]]) / 6.0;
                }
                if (i >= 94) {
                    dp[i] *= 6.0 / (99 - i);
                }
            }
            out.printLine(dp[0]);
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

    }
}

