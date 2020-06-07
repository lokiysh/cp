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
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskD {
        char[][] a;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            a = new char[N][M];
            int good = 0;
            for (int i = 0; i < N; i++) {
                String s = in.next();
                for (int j = 0; j < M; j++) {
                    a[i][j] = s.charAt(j);
                    if (a[i][j] == 'G') {
                        good++;
                    }
                }
            }
            // no good people is always possible (since you block last cell)
            if (good == 0) {
                out.printLine("Yes");
                return;
            }
            // if good and bad people are neighbour, never possible
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (a[i][j] == 'G') {
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k], y = j + dy[k];
                            if (x >= 0 && x < N && y >= 0 && y < M && a[x][y] == 'B') {
                                out.printLine("No");
                                return;
                            }
                        }
                    }
                }
            }
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (a[i][j] == 'B' && !visited[i][j]) {
                        dfs(i, j);
                    }
                }
            }
            //check if all good people can escape
            if (a[N - 1][M - 1] == '#') {
                out.printLine("No");
                return;
            }

            a[N - 1][M - 1] = 'G';
            good++;
            for (int i = 0; i < N; i++) {
                boolean status = false;
                for (int j = 0; j < M; j++) {
                    if (a[i][j] == 'G' && !visited[i][j]) {
                        dfs2(i, j);
                        status = true;
                        break;
                    }
                }
                if (status) {
                    break;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (a[i][j] == 'G' && !visited[i][j]) {
                        out.printLine("No");
                        return;
                    }
                }
            }
            out.printLine("Yes");
        }

        public void dfs(int row, int col) {
            visited[row][col] = true;
            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < a.length && y >= 0 && y < a[0].length && !visited[x][y]) {
                    if (a[x][y] == 'B') {
                        dfs(x, y);
                    } else if (a[x][y] == '.') {
                        a[x][y] = '#';
                    }
                }
            }
        }

        public void dfs2(int row, int col) {
            visited[row][col] = true;
            for (int k = 0; k < 4; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < a.length && y >= 0 && y < a[0].length) {
                    if ((a[x][y] == 'G' || a[x][y] == '.') && !visited[x][y]) {
                        dfs2(x, y);
                    }
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

