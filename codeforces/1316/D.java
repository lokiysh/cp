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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        Cell[][] a;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        char[] dir = {'D', 'L', 'U', 'R'};
        int N;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            N = in.nextInt();
            a = new Cell[N][N];
            List<Cell> blocked = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int x = in.nextInt() - 1, y = in.nextInt() - 1;
                    a[i][j] = new Cell(i, j, x, y);
                    if (x == i && y == j) {
                        blocked.add(a[i][j]);
                        a[i][j].direction = 'X';
                    }
                }
            }
            for (Cell c : blocked) {
                dfs(c);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (a[i][j].endy == -2 && a[i][j].endx == -2) {
                        cycle(a[i][j]);
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (a[i][j].direction == ' ') {
                        out.printLine("INVALID");
                        return;
                    }
                }
            }
            out.printLine("VALID");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    out.print(a[i][j].direction);
                }
                out.printLine();
            }
        }

        public void cycle(Cell c) {
            for (int i = 0; i < 4; i++) {
                int x = c.i + dx[i], y = c.j + dy[i];
                if (x >= 0 && x < N && y >= 0 && y < N && a[x][y].endx == c.endx && a[x][y].endy == c.endy && a[x][y].direction == ' ') {
                    a[x][y].direction = dir[i];
                    dfs(a[x][y]);
                }
            }
        }

        public void dfs(Cell c) {
            for (int i = 0; i < 4; i++) {
                int x = c.i + dx[i], y = c.j + dy[i];
                if (x >= 0 && x < N && y >= 0 && y < N && a[x][y].endx == c.endx && a[x][y].endy == c.endy && a[x][y].direction == ' ') {
                    a[x][y].direction = dir[i];
                    dfs(a[x][y]);
                }
            }
        }

        class Cell {
            int i;
            int j;
            char direction;
            int endx;
            int endy;

            public Cell(int i, int j, int endx, int endy) {
                this.i = i;
                this.j = j;
                this.endx = endx;
                this.endy = endy;
                this.direction = ' ';
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

