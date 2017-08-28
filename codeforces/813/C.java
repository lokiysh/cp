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
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author phantom11
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), i, x = in.nextInt() - 1;
            Node graph[] = new Node[n];
            for (i = 0; i < n; i++) {
                graph[i] = new Node(i);
            }
            for (i = 1; i < n; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                graph[u].children.add(graph[v]);
                graph[v].children.add(graph[u]);
            }
            int distanceFromAlice[] = bfs(0, graph);
            int distanceFromBob[] = bfs(x, graph);
            int ans = 0;
            //DebugUtils.debug(distanceFromAlice, distanceFromBob);
            for (i = 0; i < n; i++) {
                if (graph[i].isLeaf && distanceFromAlice[i] > distanceFromBob[i]) {
                    ans = Math.max(ans, 2 * distanceFromAlice[i]);
                }
            }
            out.printLine(ans);
        }

        public int[] bfs(int start, Node graph[]) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            int n = graph.length;
            boolean visited[] = new boolean[n];
            int height[] = new int[n];
            height[start] = 0;
            visited[start] = true;
            while (!queue.isEmpty()) {
                int u = queue.poll();
                boolean isLeaf = true;
                for (Node child : graph[u].children) {
                    if (!visited[child.index]) {
                        isLeaf = false;
                        visited[child.index] = true;
                        queue.add(child.index);
                        height[child.index] = height[u] + 1;
                    }
                }
                if (start == 0 && isLeaf) {
                    graph[u].isLeaf = true;
                }
            }
            return height;
        }

        class Node {
            ArrayList<Node> children;
            int index;
            boolean isLeaf;

            public Node(int index) {
                children = new ArrayList<>();
                this.index = index;
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
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
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

