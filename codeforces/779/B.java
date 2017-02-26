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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long n = in.nextInt(), k = in.nextInt();
            int i;
            StringBuilder s = new StringBuilder(Long.toString(n));
            int length = s.length();
            long K = (long) Math.pow(10, k);
            if (k == 0) {
                out.printLine(0);
                return;
            }
            int ans = 0;
            char c[] = s.toString().toCharArray();
            i = s.length() - 1;
            while (k > 0 && i >= 0) {
                if (c[i] != '0') {
                    c[i] = 'd';
                    ans++;
                } else {
                    k--;
                }
                i--;
            }
            if (k > 0) {
                out.printLine(s.length() - 1);
                return;
            }
            String p = "";
            for (i = 0; i < s.length(); i++) {
                if (c[i] != 'd') {
                    p += c[i];
                }
            }
            //DebugUtils.debug(p);
            if (p.length() == 1) {
                out.printLine(ans);
                return;
            }
            for (i = 0; i < p.length() - 1; i++) {
                if (p.charAt(i) == '0') {
                    ans++;
                } else {
                    break;
                }
            }
            out.printLine(ans);


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

