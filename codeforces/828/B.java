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
            int n = in.nextInt(), m = in.nextInt(), i, j, ans = 0;
            int a[][] = new int[n][m];
            int minY = Integer.MAX_VALUE, maxY = -1, minX = Integer.MAX_VALUE, maxX = -1, count = 0;
            for (i = 0; i < n; i++) {
                String s = in.next();
                for (j = 0; j < m; j++) {
                    a[i][j] = s.charAt(j) == 'B' ? 1 : 0;
                    if (a[i][j] == 1) {
                        minX = Math.min(minX, j);
                        maxX = Math.max(maxX, j);
                        minY = Math.min(minY, i);
                        maxY = Math.max(maxY, i);
                        count++;
                    }
                }
            }
            if (maxY == -1) {
                out.printLine(1);
                return;
            }
            int length = maxY - minY + 1, breadth = maxX - minX + 1, diff = 0, rem = 0;

            if (length > breadth) {
                diff = length - breadth;
                rem = (minX) + (m - maxX - 1);
                breadth = length;
            } else if (breadth > length) {
                diff = breadth - length;
                rem = (minY) + (n - maxY - 1);
                length = breadth;
            }
            //DebugUtils.debug(length, breadth, diff, rem);
            if (rem < diff) {
                out.printLine(-1);
            } else {
                out.printLine(length * breadth - count);
            }
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

