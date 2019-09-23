import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
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
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        HashSet<String> permutations;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            permutations = new HashSet<>();
            int N = in.nextInt(), M = in.nextInt();
            boolean hasEdge[][] = new boolean[N][N];
            int edges[][] = new int[M][2];
            int degrees[] = new int[N];
            for (int i = 0; i < M; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                hasEdge[u][v] = true;
                hasEdge[v][u] = true;
                edges[i][0] = u;
                edges[i][1] = v;
                degrees[u]++;
                degrees[v]++;
            }

            if (N <= 6) {
                out.printLine(M);
                return;
            }
            boolean visited[] = new boolean[N];
            dfs(0, visited, hasEdge);
            boolean hasMoreCom = false;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    hasMoreCom = true;
                    break;
                }
            }
            if (hasMoreCom) {
                out.printLine(M);
                return;
            }
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int c = 0;
                    HashSet<Integer> set = new HashSet<>();
                    for (int k = 0; k < M; k++) {
                        if (edges[k][0] != i && edges[k][1] != i && edges[k][0] != j && edges[k][1] != j) {
                            c++;
                        } else {
                            set.add(edges[k][0]);
                            set.add(edges[k][1]);
//                        if ((edges[k][0] == i && edges[k][1] != j) || (edges[k][0] == j && edges[k][1] != i)) {
//                            set.add(edges[k][1]);
//                        } else if ((edges[k][1] == i && edges[k][0] != j) || (edges[k][1] == j && edges[k][0] != i)) {
//                            set.add(edges[k][0]);
//                        }
                        }
                    }
                    set.remove(i);
                    set.remove(j);
                    if (hasEdge[i][j]) {
                        c++;
                    }
                    max = Math.max(max, c + set.size());
                }
            }

            out.printLine(max);
        }

        public void dfs(int index, boolean visites[], boolean[][] hasEdge) {
            visites[index] = true;
            for (int i = 0; i < hasEdge[index].length; i++) {
                if (hasEdge[index][i] && !visites[i]) {
                    dfs(i, visites, hasEdge);
                }
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

