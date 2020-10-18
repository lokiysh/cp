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
        TaskB solver = new TaskB();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            char grid[][] = new char[N][N];
            for (int i = 0; i < N; i++) {
                grid[i] = in.next().toCharArray();
            }
            List<String> list = make(grid, 0);
            if (list.size() <= 2) {
                out.printLine(list.size());
                for (String s : list) {
                    out.printLine(s);
                }
            } else {
                list = make(grid, 1);
                if (list.size() <= 2) {
                    out.printLine(list.size());
                    for (String s : list) {
                        out.printLine(s);
                    }
                }
            }

        }

        public List<String> make(char grid[][], int val) {
            int N = grid.length;
            List<String> list = new ArrayList<>();
            if (grid[0][1] - '0' != val) {
                list.add("1 2");
            }
            if (grid[1][0] - '0' != val) {
                list.add("2 1");
            }
            if (grid[N - 1][N - 2] - '0' != (1 - val)) {
                list.add(N + " " + (N - 1));
            }
            if (grid[N - 2][N - 1] - '0' != (1 - val)) {
                list.add((N - 1) + " " + (N));
            }
            return list;
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

