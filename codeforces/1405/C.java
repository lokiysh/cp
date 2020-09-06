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
        TaskC solver = new TaskC();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), K = in.nextInt();
            char c[] = in.next().toCharArray();
            for (int i = 0; i < K; i++) {
                boolean x[] = new boolean[3];
                for (int j = i; j < N; j += K) {
                    if (c[j] == '0') {
                        x[0] = true;
                    } else if (c[j] == '1') {
                        x[1] = true;
                    } else {
                        x[2] = true;
                    }
                }
                if (x[0] && x[1]) {
                    out.printLine("NO");
                    return;
                }
                if (x[0] || x[1]) {
                    char character = x[0] ? '0' : '1';
                    for (int j = i; j < N; j += K) {
                        c[j] = character;
                    }
                }
            }
            if (!check(c, K)) {
                out.printLine("NO");
                return;
            }
            out.printLine("YES");
        }

        public boolean check(char c[], int K) {
            int N = c.length, req = K / 2;
            int zeros = 0, ones = 0;
            for (int i = 0; i < K; i++) {
                if (c[i] == '0') {
                    zeros++;
                } else if (c[i] == '1') {
                    ones++;
                }
            }

            if (zeros > req || ones > req) {
                return false;
            }
            return true;
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

