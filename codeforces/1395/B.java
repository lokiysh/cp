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
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt(), x = in.nextInt() - 1, y = in.nextInt() - 1;
            int count;
            List<String> answer = new ArrayList<>();
            boolean visited[][] = new boolean[N][M];
            visited[x][y] = true;
            answer.add((x + 1) + " " + (y + 1));
            visited[0][y] = true;

            answer.add("1 " + (y + 1));
            visited[0][0] = true;
            answer.add("1 1");
            count = 3;
            x = 0;
            y = 0;
            boolean pos = true;
            while (count < N * M) {
                while (visited[x][y]) {
                    if (pos) {
                        y++;
                    } else {
                        y--;
                    }
                }
                count++;
                visited[x][y] = true;
                answer.add((x + 1) + " " + (y + 1));
                if (count == N * M) {
                    break;
                }
                if (y == M - 1 && pos) {
                    pos = !pos;
                    x++;
                }
                if (y == 0 && !pos) {
                    pos = !pos;
                    x++;
                }
            }
            for (String s : answer) {
                out.printLine(s);
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

