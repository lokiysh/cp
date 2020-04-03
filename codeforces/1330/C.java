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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            int p[] = new int[M];
            Items items[] = new Items[M];
            long sum = 0;
            for (int i = 0; i < M; i++) {
                items[i] = new Items(in.nextInt(), i);
                sum += items[i].L;
            }
            if (sum < N) {
                out.printLine(-1);
                return;
            }
//        Arrays.sort(items);
            for (int i = 0; i < M; i++) {
                p[i] = i + 1;
            }

            int end = N;
            for (int i = M - 1; i >= 0; i--) {
                if (p[i] > N - items[i].L + 1) {
                    out.printLine(-1);
                    return;
                }
                p[i] = Math.max(end - items[i].L + 1, p[i]);
                end = p[i] - 1;
            }


            for (int i = 0; i < M; i++) {
                out.print(p[i] + " ");
            }
            out.printLine();
        }

        class Items implements Comparable<Items> {
            int L;
            int index;

            public Items(int L, int index) {
                this.L = L;
                this.index = index;
            }

            public int compareTo(Items o) {
                if (o.L != this.L) {
                    return this.L - o.L;
                }
                return o.index - this.index;
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

