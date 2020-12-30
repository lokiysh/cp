import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
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
        TaskD solver = new TaskD();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            List<Integer> graph[] = new List[N];
            long weight[] = new long[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                weight[i] = in.nextInt();
            }
            for (int i = 1; i < N; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                graph[u].add(v);
                graph[v].add(u);
            }
            long ans[] = new long[N];
            PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {

                public int compare(Node o1, Node o2) {
                    if (o1.val != o2.val) {
                        return Long.compare(o1.val, o2.val);
                    }
                    return Long.compare(o1.times, o2.times);
                }
            });
            long cur = 0;
            for (int i = 0; i < N; i++) {
                cur += weight[i] * graph[i].size();
                queue.add(new Node(weight[i], graph[i].size()));
            }
            ans[N - 1] = cur;

            int i = N - 2;
            while (i >= 1) {
                Node element = queue.poll();
                while (element.times > 1) {
                    element.times--;
                    cur -= element.val;
                    ans[i--] = cur;
                }
            }

            for (i = 1; i < N; i++) {
                out.print(ans[i] + " ");
            }
            out.printLine();
        }

        class Node {
            long val;
            long times;

            public Node(long val, long times) {
                this.val = val;
                this.times = times;
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

