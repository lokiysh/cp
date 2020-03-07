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
            int N = in.nextInt(), M = in.nextInt(), K = in.nextInt();
            int a[] = new int[N], b[] = new int[M];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < M; i++) {
                b[i] = in.nextInt();
            }
            long lengthA[] = construct(a);
            long lengthB[] = construct(b);
            long ans = 0;
            for (int row = 1; row * row <= K; row++) {
                if (row > N) {
                    break;
                }
                if (K % row == 0) {
                    int required = K / row;
                    ans += find(lengthA, row) * find(lengthB, required);
                    if (row != required) {
                        ans += find(lengthA, required) * find(lengthB, row);
                    }
                }
            }
            out.printLine(ans);
        }

        public long[] construct(int a[]) {
            int N = a.length;
            int count = 0;
            long lengths[] = new long[N + 1];
            for (int i = 0; i < N; i++) {
                if (a[i] == 0 && count > 0) {
                    lengths[count]++;
                    count = 0;
                } else if (a[i] == 1) {
                    count++;
                }
            }
            if (count > 0) {
                lengths[count]++;
            }
            return lengths;
        }

        public long find(long a[], int req) {
            int N = a.length;
            long count = 0;
            for (int i = req; i < N; i++) {
                count += a[i] * (i - req + 1);
            }
            return count;
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

