import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractCollection;
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
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            int a[] = new int[N], b[] = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                b[i] = in.nextInt();
            }
            long ans = 0;
            Pair pairs[] = new Pair[N];
            for (int i = 0; i < N; i++) {
                pairs[i] = new Pair(i, a[i], b[i]);
            }
            Arrays.sort(pairs, new Comparator<Pair>() {

                public int compare(Pair o1, Pair o2) {
                    if (o1.num != o2.num) {
                        return Long.compare(o1.num, o2.num);
                    }
                    return Long.compare(o1.cost, o2.cost);
                }
            });

            PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {

                public int compare(Pair o1, Pair o2) {
                    if (o1.cost != o2.cost) {
                        return Long.compare(o2.cost, o1.cost);
                    }
                    return o1.index - o2.index;
                }
            });
            long totalInQueue = 0;
            int index = 0;
            long topNum = pairs[index].num;
            queue.add(pairs[index]);
            totalInQueue += pairs[index].cost;
            index++;
            while (!queue.isEmpty()) {
                while (index < N) {
                    if (pairs[index].num > topNum) {
                        break;
                    }
                    queue.add(pairs[index]);
                    totalInQueue += pairs[index].cost;
                    index++;
                }
                Pair p = queue.poll();
                totalInQueue -= p.cost;
                topNum++;
                ans += totalInQueue;
                if (queue.isEmpty() && index < N) {
                    queue.add(pairs[index]);
                    totalInQueue += pairs[index].cost;
                    topNum = pairs[index].num;
                    index++;
                }
            }
            out.printLine(ans);
        }

        class Pair {
            int index;
            long num;
            long cost;

            public Pair(int index, long num, long cost) {
                this.index = index;
                this.num = num;
                this.cost = cost;
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

