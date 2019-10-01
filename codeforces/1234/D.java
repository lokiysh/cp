import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        char[] a;
        int[] tree;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String s = " " + in.next();
            int Q = in.nextInt();
            a = s.toCharArray();
            int N = a.length - 1;
            tree = new int[4 * a.length];
            init(1, N, 1);
            while (Q-- > 0) {
                int f = in.nextInt();
                if (f == 1) {
                    int position = in.nextInt();
                    char letter = in.next().charAt(0);
                    a[position] = letter;
                    update(1, N, 1, position);
                } else {
                    int left = in.nextInt(), right = in.nextInt();
                    out.printLine(Integer.bitCount(query(1, N, 1, left, right)));
                }
            }
        }

        public int init(int segLeft, int segRight, int segIndex) {
            if (segLeft == segRight) {
                return tree[segIndex] = (1 << (a[segLeft] - 'a'));
            }
            int mid = (segLeft + segRight) / 2;
            return tree[segIndex] = init(segLeft, mid, 2 * segIndex) | init(mid + 1, segRight, 2 * segIndex + 1);
        }

        public int update(int segLeft, int segRight, int segIndex, int index) {
            if (!(segLeft <= index && index <= segRight)) {
                return tree[segIndex];
            }
            if (segLeft == segRight) {
                return tree[segIndex] = (1 << (a[segLeft] - 'a'));
            }
            int mid = (segLeft + segRight) / 2;
            return tree[segIndex] = update(segLeft, mid, 2 * segIndex, index) | update(mid + 1, segRight, 2 * segIndex + 1, index);
        }

        public int query(int segLeft, int segRight, int segIndex, int left, int right) {
            if (left <= segLeft && segRight <= right) {
                return tree[segIndex];
            }
            if (right < segLeft || left > segRight) {
                return 0;
            }
            int mid = (segLeft + segRight) / 2;
            return query(segLeft, mid, 2 * segIndex, left, right) | query(mid + 1, segRight, 2 * segIndex + 1, left, right);
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

