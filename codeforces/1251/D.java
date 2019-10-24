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
            long s = in.nextLong();
            Items items[] = new Items[N];
            for (int i = 0; i < N; i++) {
                items[i] = new Items(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(items, new Comparator<Items>() {

                public int compare(Items o1, Items o2) {
                    if (o1.left != o2.left) {
                        return o1.left - o2.left;
                    }
                    if (o1.right != o2.right) {
                        return o1.right - o2.right;
                    }
                    return o1.index - o2.index;
                }
            });
            long low = 0, high = s;
            long ans = 0;
            while (low <= high) {
                long mid = (low + high) / 2;
                if (possible(mid, items, s)) {
                    low = mid + 1;
                    ans = mid;
                } else {
                    high = mid - 1;
                }
            }
            out.printLine(ans);
        }

        public boolean possible(long x, Items items[], long s) {
            int N = items.length;
            long sum = 0;
            ArrayList<Integer> b = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                sum += items[i].left;
                if (items[i].right < x) {
                    continue;
                }
                b.add(items[i].left);
            }
            if (b.size() <= N / 2) {
                return false;
            }
            int count = 0;
            for (int i = b.size() - 1; count < N / 2 + 1; i--) {
                if (b.get(i) < x) {
                    sum += x - b.get(i);
                }
                count++;
            }
            return sum <= s;
        }

        class Items {
            int left;
            int right;
            int index;

            public Items(int left, int right, int index) {
                this.left = left;
                this.right = right;
                this.index = index;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

