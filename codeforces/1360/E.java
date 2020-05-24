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
        TaskE solver = new TaskE();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskE {
        boolean[][] visited;
        int[][] a;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            a = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = in.next();
                for (int j = 0; j < N; j++) {
                    a[i][j] = s.charAt(j) - '0';
                }
            }
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                if (!visited[N - 1][i] && a[N - 1][i] == 1) {
                    dfs(N - 1, i);
                }
            }
            for (int i = 0; i < N; i++) {
                if (!visited[i][N - 1] && a[i][N - 1] == 1) {
                    dfs(i, N - 1);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (a[i][j] == 1 && !visited[i][j]) {
                        out.printLine("NO");
                        return;
                    }
                }
            }
            out.printLine("YES");
        }

        public void dfs(int row, int col) {
            visited[row][col] = true;
            int N = a.length;
            int dx[] = {-1, 0};
            int dy[] = {0, -1};
            for (int i = 0; i < 2; i++) {
                int x = row + dx[i], y = col + dy[i];
                if (x >= 0 && x < N && y >= 0 && y < N && a[x][y] == 1 && !visited[x][y]) {
                    dfs(x, y);
                }
            }
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

