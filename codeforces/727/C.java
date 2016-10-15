import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int i;
            int a[] = new int[n + 1];
            int last = n - (n % 3);
            for (i = 1; i <= last; i += 3) {
                System.out.println("? " + i + " " + (i + 1));
                System.out.flush();
                //in.next();
                int A = in.nextInt();
                System.out.println("? " + (i + 1) + " " + (i + 2));
                System.out.flush();
                //in.next();
                int B = in.nextInt();
                System.out.println("? " + (i) + " " + (i + 2));
                System.out.flush();
                //in.next();
                int C = in.nextInt();
                int a0 = (A - B + C) / 2;
                int a1 = A - a0;
                int a2 = C - a0;
                //DebugUtils.debug(A, B, C, a0, a1, a2);
                a[i] = a0;
                a[i + 1] = a1;
                a[i + 2] = a2;
            }
            for (i = last + 1; i <= n; i++) {
                System.out.println("? " + "1 " + i);
                System.out.flush();
                //in.next();
                int X = in.nextInt();
                a[i] = X - a[1];
            }
            System.out.print("! ");
            for (i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.flush();
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

        public void close() {
            writer.close();
        }

    }
}

