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
        TaskC solver = new TaskC();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), X = in.nextInt();
            if (N == 1) {
                out.printLine("Ayush");
                return;
            }
            List<Integer> graph[] = new List[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList();
            }
            int degree[] = new int[N];
            for (int i = 1; i < N; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                graph[u].add(v);
                graph[v].add(u);
                degree[u]++;
                degree[v]++;
            }
            X--;
//        int turn = 0, win = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        boolean visited[] = new boolean[N];
//        for (int i = 0; i < N; i++) {
//            if (degree[i] == 1) {
//                queue.add(i);
//                if (i == X) {
//                    win = turn;
//                }
//                visited[i] = true;
//            }
//        }
//        while (!queue.isEmpty()) {
//            int u = queue.poll();
//            turn = 1 - turn;
//            for (int v : graph[u]) {
//                degree[v]--;
//                if (degree[v] <= 1 & !visited[v]) {
//                    queue.add(v);
//                    if (v == X) {
//                        win = turn;
//                    }
//                    visited[v] = true;
//                }
//            }
//        }
            int win = -1;
            if (graph[X].size() <= 1) {
                win = 0;
            } else {
                win = N % 2;
            }
            if (win == 1) {
                out.printLine("Ashish");
            } else {
                out.printLine("Ayush");
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

