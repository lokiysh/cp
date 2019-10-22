import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskF {
        int N;
        int K;
        List<Integer>[] graph;
        int[][] dp;
        int[] cost;
        int[][] max_dp;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            N = in.nextInt();
            K = in.nextInt();
            graph = new List[N];
            dp = new int[N + 1][N + 1];
            max_dp = new int[N + 1][N + 1];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }
            cost = new int[N];
            for (int i = 0; i < N; i++) {
                cost[i] = in.nextInt();
            }
            for (int i = 1; i < N; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                graph[u].add(v);
                graph[v].add(u);
            }
            dfs(0, -1);
            out.printLine(max_dp[0][0]);
        }

        public void dfs(int node, int parent) {
            dp[node][0] = cost[node];
            for (int child : graph[node]) {
                if (child != parent) {
                    dfs(child, node);
                    dp[node][0] += max_dp[child][K];
                }
            }
            for (int j = 1; j <= N; j++) {
                for (int child : graph[node]) {
                    if (child == parent) continue;
                    int current = max_dp[child][j - 1];
                    for (int otherChildren : graph[node]) {
                        if (otherChildren == parent || otherChildren == child) continue;
                        current += max_dp[otherChildren][Math.max(j - 1, K - j)];
                    }
                    dp[node][j] = Math.max(dp[node][j], current);
                }
            }
            max_dp[node][N] = dp[node][N];
            for (int i = N - 1; i >= 0; i--) {
                max_dp[node][i] = Math.max(dp[node][i], max_dp[node][i + 1]);
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

