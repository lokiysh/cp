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
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            Node graph[] = new Node[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new Node(i);
            }
            Edge edges[] = new Edge[N - 1];

            for (int i = 1; i < N; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                edges[i - 1] = new Edge(u, v, i - 1);
                graph[u].edges.add(edges[i - 1]);
                graph[v].edges.add(edges[i - 1]);
            }
            Arrays.sort(graph, new Comparator<Node>() {

                public int compare(Node o1, Node o2) {
                    if (o1.edges.size() != o2.edges.size()) {
                        return o2.edges.size() - o1.edges.size();
                    }
                    return o1.index - o2.index;
                }
            });
            int current = 0;
            for (int i = 0; i < N; i++) {
                for (Edge edge : graph[i].edges) {
                    if (edge.label == -1) {
                        edge.label = current++;
                    }
                }
            }
            Arrays.sort(edges, new Comparator<Edge>() {

                public int compare(Edge o1, Edge o2) {
                    return o1.index - o2.index;
                }
            });
            for (int i = 0; i < N - 1; i++) {
                out.printLine(edges[i].label);
            }
        }

        class Node {
            int index;
            List<Edge> edges;

            public Node(int index) {
                edges = new ArrayList<>();
                this.index = index;
            }

        }

        class Edge {
            int u;
            int v;
            int label;
            int index;

            public Edge(int u, int v, int index) {
                this.u = u;
                this.v = v;
                this.index = index;
                this.label = -1;
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

