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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int a1 = in.nextInt(), a2 = in.nextInt();
            int k1 = in.nextInt(), k2 = in.nextInt();
            int n = in.nextInt();
            if (k1 >= k2) {
                int rem = n;
                rem -= (k1 - 1) * a1;
                rem -= (k2 - 1) * a2;
                int min = Math.min(rem, a1 + a2);
                min = Math.max(min, 0);
                rem = n;
                int max = 0;
                while (rem > 0) {
                    if (a2 > 0 && rem >= k2) {
                        a2--;
                        rem -= k2;
                        max++;
                    } else if (a1 > 0 && rem >= k1) {
                        a1--;
                        rem -= k1;
                        max++;
                    } else {
                        break;
                    }
                }
                out.printLine(min + " " + max);
            } else {
                int rem = n;
                rem -= (k1 - 1) * a1;
                rem -= (k2 - 1) * a2;
                int min = Math.min(rem, a1 + a2);
                min = Math.max(0, min);
                rem = n;
                int max = 0;
                while (rem > 0) {
                    if (a1 > 0 && rem >= k1) {
                        a1--;
                        rem -= k1;
                        max++;
                    } else if (a2 > 0 && rem >= k2) {
                        a2--;
                        rem -= k2;
                        max++;
                    } else {
                        break;
                    }
                }
                out.printLine(min + " " + max);
            }

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

