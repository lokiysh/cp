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
import java.io.BufferedReader;
import java.util.Queue;
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
        TaskD solver = new TaskD();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            int a = in.nextInt() - 1, b = in.nextInt() - 1, da = in.nextInt(), db = in.nextInt();
            List<Integer> tree[] = new List[N];
            for (int i = 0; i < N; i++) {
                tree[i] = new ArrayList<>();
            }
            for (int i = 1; i < N; i++) {
                int x = in.nextInt() - 1, y = in.nextInt() - 1;
                tree[x].add(y);
                tree[y].add(x);
            }
            // 0 or infinte turns
            if (a == b || db <= 2 * da) {
                out.printLine("Alice");
                return;
            }
            // 1 turn
            if (distance(tree, a, b, N) <= da) {
                out.printLine("Alice");
                return;
            }
            // bring alice to center of the tree and check if bob's maximum distance from any leaf is less than 2da then Alice
            // (effectively check diameter of tree <= 2da
            int farX = farthest(tree, a, N);
            int farY = farthest(tree, farX, N);
//        DebugUtils.debug(farX, farY);
            if (distance(tree, farX, farY, N) <= 2 * da) {
                out.printLine("Alice");
                return;
            }
            out.printLine("Bob");
        }

        public int distance(List<Integer> tree[], int a, int b, int N) {
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> dist = new LinkedList<>();
            boolean visited[] = new boolean[N];
            queue.add(a);
            dist.add(0);
            visited[a] = true;
            while (!queue.isEmpty()) {
                int x = queue.poll();
                int d = dist.poll();
                if (x == b) {
                    return d;
                }
                for (int v : tree[x]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                        dist.add(d + 1);
                    }
                }
            }
            return 0;
        }

        public int farthest(List<Integer> tree[], int a, int N) {
            Queue<Integer> queue = new LinkedList<>();
            boolean visited[] = new boolean[N];
            queue.add(a);
            visited[a] = true;
            int farthest = a;
            while (!queue.isEmpty()) {
                int x = queue.poll();
                farthest = x;
                for (int v : tree[x]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
            return farthest;
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

