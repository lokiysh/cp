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
            int n = in.nextInt(), k = in.nextInt();
            int a[] = new int[4];
            int i;
            int four = n, two = 2 * n;
            String ans = "YES";
            for (i = 0; i < k; i++) {
                int x = in.nextInt();
                int p = x / 4;
                a[x % 4]++;
                if (four >= p) {
                    four -= p;
                } else {
                    p -= four;
                    four = 0;
                    if (two >= 2 * p) {
                        two -= 2 * p;
                    } else {
                        ans = "NO";
                    }
                }
            }
            if (four >= a[3]) {
                four -= a[3];
            } else {
                a[3] -= four;
                four = 0;
                if (two >= 2 * a[3]) {
                    two -= 2 * a[3];
                } else {
                    ans = "NO";
                }
            }
            two += four;
            int one = four;
            four = 0;
            if (two >= a[2]) {
                two -= a[2];
            } else {
                a[2] -= two;
                two = 0;
                if (one >= 2 * a[2]) {
                    one -= 2 * a[2];
                } else {
                    ans = "NO";
                }
            }
            if (two + one < a[1]) {
                ans = "NO";
            }
            out.printLine(ans);


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

