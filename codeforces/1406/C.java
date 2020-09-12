import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        List<Integer> centroids;
        List<Integer>[] graph;
        int[] size;
        int N;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            N = in.nextInt();
            size = new int[N];
            graph = new List[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 1; i < N; i++) {
                int x = in.nextInt() - 1, y = in.nextInt() - 1;
                graph[x].add(y);
                graph[y].add(x);
            }
            centroids = new ArrayList<>();
            dfs(0, -1);
            if (centroids.size() == 1) {
                int x = centroids.get(0);
                int y = graph[x].get(0);
                x++;
                y++;
                out.printLine(x + " " + y);
                out.printLine(x + " " + y);
            } else {
                int x = centroids.get(0), y = centroids.get(1);

                Queue<Integer> queue = new LinkedList<>();
                boolean visited[] = new boolean[N];
                int parent[] = new int[N];
                queue.add(y);
                visited[y] = true;
                visited[x] = true;
                while (!queue.isEmpty()) {
                    int p = queue.poll();
                    if (graph[p].size() == 1) {
                        x++;
                        int z = parent[p];
                        p++;
                        out.printLine(z + " " + p);
                        out.printLine(x + " " + p);
                        return;
                    }
                    for (int v : graph[p]) {
                        if (!visited[v]) {
                            parent[v] = p + 1;
                            visited[v] = true;
                            queue.add(v);
                        }
                    }
                }
            }
        }

        public void dfs(int u, int prev) {
            size[u] = 1;
            boolean isCentroid = true;
            for (int v : graph[u]) {
                if (v != prev) {
                    dfs(v, u);
                    size[u] += size[v];
                    if (size[v] > N / 2) {
                        isCentroid = false;
                    }
                }
            }
            if (N - size[u] > N / 2) {
                isCentroid = false;
            }
            if (isCentroid) {
                centroids.add(u);
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

