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
        TaskF solver = new TaskF();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskF {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long dp[][][][][] = new long[32][2][2][2][2];
            int l = in.nextInt(), r = in.nextInt();
            int L[] = new int[32], R[] = new int[32];
            for (int i = 0; i < 32; i++) {
                L[i] = (l >> i) & 1;
                R[i] = (r >> i) & 1;
            }
            dp[31][0][0][0][0] = 1;
            long ans = 0;
            for (int i = 31; i >= 0; i--) {
                for (int firstLarger = 0; firstLarger <= 1; firstLarger++) {
                    for (int firstSmaller = 0; firstSmaller <= 1; firstSmaller++) {
                        for (int secondLarger = 0; secondLarger <= 1; secondLarger++) {
                            for (int secondSmaller = 0; secondSmaller <= 1; secondSmaller++) {
                                if (i == 0) {
                                    ans += dp[i][firstLarger][firstSmaller][secondLarger][secondSmaller];
                                } else {
                                    int nextBit = i - 1;
                                    for (int a = 0; a <= 1; a++) {
                                        for (int b = 0; b <= 1; b++) {
                                            if (a == 1 && b == 1) continue;
                                            if (firstLarger == 0 && L[nextBit] == 1 && a == 0) continue;
                                            if (secondLarger == 0 && L[nextBit] == 1 && b == 0) continue;
                                            if (firstSmaller == 0 && R[nextBit] == 0 && a == 1) continue;
                                            if (secondSmaller == 0 && R[nextBit] == 0 && b == 1) continue;
                                            long x = dp[i][firstLarger][firstSmaller][secondLarger][secondSmaller];
                                            if (a == 0 && b == 0) {
                                                int nextFirstIsSmaller = (firstSmaller == 1 || R[nextBit] == 1) ? 1 : 0;
                                                int nextSecondIsSmaller = (secondSmaller == 1 || R[nextBit] == 1) ? 1 : 0;
                                                dp[nextBit][firstLarger][nextFirstIsSmaller][secondLarger][nextSecondIsSmaller] += x;
                                            } else if (a == 1) {
                                                int nextFirstIsLarger = (firstLarger == 1 || L[nextBit] == 0) ? 1 : 0;
                                                int nextSecondIsSmaller = (secondSmaller == 1 || R[nextBit] == 1) ? 1 : 0;
                                                dp[nextBit][nextFirstIsLarger][firstSmaller][secondLarger][nextSecondIsSmaller] += x;
                                            } else {
                                                int nextFirstIsSmaller = (firstSmaller == 1 || R[nextBit] == 1) ? 1 : 0;
                                                int nextSecondIsLarger = (secondLarger == 1 || L[nextBit] == 0) ? 1 : 0;
                                                dp[nextBit][firstLarger][nextFirstIsSmaller][nextSecondIsLarger][secondSmaller] += x;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            out.printLine(ans);
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

