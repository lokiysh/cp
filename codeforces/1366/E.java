import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
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
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            int a[] = new int[N], b[] = new int[M];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
                set.add(a[i]);
            }
            for (int i = 0; i < M; i++) {
                b[i] = in.nextInt();
            }
            for (int i = 0; i < M; i++) {
                if (!set.contains(b[i])) {
                    out.printLine(0);
                    return;
                }
            }
            int minAfter[] = new int[N];
            minAfter[N - 1] = a[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                minAfter[i] = Math.min(minAfter[i + 1], a[i]);
            }
            if (minAfter[0] != b[0]) {
                out.printLine(0);
                return;
            }
            if (M == 1) {
                out.printLine(1);
                return;
            }
            int left = 0;
            long ans = 1, MOD = 998244353;
            for (int i = 1; i < M; i++) {
                while (left < N && minAfter[left] != b[i]) {
                    left++;
                }
                int firstPoint = left;
                while (left < N && minAfter[left] == b[i]) {
                    left++;
                }
                int lastPoint = left;
                ans = (ans * (lastPoint - firstPoint)) % MOD;
            }
            out.printLine(ans);
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

