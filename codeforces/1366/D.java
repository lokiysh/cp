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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            Integer[] smallestPrimeFactor = MathUtils.seiveOfEratosthenes();
            int first[] = new int[N];
            int second[] = new int[N];
            for (int i = 0; i < N; i++) {
                int a = in.nextInt();
                if (smallestPrimeFactor[a] == a) {
                    first[i] = -1;
                    second[i] = -1;
                }
                int k = smallestPrimeFactor[a];
                while (a > 1 && a % k == 0) {
                    a /= k;
                }
                if (a == 1) {
                    first[i] = -1;
                    second[i] = -1;
                } else {
                    first[i] = k;
                    second[i] = a;
                }
            }
            for (int i = 0; i < N; i++) {
                out.print(first[i] + " ");
            }
            out.printLine();
            for (int i = 0; i < N; i++) {
                out.print(second[i] + " ");
            }
            out.printLine();
        }

    }

    static class MathUtils {
        public static Integer[] seiveOfEratosthenes() {
            int N = (int) 1e7 + 1;
            Integer smallestPrimeFactor[] = new Integer[N];
            smallestPrimeFactor[1] = 1;
            for (int i = 2; i < smallestPrimeFactor.length; i++) {
                if (i % 2 == 0) {
                    smallestPrimeFactor[i] = 2;
                } else {
                    smallestPrimeFactor[i] = i;
                }
            }

            int limit = (int) Math.sqrt(N) + 1;
            for (int i = 3; i < limit; i += 2) {
                if (smallestPrimeFactor[i] == i) {
                    for (int j = i * i; j < N; j += i) {
                        if (smallestPrimeFactor[j] == j) {
                            smallestPrimeFactor[j] = i;
                        }
                    }
                }
            }
            return smallestPrimeFactor;
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

