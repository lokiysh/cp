import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
 *
 * @author phantom11
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
            int n = in.nextInt(), i;
            List<Integer> edges[] = new List[n];
            for (i = 0; i < n; i++) {
                edges[i] = new ArrayList<Integer>();
            }
            for (i = 1; i < n; i++) {
                int x = in.nextInt() - 1, y = in.nextInt() - 1;
                edges[x].add(y);
                edges[y].add(x);
            }
            Queue<Integer> queue = new LinkedList<>();
            int parent[] = new int[n], grandparent[] = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(grandparent, -1);
            queue.add(0);
            int color[] = new int[n], k = 1;
            boolean visited[] = new boolean[n];
            color[0] = 1;
            visited[0] = true;
            while (!queue.isEmpty()) {
                int x = queue.poll();
                int c = 0;
                for (int p : edges[x]) {
                    if (!visited[p]) {
                        visited[p] = true;
                        parent[p] = x;
                        grandparent[p] = (parent[x] == -1) ? -1 : parent[x];

                        ++c;
                        if (grandparent[p] != -1 && c == color[grandparent[p]]) {
                            c++;
                        }
                        if (parent[p] != -1 && c == color[parent[p]]) {
                            c++;
                        }
                        if (grandparent[p] != -1 && c == color[grandparent[p]]) {
                            c++;
                        }
                        queue.add(p);
                        color[p] = c;
                    }
                }
                //DebugUtils.debug(color);
                //DebugUtils.debug(parent, grandparent, color);
                k = Math.max(k, c);
            }
            out.printLine(k);
            for (i = 0; i < n; i++) {
                out.print(color[i] + " ");
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

