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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            int i, j;
            boolean possible = true;
            String words[] = new String[N];
            for (i = 0; i < N; i++) {
                String s = in.next();
                // check if chars are repeated
                boolean b[] = new boolean[26];
                for (j = s.length() - 1; j >= 0; j--) {
                    if (b[s.charAt(j) - 'a']) {
                        possible = false;
                    }
                    b[s.charAt(j) - 'a'] = true;
                }
                words[i] = s;
            }
            if (!possible) {
                out.printLine("NO");
                return;
            }
            char nextChar[] = new char[26];
            Arrays.fill(nextChar, ' ');
            boolean used[] = new boolean[26];
            boolean isStart[] = new boolean[26];
            Arrays.fill(isStart, true);
            for (i = 0; i < N; i++) {
                int n = words[i].length();
                used[words[i].charAt(0) - 'a'] = true;
                for (j = 1; j < n; j++) {
                    if (nextChar[words[i].charAt(j - 1) - 'a'] != ' ' &&
                            nextChar[words[i].charAt(j - 1) - 'a'] != words[i].charAt(j)) {
                        //DebugUtils.debug(words[i], j);
                        out.printLine("NO");
                        return;
                    }
                    nextChar[words[i].charAt(j - 1) - 'a'] = words[i].charAt(j);
                    used[words[i].charAt(j) - 'a'] = true;
                    isStart[words[i].charAt(j) - 'a'] = false;
                }

            }
//        DebugUtils.debug(nextChar);
//        DebugUtils.debug(used);
//        DebugUtils.debug(isStart);
            String ans = "";
            for (i = 0; i < 26; i++) {
                if (used[i] && isStart[i]) {
                    ans += (char) (i + 'a');
                    j = i;
                    while (nextChar[j] != ' ' && used[j]) {
                        used[j] = false;
                        j = nextChar[j] - 'a';

                        ans += (char) (j + 'a');
                    }
                }
            }
            if (ans.length() == 0) {
                out.printLine("NO");
                return;
            }
            boolean present[] = new boolean[26];
            for (i = 0; i < ans.length(); i++) {
                if (present[ans.charAt(i) - 'a']) {
                    out.printLine("NO");
                    return;
                }
                present[ans.charAt(i) - 'a'] = true;
            }
            for (i = 0; i < N; i++) {
                if (ans.indexOf(words[i]) < 0) {
                    out.printLine("NO");
                    return;
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

