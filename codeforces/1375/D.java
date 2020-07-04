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
        boolean[] present;
        int[] a;
        int N;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            N = in.nextInt();
            present = new boolean[N + 1];
            a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            ArrayList<Integer> result = new ArrayList<>();
            while (true) {
                int x = findMEX();
                if (x == N) {
                    break;
                }
                a[x] = x;
                result.add(x + 1);
            }
            int largest = N;
            while (!isSorted()) {
                int x = findMEX();
                if (x == N) {
                    a[x - 1] = x;
                    result.add(x);
                } else if (a[x] == largest) {
                    a[x - 1] = x;
                    largest = x;
                    result.add(x);
                } else {
                    a[x] = x;
                    result.add(x + 1);
                }
            }
            out.printLine(result.size());
            for (int x : result) {
                out.print(x + " ");
            }
            out.printLine();
        }

        public int findMEX() {
            Arrays.fill(present, false);
            for (int i = 0; i < N; i++) {
                present[a[i]] = true;
            }
            for (int i = 0; i <= N; i++) {
                if (!present[i]) {
                    return i;
                }
            }
            return 0;
        }

        public boolean isSorted() {
            for (int i = 1; i < N; i++) {
                if (a[i] < a[i - 1]) {
                    return false;
                }
            }
            return true;
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

