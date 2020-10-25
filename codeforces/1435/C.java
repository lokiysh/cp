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
            int a[] = new int[6];
            for (int i = 0; i < 6; i++) {
                a[i] = in.nextInt();
            }
            int N = in.nextInt();
            int b[] = new int[N];
            for (int i = 0; i < N; i++) {
                b[i] = in.nextInt();
            }
            Items numbers[] = new Items[N * 6];
            int c = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 6; j++) {
                    numbers[c] = new Items(b[i] - a[j], i);
                    c++;
                }
            }
            Arrays.sort(numbers);
            int seenCount = 0, j = 0;
            int seen[] = new int[N];
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                seen[numbers[i].index]++;
                if (seen[numbers[i].index] == 1) {
                    seenCount++;
                }
                while (j < numbers.length && seenCount == N) {
                    ans = Math.min(ans, numbers[i].value - numbers[j].value);
                    seen[numbers[j].index]--;
                    if (seen[numbers[j].index] == 0) {
                        seenCount--;
                    }
                    j++;
                }
            }
            out.printLine(ans);
        }

        class Items implements Comparable<Items> {
            int value;
            int index;

            public Items(int value, int index) {
                this.value = value;
                this.index = index;
            }

            public int compareTo(Items x) {
                if (x.value != this.value) {
                    return this.value - x.value;
                }
                return Integer.compare(this.index, x.index);
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

