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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        int sx;
        int sy;
        int ex;
        int ey;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            char a[][] = new char[N][M];
            int i, j;
            for (i = 0; i < N; i++) {
                String s = in.next();
                for (j = 0; j < s.length(); j++) {
                    a[i][j] = s.charAt(j);
                    if (a[i][j] == 'S') {
                        sx = i;
                        sy = j;
                    }
                    if (a[i][j] == 'E') {
                        ex = i;
                        ey = j;
                    }
                }
            }
            String mapping = in.next();
            HashSet<String> permutations = IntegerUtils.permutations("0123");
            int ans = 0;
            for (String s : permutations) {
                boolean p = possible(a, mapping, s);
                if (p) {
                    ans++;
                }
            }
            out.printLine(ans);
        }

        public boolean possible(char a[][], String mapping, String direction) {
            int x = sx;
            int y = sy;
            int index = 0;
            int length = mapping.length();
            while (true) {

                if (x < 0 || y < 0 || x >= a.length || y >= a[0].length) {
                    return false;
                }
                if (a[x][y] == '#') {
                    return false;
                }
                if (a[x][y] == 'E') {
                    return true;
                }
                if (index >= length) {
                    return false;
                }

                int point = direction.indexOf(mapping.charAt(index));
                x += dx[point];
                y += dy[point];
                index++;
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

    static class IntegerUtils {
        static HashSet<String> permutations = new HashSet<>();

        public static HashSet<String> permutations(String s) {
            permutations.clear();
            char ch[] = s.toCharArray();
            generatePerms(ch.length, ch);
            return permutations;
        }

        public static void generatePerms(int n, char[] ch) {
            if (n == 1) {
                permutations.add(new String(ch));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (i == n - 1 || ch[i] != ch[n - 1]) {
                    swap(ch, i, n - 1);
                    generatePerms(n - 1, ch);
                    swap(ch, i, n - 1);
                }
            }
        }

        public static void swap(char ch[], int i, int j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }

    }
}

