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
        Node[] nodes;
        boolean possible;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            nodes = new Node[N];
            for (int i = 0; i < N; i++) {
                nodes[i] = new Node(i);
            }
            for (int i = 0; i < N; i++) {
                nodes[i].population = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                nodes[i].happiness = in.nextInt();
            }
            for (int i = 1; i < N; i++) {
                int x = in.nextInt() - 1, y = in.nextInt() - 1;
                nodes[x].edges.add(y);
                nodes[y].edges.add(x);
            }
            possible = true;
            dfs(0);
            if (possible) {
                out.printLine("YES");
            } else {
                out.printLine("NO");
            }
        }

        public void dfs(int index) {
            if (!possible) {
                return;
            }
            nodes[index].visited = true;
            int totalSubtree = nodes[index].population, childrenNegative = 0, childrenPositive = 0;
            for (int c : nodes[index].edges) {
                if (!nodes[c].visited) {
                    dfs(c);
                    totalSubtree += nodes[c].subTree;
                    childrenNegative += nodes[c].negative;
                    childrenPositive += nodes[c].positive;
                }
            }
            nodes[index].subTree = totalSubtree;
            nodes[index].positive = (totalSubtree + nodes[index].happiness) / 2;
            nodes[index].negative = (totalSubtree - nodes[index].positive);

            if (nodes[index].negative - childrenNegative > 0) {
                nodes[index].pNegative = nodes[index].negative - childrenNegative;
            }
            nodes[index].pPositive = nodes[index].population - nodes[index].pNegative;
            if (nodes[index].positive < 0 || nodes[index].negative < 0 || (totalSubtree + nodes[index].happiness) % 2 == 1) {
                possible = false;
            }
            if (nodes[index].positive < childrenPositive || (nodes[index].negative - nodes[index].pNegative) > childrenNegative) {
                possible = false;
            }
            if (Math.abs(nodes[index].happiness) > totalSubtree) {
                possible = false;
            }
        }

        class Node {
            int index;
            int children;
            int positive;
            int negative;
            int happiness;
            int population;
            List<Integer> edges;
            boolean visited;
            int subTree;
            int pPositive;
            int pNegative;

            public Node(int index) {
                this.index = index;
                this.edges = new ArrayList<>();
                this.children = 0;
                this.positive = 0;
                this.negative = 0;
                visited = false;
                subTree = 0;
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

