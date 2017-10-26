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
            int a[] = new int[10];
            Arrays.fill(a, -1);
            int i, j;
            for (i = 0; i < n; i++) {
                char symbol = in.next().charAt(0);
                int num = in.nextInt();
                String s = Integer.toBinaryString(num);
                while (s.length() < 10) {
                    s = "0" + s;
                }
                int index = 0;
                if (symbol == '&') {
                    for (j = s.length() - 1; j >= 0; j--) {
                        if (s.charAt(j) == '0') {
                            a[index] = 0;
                        }
                        index++;
                    }
                } else if (symbol == '|') {
                    for (j = s.length() - 1; j >= 0; j--) {
                        if (s.charAt(j) == '1') {
                            a[index] = 1;
                        }
                        index++;
                    }
                } else {
                    for (j = s.length() - 1; j >= 0; j--) {
                        if (s.charAt(j) == '1') {
                            if (a[index] == 1) {
                                a[index] = 0;
                            } else if (a[index] == -1) {
                                a[index] = -2;
                            } else if (a[index] == -2) {
                                a[index] = -1;
                            } else if (a[index] == 0) {
                                a[index] = 1;
                            }
                        }
                        index++;
                    }
                }
            }
            int count = 0, zero = 0, one = 0, two = 0;
            for (i = 0; i < 10; i++) {
                if (a[i] != -1) {
                    count++;
                }
                if (a[i] == 0) {
                    zero++;
                }
                if (a[i] == 1) {
                    one++;
                }
                if (a[i] == -2) {
                    two++;
                }
            }
            if (count == 0) {
                out.printLine(0);
                return;
            }
            //DebugUtils.debug(a);
            ArrayList<Character> symbols = new ArrayList<>();
            ArrayList<Integer> numbers = new ArrayList<>();
            StringBuilder str = new StringBuilder("");
            StringBuilder another = new StringBuilder("");
            StringBuilder twos = new StringBuilder("");
            for (i = 0; i < 10; i++) {
                if (a[i] == 1) {
                    str.append(1);
                } else {
                    str.append(0);
                }
                if (a[i] == 0) {
                    another.append(0);
                } else {
                    another.append(1);
                }
                if (a[i] == -2) {
                    twos.append(1);
                } else {
                    twos.append(0);
                }
            }
            str = str.reverse();
            another = another.reverse();
            twos = twos.reverse();
            if (one > 0) {
                symbols.add('|');
                numbers.add(Integer.parseInt(str.toString(), 2));
            }
            if (zero > 0) {
                symbols.add('&');
                numbers.add(Integer.parseInt(another.toString(), 2));
            }
            if (two > 0) {
                symbols.add('^');
                numbers.add(Integer.parseInt(twos.toString(), 2));
            }
            out.printLine(symbols.size());
            for (i = 0; i < symbols.size(); i++) {
                out.printLine(symbols.get(i) + " " + numbers.get(i));
            }
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

