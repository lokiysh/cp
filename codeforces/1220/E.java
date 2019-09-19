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
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            GraphUtils graph = new GraphUtils();
            graph.initGraph(N, new String[N]);
            Integer score[] = in.nextIntArray(N);
            for (int i = 0; i < M; i++) {
                graph.addEdge(in.nextInt() - 1, in.nextInt() - 1, false, 1);
            }
            int source = in.nextInt() - 1;
            int degree[] = new int[N];
            Queue<GraphUtils.Node> queue = new LinkedList<>();
            for (GraphUtils.Node node : graph.nodes) {
                degree[node.index] = node.edges.size();
                if (node.index != source && degree[node.index] == 1) {
                    ((LinkedList<GraphUtils.Node>) queue).add(node);
                }
            }
            long best[] = new long[N];
            while (!queue.isEmpty()) {
                GraphUtils.Node node = queue.poll();
                degree[node.index] = -1;
                for (GraphUtils.Edge edge : node.edges) {
                    GraphUtils.Node v = edge.to;
                    if (degree[v.index] < 0) {
                        continue;
                    }
                    degree[v.index]--;
                    best[v.index] = Math.max(best[v.index], best[node.index] + score[node.index]);
                    if (degree[v.index] == 1 && v.index != source) {
                        ((LinkedList<GraphUtils.Node>) queue).add(v);
                    }
                }
            }
            long total = 0, maxInsert = 0;
            for (int i = 0; i < N; i++) {
                if (degree[i] < 0) {
                    continue;
                }
                total += score[i];
                maxInsert = Math.max(maxInsert, best[i]);
            }
            out.printLine(total + maxInsert);
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

        public Integer[] nextIntArray(int size) {
            Integer array[] = new Integer[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
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

    static class GraphUtils {
        GraphUtils.Node[] nodes;

        public void initGraph(int numberOfNodes, String labels[]) {
            nodes = new GraphUtils.Node[numberOfNodes];
            for (int i = 0; i < numberOfNodes; i++) {
                nodes[i] = new GraphUtils.Node();
                nodes[i].edges = new ArrayList<>();
                nodes[i].index = i;
                if (labels[i] != null) {
                    nodes[i].name = labels[i];
                }
            }
        }

        public void addEdge(int u, int v, boolean isDirected, long weight) {
            GraphUtils.Edge edge = new GraphUtils.Edge(nodes[u], nodes[v], weight);
            nodes[u].edges.add(edge);
            if (!isDirected) {
                GraphUtils.Edge edge1 = new GraphUtils.Edge(nodes[v], nodes[u], weight);
                nodes[v].edges.add(edge1);
            }
        }

        static class Node {
            String name;
            List<GraphUtils.Edge> edges;
            int index;

            public Node() {

            }

        }

        static class Edge {
            long weight;
            GraphUtils.Node from;
            GraphUtils.Node to;

            public Edge(GraphUtils.Node from, GraphUtils.Node to, long weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

        }

    }
}

