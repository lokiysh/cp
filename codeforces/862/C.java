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
            int N = in.nextInt(), X = in.nextInt(), i;
            if (N == 2 && X == 0) {
                out.printLine("NO");
                return;
            }
            HashSet<Integer> ans = new HashSet<>();
            int rem = N % 4;
            if (rem == 0) {
                rem = 4;
            }
            if (rem == 2 && X == 0) {
                ans.add(8);
                ans.add(12);
                ans.add(4);
                N -= 3;
                rem = 3;
            }
            fillSet(rem, X, ans);
            N -= rem;
            int index = 8;
            //DebugUtils.debug(ans);
            while (N > 0) {
                boolean present = false;
                for (i = index; i < index + 4; i++) {
                    if (ans.contains(i)) {
                        present = true;
                    }
                }
                if (!present) {
                    for (i = index; i < index + 4; i++) {
                        ans.add(i);
                    }
                    N -= 4;
                }
                index += 4;
            }
            out.printLine("YES");
            int xor = 0;
            for (int element : ans) {
                out.print(element + " ");
                xor ^= element;
            }
            //DebugUtils.debug(xor);
            out.printLine();
        }

        public void fillSet(int number, int X, HashSet<Integer> set) {
            if (number == 1) {
                set.add(X);
            } else if (number == 2) {
                if (X > 0) {
                    set.add(0);
                    set.add(X);
                }
            } else if (number == 3) {
                if (X > 1) {
                    set.add(0);
                    set.add(1);
                    set.add(X ^ 1);
                } else if (X == 0) {
                    set.add(1);
                    set.add(2);
                    set.add(3);
                } else if (X == 1) {
                    set.add(0);
                    set.add(2);
                    set.add(3);
                }
            } else {
                if (X < 1 || X > 3) {
                    set.add(1);
                    set.add(2);
                    set.add(3);
                    set.add(X);
                } else if (X == 1) {
                    set.add(0);
                    set.add(2);
                    set.add(4);
                    set.add(7);
                } else if (X == 2) {
                    set.add(0);
                    set.add(1);
                    set.add(5);
                    set.add(6);
                } else if (X == 3) {
                    set.add(0);
                    set.add(2);
                    set.add(6);
                    set.add(7);
                }

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

