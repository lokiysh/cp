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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        int N;
        List<Integer>[] graph;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            N = in.nextInt();
            long costs[][] = new long[N][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < N; j++) {
                    costs[j][i] = in.nextInt();
                }
            }
            graph = new List[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 1; i < N; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                graph[u].add(v);
                graph[v].add(u);
            }
            int startVertex = -1;
            for (int i = 0; i < N; i++) {
                if (graph[i].size() >= 3) {
                    out.printLine(-1);
                    return;
                }
                if (graph[i].size() == 1) {
                    startVertex = i;
                }
            }
            long cost = (long) 1e18;
            StringBuilder str = new StringBuilder();
            int optimalColor[] = new int[N];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    int color[] = new int[N];
                    int lastVertex = -1;
                    int currentVertex = startVertex;
                    currentVertex = getNextVertex(currentVertex, lastVertex);
                    long currentCost = costs[startVertex][i] + costs[currentVertex][j];
                    color[startVertex] = i + 1;
                    color[currentVertex] = j + 1;
                    lastVertex = startVertex;
                    int last = j;
                    int prevToLast = i;
                    for (int k = 2; k < N; k++) {
                        int index = 3 - last - prevToLast;
                        int nextVertex = getNextVertex(currentVertex, lastVertex);
                        currentCost += costs[nextVertex][index];
                        color[nextVertex] = index + 1;
                        prevToLast = last;
                        last = index;
                        lastVertex = currentVertex;
                        currentVertex = nextVertex;
                    }
                    if (currentCost < cost) {
                        cost = currentCost;
                        optimalColor = color;
                    }
                }
            }

            out.printLine(cost);
            for (int i = 0; i < N; i++) {
                out.print(optimalColor[i] + " ");
            }
        }

        public int getNextVertex(int vertex, int previous) {
            for (int i = 0; i < graph[vertex].size(); i++) {
                if (graph[vertex].get(i) != previous) {
                    return graph[vertex].get(i);
                }
            }
            return 0;
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

