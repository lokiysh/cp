import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.io.BufferedReader;
import java.util.LinkedList;
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
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            int zeroDistance[] = new int[N + M - 1];
            int oneDistance[] = new int[N + M - 1];
            boolean visited[][] = new boolean[N][M];
            visited[0][0] = true;
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(0, 0, 0));
            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                if (a[p.x][p.y] == 0) {
                    zeroDistance[p.d]++;
                } else {
                    oneDistance[p.d]++;
                }
                if (p.x + 1 < N && !visited[p.x + 1][p.y]) {
                    visited[p.x + 1][p.y] = true;
                    queue.add(new Pair(p.x + 1, p.y, p.d + 1));
                }
                if (p.y + 1 < M && !visited[p.x][p.y + 1]) {
                    visited[p.x][p.y + 1] = true;
                    queue.add(new Pair(p.x, p.y + 1, p.d + 1));
                }
            }
            int left = 0, right = zeroDistance.length - 1;
            int ans = 0;
            while (left < right) {
                int z = zeroDistance[left] + zeroDistance[right];
                int o = oneDistance[left] + oneDistance[right];
                ans += Math.min(z, o);
                left++;
                right--;
            }
            out.printLine(ans);
        }

        class Pair {
            int x;
            int y;
            int d;

            public Pair(int x, int y, int distance) {
                this.x = x;
                this.y = y;
                this.d = distance;
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

