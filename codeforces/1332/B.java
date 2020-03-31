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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int T = in.nextInt();
            int factors[] = seiveOfEratosthenes();
            while (T-- > 0) {
                int N = in.nextInt();
                int a[] = new int[N];
                Hashtable<Integer, Integer> colors = new Hashtable<>();
                int c = 1;
                int ans[] = new int[N];
                for (int i = 0; i < N; i++) {
                    a[i] = in.nextInt();
                    if (colors.containsKey(factors[a[i]])) {
                        ans[i] = colors.get(factors[a[i]]);
                    } else {
                        ans[i] = c;
                        colors.put(factors[a[i]], c);
                        c++;
                    }
                }
                out.printLine(c - 1);
                for (int i = 0; i < N; i++) {
                    out.print(ans[i] + " ");
                }
                out.printLine();

            }

        }

        public int[] seiveOfEratosthenes() {
            int N = (int) 1e3 + 1;
            int smallestPrimeFactor[] = new int[N];
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

