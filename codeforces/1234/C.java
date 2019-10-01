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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        int N;
        int[][] a;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int Q = in.nextInt();
            while (Q-- > 0) {
                N = in.nextInt();
                a = new int[3][N + 2];
                for (int i = 1; i <= 2; i++) {
                    String s = in.next();
                    for (int j = 1; j <= N; j++) {
                        a[i][j] = s.charAt(j - 1) - '0';
                    }
                }
                boolean ans;
                if (a[1][1] == 1 || a[1][1] == 2) {
                    ans = recur(1, 2, 2);
                } else {
                    ans = recur(2, 1, 4);
                }
                if (ans) {
                    out.printLine("YES");
                } else {
                    out.printLine("NO");
                }
            }
        }

        public boolean recur(int row, int col, int prev) {
            if (col == N + 1) {
                return row == 2;
            }
            if (a[row][col] == 1 || a[row][col] == 2) {
                if (prev == 1) {
                    return false;
                }
                if (prev == 2) {
                    return recur(row, col + 1, 2);
                }
                if (prev == 3) {
                    return recur(row, col + 1, 2);
                }
                if (prev == 4) {
                    return false;
                }
                if (prev == 5) {
                    return false;
                }
                if (prev == 6) {
                    return recur(row, col + 1, 2);
                }
            } else {
                if (prev == 1) {
                    if (row == 1) {
                        return recur(row, col + 1, 3);
                    } else {
                        return recur(row, col + 1, 6);
                    }
                }
                if (prev == 2) {
                    if (row == 1) {
                        return recur(2, col, 4);
                    } else {
                        return recur(1, col, 5);
                    }
                }
                if (prev == 3) {
                    return recur(2, col, 4);
                }
                if (prev == 4) {
                    return recur(2, col + 1, 6);
                }
                if (prev == 5) {
                    return recur(1, col + 1, 3);
                }
                if (prev == 6) {
                    return recur(1, col, 5);
                }
            }
            return false;
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

