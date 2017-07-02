import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.util.Hashtable;
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
            int n = in.nextInt(), x = in.nextInt(), i;
            Items item[] = new Items[2 * n];
            for (i = 0; i < n; i++) {
                int l = in.nextInt(), r = in.nextInt(), c = in.nextInt();
                int interval = r - l + 1;
                item[2 * i] = new Items(0, l, c, interval);
                item[2 * i + 1] = new Items(1, r, c, interval);
            }
            Arrays.sort(item);
            long ans = Integer.MAX_VALUE;
            Hashtable<Integer, Long> bestCost = new Hashtable<>();
            for (i = 0; i < item.length; i++) {
                if (item[i].type == 0) {
                    if (bestCost.containsKey(x - item[i].duration)) {
                        ans = Math.min(ans, bestCost.get(x - item[i].duration) + item[i].cost);
                    }
                } else {
                    long q = Integer.MAX_VALUE;
                    if (bestCost.containsKey(item[i].duration)) {
                        q = bestCost.get(item[i].duration);
                    }
                    bestCost.put(item[i].duration, Math.min(q, item[i].cost));
                }
            }
            ans = ans >= Integer.MAX_VALUE ? -1 : ans;
            out.printLine(ans);
        }

        class Items implements Comparable<Items> {
            int type;
            int point;
            int cost;
            int duration;

            public Items(int t, int p, int c, int d) {
                type = t;
                point = p;
                cost = c;
                duration = d;
            }

            public int compareTo(Items x) {
                if (this.point != x.point) return this.point - x.point;
                return this.type - x.type;
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
}

