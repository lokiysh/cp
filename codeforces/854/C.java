import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractCollection;
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
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), k = in.nextInt();
            PriorityQueue<Items> queue = new PriorityQueue<>();
            Integer a[] = in.nextIntArray(n);
            for (int i = 0; i < k; i++) {
                queue.add(new Items(i + 1, a[i]));
            }
            long ans = 0;
            int index = k + 1;
            int array[] = new int[n];
            for (int i = k; i < n; i++) {
                queue.add(new Items(i + 1, a[i]));
                Items x = queue.poll();
                ans += x.value * (index - x.index);
                array[x.index - 1] = index;
                index++;
            }
            while (!queue.isEmpty()) {
                Items x = queue.poll();
                ans += (index - x.index) * x.value;
                array[x.index - 1] = index;
                index++;
            }
            out.printLine(ans);
            for (int i = 0; i < n; i++) {
                out.print(array[i] + " ");
            }
        }

        class Items implements Comparable<Items> {
            int index;
            long value;

            public Items(int index, long value) {
                this.index = index;
                this.value = value;
            }

            public int compareTo(Items x) {
                if (x.value != this.value) {
                    return Long.compare(x.value, this.value);
                } else {
                    return x.index - this.index;
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

        public Integer[] nextIntArray(int size) {
            Integer array[] = new Integer[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
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

