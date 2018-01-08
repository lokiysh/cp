import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            int T = in.nextInt();
            int a[] = new int[N];
            int t[] = new int[N];
            Items items[] = new Items[N];
            int i, j, low, mid, high, ans = 0;
            for (i = 0; i < N; i++) {
                a[i] = in.nextInt();
                t[i] = in.nextInt();
                items[i] = new Items(i, a[i], t[i]);
            }
            Arrays.sort(items);
            low = 0;
            high = N;
            ArrayList<Integer> p = new ArrayList<>();
            while (low <= high) {
                mid = (int) Math.ceil((low + high) / 2.0);
                //DebugUtils.debug(low, high, mid);
                int time = 0, k = 0;
                ArrayList<Integer> q = new ArrayList<>();
                for (i = 0; i < N; i++) {
                    if (items[i].a >= mid) {
                        k++;
                        q.add(items[i].index);
                        time += items[i].t;
                    }
                    if (k == mid) {
                        break;
                    }
                }
                if (k == mid && time <= T) {
                    if (ans < mid) {
                        ans = mid;
                        p.clear();
                        p.addAll(q);
                    }
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
            out.printLine(ans);
            out.printLine(ans);
            for (int x : p) {
                out.print((x + 1) + " ");
            }
            out.printLine();
        }

        class Items implements Comparable<Items> {
            int a;
            int t;
            int index;

            public Items(int index, int a, int t) {
                this.a = a;
                this.t = t;
                this.index = index;
            }

            public int compareTo(Items x) {
                if (x.t != this.t) {
                    return this.t - x.t;
                }
                return x.a - this.a;
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

