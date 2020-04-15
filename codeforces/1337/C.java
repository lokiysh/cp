import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.util.Comparator;
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
        int[] numChildren;
        int[] depth;
        boolean[] visited;
        int[] parent;
        List<Integer>[] graph;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), K = in.nextInt();
            parent = new int[N];
            depth = new int[N];
            numChildren = new int[N];
            visited = new boolean[N];
            Arrays.fill(parent, -1);

            graph = new List[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 1; i < N; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                graph[u].add(v);
                graph[v].add(u);
            }
            visited[0] = true;
            depth[0] = 0;
            dfs(0);
            Node nodes[] = new Node[N];
            for (int i = 0; i < N; i++) {
                nodes[i] = new Node(i, numChildren[i], depth[i]);
                nodes[i].value = depth[i] - numChildren[i];
            }
            Arrays.sort(nodes, new Comparator<Node>() {

                public int compare(Node o1, Node o2) {
                    if (o1.value != o2.value) {
                        return o2.value - o1.value;
                    }
                    return o1.index - o2.index;
                }
            });
            long ans = 0;
            for (int i = 0; i < K; i++) {
                ans += nodes[i].value;
            }
            out.printLine(ans);

        }

        public void dfs(int node) {
            int children = 0;
            for (int v : graph[node]) {
                if (!visited[v]) {
                    visited[v] = true;
                    depth[v] = depth[node] + 1;
                    dfs(v);
                    children += numChildren[v] + 1;
                }
            }
            numChildren[node] = children;
        }

        class Node {
            int index;
            int children;
            int depth;
            int value;

            public Node(int index, int children, int depth) {
                this.children = children;
                this.index = index;
                this.depth = depth;
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

