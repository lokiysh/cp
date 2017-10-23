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
            String s = in.next();
            int ans = 0, A = 0, B = 0;
            int i, j;
            //case for no B
            int length = s.length();
            for (i = 0; i < length; i++) {
                if (s.charAt(i) == 'a') {
                    A++;
                } else {
                    B++;
                }
            }
            ans = Math.max(A, B);
            int aBefore[] = new int[length];
            int aAfter[] = new int[length];
            if (s.charAt(length - 1) == 'a') {
                aAfter[length - 1] = 1;
            }
            for (i = length - 2; i >= 0; i--) {
                aAfter[i] = aAfter[i + 1];
                if (s.charAt(i) == 'a') {
                    aAfter[i]++;
                }
            }
            //first B
            for (i = 0; i < length; i++) {
                int newAns = 0;
                if (s.charAt(i) == 'b') {
                    //find all a's before
                    aBefore[i] = (i == 0) ? 0 : aBefore[i - 1];
                    //find the last  B
                    B = 0;

                    for (j = i; j < length; j++) {
                        if (s.charAt(j) == 'b') {
                            B++;
                            newAns = aBefore[i] + B + aAfter[j];
                            ans = Math.max(ans, newAns);
                        }
                    }
                } else {
                    aBefore[i] = (i == 0) ? 1 : aBefore[i - 1] + 1;
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

    }
}

