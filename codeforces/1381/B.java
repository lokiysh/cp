import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
            int a[] = new int[2 * N];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }
            ArrayList<Integer> list = new ArrayList<>();
            boolean seen[] = new boolean[2 * N + 1];
            int lookingFor = 2 * N, current = 0;
            for (int i = a.length - 1; i >= 0; i--) {
                current++;
                seen[a[i]] = true;
                if (a[i] == lookingFor) {
                    list.add(current);
                    current = 0;
                    while (seen[lookingFor]) {
                        lookingFor--;
                    }
                }
            }
            int num[] = new int[list.size()];
            for (int i = 0; i < num.length; i++) {
                num[i] = list.get(i);
            }

            if (canPartition(num, 2 * N)) {
                out.printLine("YES");
            } else {
                out.printLine("NO");
            }
        }

        public boolean canPartition(int[] num, int sum) {
            int n = num.length;
            // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
            sum /= 2;

            boolean[][] dp = new boolean[n][sum + 1];

            // populate the sum=0 column, as we can always have '0' sum without including any element
            for (int i = 0; i < n; i++)
                dp[i][0] = true;

            // with only one number, we can form a subset only when the required sum is equal to its value
            for (int s = 1; s <= sum; s++) {
                dp[0][s] = (num[0] == s ? true : false);
            }

            // process all subsets for all sums
            for (int i = 1; i < n; i++) {
                for (int s = 1; s <= sum; s++) {
                    // if we can get the sum 's' without the number at index 'i'
                    if (dp[i - 1][s]) {
                        dp[i][s] = dp[i - 1][s];
                    } else if (s >= num[i]) { // else if we can find a subset to get the remaining sum
                        dp[i][s] = dp[i - 1][s - num[i]];
                    }
                }
            }

            // the bottom-right corner will have our answer.
            return dp[n - 1][sum];
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

