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
            int K = in.nextInt();
            int X = 262143;
            int Y = 131072;
            int a[][] = new int[][]{{X, K, 0}, {Y, K, 0}, {Y, X, K}};
            int dp[][] = new int[4][4];
            dp[0][0] = a[0][0];
            dp[0][1] = (dp[0][0] & a[0][1]);
            dp[0][2] = (dp[0][1] & a[0][2]);
            dp[1][0] = (dp[0][0] & a[1][0]);
            dp[2][0] = (dp[1][0] & a[2][0]);
            dp[1][1] = Math.max((a[1][1] & dp[0][1]), (a[1][1] & dp[1][0]));
            dp[1][2] = Math.max((a[1][2] & dp[0][2]), (a[1][2] & dp[1][1]));
            dp[2][1] = Math.max((a[2][1] & dp[1][1]), (a[2][1] & dp[2][0]));
            dp[2][2] = Math.max((a[2][2] & dp[1][2]), (a[2][2] & dp[2][1]));
//        DebugUtils.debug(dp[2][2], (X & K));
            out.printLine("3 3");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    out.print(a[i][j] + " ");
                }
                out.printLine();
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

