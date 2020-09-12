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
            int a[] = new int[N];
            boolean AllNegative = true;
            int counts[] = new int[6001];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
                if (a[i] >= 0) {
                    AllNegative = false;
                }
                counts[a[i] + 3000]++;
            }
            long negatives[] = new long[5], positives[] = new long[5];
            long answer = 1;
            if (AllNegative) {
                int count = 0;
                for (int i = 3000 - 1; i >= 0; i--) {
                    while (counts[i] > 0 && count < 5) {
                        answer *= (i - 3000);
                        count++;
                        counts[i]--;
                    }
                }
                out.printLine(answer);
                return;
            }
            if (N == 5) {
                for (int i = 0; i < N; i++) {
                    answer *= a[i];
                }
                out.printLine(answer);
                return;
            }
            long twoNegative = 0, fourNegative = 0;
            long product = 1, num = 0;
            for (int i = 0; i < 3000; i++) {
                while (counts[i] > 0 && num < 4) {
                    counts[i]--;
                    num++;
                    product *= (i - 3000);
                    if (num == 2) {
                        twoNegative = product;
                    } else if (num == 4) {
                        fourNegative = product;
                    }
                }
            }
            long onePositive = 0, threePositive = 0, fivePositive = 0;
            product = 1;
            num = 0;
            for (int i = 6000; i >= 3000; i--) {
                while (counts[i] > 0 && num < 5) {
                    counts[i]--;
                    num++;
                    product *= (i - 3000);
                    if (num == 1) {
                        onePositive = product;
                    } else if (num == 3) {
                        threePositive = product;
                    } else if (num == 5) {
                        fivePositive = product;
                    }
                }
            }

            answer = Math.max(fivePositive, Math.max(onePositive * fourNegative, threePositive * twoNegative));
            out.printLine(answer);
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

