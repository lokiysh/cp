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
        int[] visited;
        int[] a;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), i;
            int b[] = new int[n];
            a = new int[n];
            visited = new int[n];
            for (i = 0; i < n; i++) {
                a[i] = in.nextInt() - 1;
            }
            int sum = 0;
            for (i = 0; i < n; i++) {
                b[i] = in.nextInt();
                sum += b[i];
            }

            int ans = 0;
            int x[] = new int[n];
            for (i = 0; i < n; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                    x[ans] = i;
                    ans++;
                }
            }
            //DebugUtils.debug(x);
            int copy = a[x[0]];
            for (i = 0; i < ans - 1; i++) {
                a[x[i]] = a[x[i + 1]];
            }
            a[x[ans - 1]] = copy;
            //DebugUtils.debug(a);
            if (ans == 1) ans = 0;
            int state = 0, index = 0;
            for (i = 0; i < n; i++) {
                index = a[index];
                if (b[index] == 1) {
                    state = 1 - state;
                }
            }
            if (state == 0) ans++;
            out.printLine(ans);
        }

        public void dfs(int index) {
            if (visited[index] == 1) return;
            ;
            visited[index] = 1;
            dfs(a[index]);
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

