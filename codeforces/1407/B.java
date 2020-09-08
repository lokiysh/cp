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
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            int count[] = new int[1001];
            int max = 0;
            for (int i = 0; i < N; i++) {
                count[in.nextInt()]++;
            }
            for (int i = 1000; i >= 1; i--) {
                if (count[i] > 0) {
                    max = i;
                    break;
                }
            }
            display(count, out, max);
            long maxGCD = max;

            for (int i = 1; i <= 1000; i++) {
                int index = 1;
                long x = 1;
                for (int j = 1; j <= 1000; j++) {
                    if (count[j] > 0) {
                        long g = MathUtils.gcd(maxGCD, j);
                        if (g >= x) {
                            x = g;
                            index = j;
                        }
                    }
                }
                maxGCD = x;
                if (maxGCD == 1) {
                    break;
                }
                max = index;
                display(count, out, max);
            }
            for (int i = 1000; i >= 1; i--) {
                if (count[i] > 0) {
                    display(count, out, i);
                }
            }
            out.printLine();
        }

        public void display(int count[], OutputWriter out, int index) {
            for (int j = 1; j <= count[index]; j++) {
                out.print(index + " ");
            }
            count[index] = 0;
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
        public static long gcd(long a, long b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
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

