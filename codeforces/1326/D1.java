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
        TaskD1 solver = new TaskD1();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskD1 {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String s = in.next();
            String a = longestPalinPrefix(s);
            String reverse = new StringBuilder(s).reverse().toString();
            String b = longestPalinPrefix(reverse);
            if (b.length() > a.length()) {
                a = b;
            }
            int N = s.length();
            int left = 0, right = N - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    String rem = s.substring(left, right + 1);
                    String p = longestPalinPrefix(rem);
                    String q = longestPalinPrefix(new StringBuilder(rem).reverse().toString());
                    if (p.length() + 2 * (left) > a.length()) {
                        a = s.substring(0, left) + p + s.substring(right + 1);
                    }
                    if (q.length() + 2 * (left) > a.length()) {
                        a = s.substring(0, left) + q + s.substring(right + 1);
                    }
                    break;
                }
            }
            out.printLine(a);
        }

        public String longestPalinPrefix(String s) {
            String a = s + "#" + new StringBuilder(s).reverse().toString();
            int array[] = StringUtils.lpsArray(a);
            return a.substring(0, array[array.length - 1]);
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

    static class StringUtils {
        public static int[] lpsArray(String pattern) {
            int N = pattern.length();
            int lps[] = new int[N];
            int len = 0, i = 1;
            while (i < N) {
                if (pattern.charAt(i) == pattern.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {
                    if (len > 0) {
                        len = lps[len - 1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
            return lps;
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

