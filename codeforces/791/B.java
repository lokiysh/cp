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
        boolean[] visited;
        List<Integer>[] edges;
        int[] components;
        int[] sizes;
        int s;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), m = in.nextInt();
            edges = new List[n];
            components = new int[n];
            sizes = new int[n];
            visited = new boolean[n];
            int i, j;
            for (i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (i = 0; i < m; i++) {
                int x = in.nextInt() - 1, y = in.nextInt() - 1;
                edges[x].add(y);
                edges[y].add(x);
            }
            int c = 0;
            for (i = 0; i < n; i++) {
                if (!visited[i]) {
                    s = 0;
                    dfs(i, c);
                    sizes[c] = s;
                    c++;

                }
            }
            for (i = 0; i < n; i++) {
                if (edges[i].size() != sizes[components[i]] - 1) {
                    out.printLine("NO");
                    return;
                }
            }
            out.printLine("YES");

        }

        public void dfs(int index, int comp) {
            visited[index] = true;
            s++;
            components[index] = comp;
            for (int i : edges[index]) {
                if (!visited[i]) {
                    dfs(i, comp);
                }
            }
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

