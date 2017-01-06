import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
            int a[][] = new int[4][4];
            int i, j, k;
            for (i = 0; i < 4; i++) {
                String s = in.next();
                for (j = 0; j < 4; j++) {
                    a[i][j] = s.charAt(j) == 'x' ? 1 : (s.charAt(j) == 'o' ? -11 : 0);
                }
            }
            String ans = "NO";
            for (i = 0; i < 4; i++) {
                for (j = 0; j <= 1; j++) {
                    if (a[i][j] + a[i][j + 1] + a[i][j + 2] == 2) {
                        ans = "YES";
                    }
                }
            }
            for (i = 0; i < 4; i++) {
                for (j = 0; j <= 1; j++) {
                    if (a[j][i] + a[j + 1][i] + a[j + 2][i] == 2) {
                        ans = "YES";
                    }
                }
            }
            if (a[0][1] + a[1][2] + a[2][3] == 2 || a[0][2] + a[1][1] + a[2][0] == 2) {
                ans = "YES";
            }
            if (a[1][0] + a[2][1] + a[3][2] == 2 || a[1][3] + a[2][2] + a[3][1] == 2) {
                ans = "YES";
            }
            if (a[0][0] + a[1][1] + a[2][2] == 2 || a[1][1] + a[2][2] + a[3][3] == 2) {
                ans = "YES";
            }
            if (a[0][3] + a[1][2] + a[2][1] == 2 || a[1][2] + a[2][1] + a[3][0] == 2) {
                ans = "YES";
            }
            out.printLine(ans);
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

