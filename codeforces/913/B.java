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
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            Node nodes[] = new Node[N];
            int i;
            for (i = 0; i < N; i++) {
                nodes[i] = new Node(i);
            }
            boolean isLeaf[] = new boolean[N];
            Arrays.fill(isLeaf, true);
            for (i = 1; i < N; i++) {
                int parent = in.nextInt() - 1;
                nodes[parent].children.add(new Edge(nodes[parent], nodes[i], 1));
                isLeaf[parent] = false;
            }
            boolean status = true;
            for (i = 0; i < N; i++) {
                if (!isLeaf[i]) {
                    int leaf = 0;
                    for (Edge edge : nodes[i].children) {
                        if (isLeaf[edge.v.index]) {
                            leaf++;
                        }
                    }
                    if (leaf < 3) {
                        status = false;
                        break;
                    }
                }
            }
            if (status) {
                out.printLine("Yes");
            } else {
                out.printLine("No");
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

    static class IntegerUtils {
        public static long INFINITY = (long) 1e18;

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

    static class Node implements Comparable<Node> {
        public int index;
        public long distance;
        public ArrayList<Edge> children;
        public Node parent;

        public Node(int index) {
            this.index = index;
            distance = IntegerUtils.INFINITY;
            children = new ArrayList<>();
            parent = null;
        }

        public int compareTo(Node a) {
            return Long.compare(this.distance, a.distance);
        }

        public String toString() {
            return "Index = " + index + " distance = " + distance + " parent = " + (parent != null ? parent.index : null);
        }

    }

    static class Edge implements Comparable<Edge> {
        public Node u;
        public Node v;
        public long cost;

        public Edge(Node u, Node v, long cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Edge e) {
            return Long.compare(this.cost, e.cost);
        }

    }
}

