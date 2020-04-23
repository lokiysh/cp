import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        int[][] dp;
        int[][] required;
        int[] num;
        boolean status;
        String largest;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), K = in.nextInt();
            String s[] = new String[N];
            String numbers[] = {"1110111", "0010010", "1011101", "1011011", "0111010", "1101011", "1101111", "1010010", "1111111", "1111011"};
            for (int i = 0; i < N; i++) {
                s[i] = in.next();
            }
            required = new int[N][10];
            int mins[] = new int[N];
            int total = 0;
            dp = new int[N][K + 1];
            num = new int[N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], -1);
            }
            status = false;
            Arrays.fill(mins, Integer.MAX_VALUE);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 10; j++) {
                    required[i][j] = howManyMore(s[i], numbers[j]);
                    if (required[i][j] != -1) {
                        mins[i] = Math.min(mins[i], required[i][j]);
                    }
                }
                if (mins[i] == Integer.MAX_VALUE) {
                    out.printLine(-1);
                    return;
                }
                total += mins[i];
            }
            if (total > K) {
                out.printLine(-1);
                return;
            }
            recur(0, K);
            if (status) {
                out.printLine(largest);
            } else {
                out.printLine(-1);
            }

        }

        public boolean recur(int index, int remaining) {
            if (status) {
                return true;
            }
            if (index == dp.length - 1) {
                for (int i = 9; i >= 0; i--) {
                    if (required[index][i] == remaining) {
                        num[index] = i;
                        status = true;
                        StringBuilder large = new StringBuilder();
                        for (int j = 0; j < dp.length; j++) {
                            large.append(num[j]);
                        }
                        largest = large.toString();
                        return true;
                    }
                }
                return false;
            }
            if (dp[index][remaining] != -1) {
                return dp[index][remaining] == -2 ? false : true;
            }

            for (int i = 9; i >= 0; i--) {
                if (required[index][i] != -1 && remaining >= required[index][i]) {
                    num[index] = i;
                    boolean p = recur(index + 1, remaining - required[index][i]);
                    if (p) {
                        dp[index][remaining] = 0;
                        return true;
                    }
                }
            }
            dp[index][remaining] = -2;
            return dp[index][remaining] == -2 ? false : true;
        }

        public int howManyMore(String initial, String fin) {
            int c = 0;
            for (int i = 0; i < 7; i++) {
                if (initial.charAt(i) == '1' && fin.charAt(i) == '0') {
                    return -1;
                }
                if (initial.charAt(i) == '0' && fin.charAt(i) == '1') {
                    c++;
                }
            }
            return c;
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

