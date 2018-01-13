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
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long a = in.nextLong();
            long b = in.nextLong();
            char c[] = Long.toString(a).toCharArray();
            char d[] = Long.toString(b).toCharArray();
            if (d.length > c.length) {
                Arrays.sort(c);
                String x = "";
                for (int i = c.length - 1; i >= 0; i--) {
                    x += c[i];
                }
                out.printLine(x);
                return;
            }
            int digits[] = new int[10];
            int i, j;
            for (i = 0; i < c.length; i++) {
                digits[c[i] - '0']++;
            }
            boolean flag = false;
            String ans = "";
            for (i = 0; i < c.length; i++) {
                if (flag) {
                    //find the maximum digit you can
                    for (j = 9; j >= 0; j--) {
                        if (digits[j] > 0) {
                            ans += j;
                            digits[j]--;
                            break;
                        }
                    }
                } else {
                    // check if we have this digit
                    if (digits[d[i] - '0'] > 0) {
                        ans += d[i];
                        digits[d[i] - '0']--;
                    } else {
                        for (j = d[i] - '0'; j >= 0; j--) {
                            if (digits[j] > 0) {
                                ans += j;
                                digits[j]--;
                                flag = true;
                                ;
                                break;
                            }
                        }
                        if (!flag) {
                            //we could not find a digit to replace, so travel back and find first digit who has lesser available
                            for (j = i - 1; j >= 0; j--) {
                                digits[ans.charAt(j) - '0']++;
                                boolean found = false;
                                for (int k = ans.charAt(j) - '0' - 1; k >= 0; k--) {
                                    if (digits[k] > 0) {
                                        found = true;
                                        digits[k]--;
                                        ans = ans.substring(0, j);
                                        ans += k;
                                        i = j;
                                        flag = true;
                                        break;
                                    }
                                }
                                if (found) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            out.printLine(ans);
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

