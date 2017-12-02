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
        String f0 = "What are you doing at the end of the world? Are you busy? Will you save us?";
        String pre = "What are you doing while sending \"";
        String mid = "\"? Are you busy? Will you send \"";
        String post = "\"?";
        int LIMIT = 100000;
        long[] lengths = new long[LIMIT + 1];
        int preL = pre.length();
        int midL = mid.length();

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            Arrays.fill(lengths, Long.MAX_VALUE);
            int i;
            lengths[0] = f0.length();
            for (i = 1; i <= LIMIT; i++) {
                lengths[i] = pre.length() + mid.length() + post.length() + 2 * lengths[i - 1];
                if (lengths[i] >= (long) 1e18) {
                    break;
                }
            }
            int q = in.nextInt();
            while (q-- > 0) {
                int n = in.nextInt();
                long k = in.nextLong();
                if (k > lengths[n]) {
                    out.print(".");
                    continue;
                }
                out.print(findCharacter(n, k));
            }
            out.printLine();
        }

        public char findCharacter(int n, long k) {
            if (n == 0) {
                return f0.charAt((int) k - 1);
            }
            if (k <= preL) {
                return pre.charAt((int) k - 1);
            }
            k -= preL;
            if (k <= lengths[n - 1]) {
                return findCharacter(n - 1, k);
            }
            k -= lengths[n - 1];
            if (k <= midL) {
                return mid.charAt((int) k - 1);
            }
            k -= midL;
            if (k <= lengths[n - 1]) {
                return findCharacter(n - 1, k);
            }
            k -= lengths[n - 1];
            return post.charAt((int) k - 1);
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

