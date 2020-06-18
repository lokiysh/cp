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
            int a[][] = new int[N][25];
            for (int i = 0; i < N; i++) {
                int x = in.nextInt();
                String s = Integer.toBinaryString(x);
                int p = 25 - 1;
                for (int j = s.length() - 1; j >= 0; j--) {
                    a[i][p] = s.charAt(j) - '0';
                    p--;
                }
            }
            int counts[] = new int[25];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 25; j++) {
                    counts[j] += a[i][j];
                }
            }
            int p[][] = new int[N][25];
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    p[j][i] = 1;
                }
            }
            long answer = 0;
            for (int i = 0; i < N; i++) {
                long current = 0;
                long pow = 1;
                for (int j = 25 - 1; j >= 0; j--) {
                    if (p[i][j] == 1) {
                        current += pow;
                    }
                    pow *= 2;
                }
                answer += current * current;
            }
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

