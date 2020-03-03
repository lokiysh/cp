import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.AbstractCollection;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        OutputWriter out;
        InputReader in;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            this.out = out;
            this.in = in;
            int N = in.nextInt();
            Node[] graph = new Node[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new Node(i);
            }
            for (int i = 0; i < N - 1; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                graph[u].addEdge(v);
                graph[v].addEdge(u);
            }
            PriorityQueue<Node> queue = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                if (graph[i].degree == 1) {
                    queue.add(graph[i]);
                }
            }
            int maxQuery = N / 2;
            boolean processed[] = new boolean[N];
            while (maxQuery > 0) {
                Node u = queue.poll();
                if (queue.isEmpty()) {
                    confirm(u.index);
                    return;
                }
                while (!queue.isEmpty() && processed[u.index]) {
                    u = queue.poll();
                }
                Node v = queue.poll();
                while (!queue.isEmpty() && (v.index == u.index || processed[v.index])) {
                    v = queue.poll();
                }
                if (v.index == u.index) {
                    confirm(v.index);
                    return;
                }
                int w = query(u, v);
                if (u.degree <= 1) {
                    processed[u.index] = true;
                }
                if (v.degree <= 1) {
                    processed[v.index] = true;
                }

                if (w == u.index || w == v.index) {
                    confirm(w);
                    return;
                }
                for (int x : u.edges) {
                    graph[x].degree--;
                    if (graph[x].degree <= 1 && !processed[x]) {
                        queue.add(graph[x]);
                    }
                }
                for (int x : v.edges) {
                    graph[x].degree--;
                    if (graph[x].degree <= 1 && !processed[x]) {
                        queue.add(graph[x]);
                    }
                }
                maxQuery--;
            }
            confirm(queue.poll().index);
        }

        public int query(Node u, Node v) {

            System.out.println("? " + (u.index + 1) + " " + (v.index + 1));
            int w = in.nextInt() - 1;
            return w;
        }

        public void confirm(int u) {
            u++;
            System.out.println("! " + u);
            out.close();
        }

        class Node implements Comparable<Node> {
            int index;
            List<Integer> edges;
            int degree;

            public Node(int index) {
                edges = new ArrayList<>();
                degree = 0;
                this.index = index;
            }

            public void addEdge(int v) {
                edges.add(v);
                degree++;
            }

            public int compareTo(Node a) {
                if (this.degree != a.degree) {
                    return this.degree - a.degree;
                }
                return this.index - a.index;
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

