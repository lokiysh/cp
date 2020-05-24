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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskF solver = new TaskF();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskF {
        HashSet<Character>[] possible;
        String[] a;
        boolean isThere;
        String ans;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            a = new String[N];
            possible = new HashSet[M];
            for (int i = 0; i < M; i++) {
                possible[i] = new HashSet<>();
            }
            for (int i = 0; i < N; i++) {
                a[i] = in.next();
                for (int j = 0; j < M; j++) {
                    possible[j].add(a[i].charAt(j));
                }
            }
            isThere = false;
            ans = "";
            char array[] = new char[M];
            recur(0, array);
            if (isThere) {
                out.printLine(ans);
            } else {
                out.printLine(-1);
            }
        }

        public void recur(int index, char[] array) {
            if (isThere) {
                return;
            }
            if (index == array.length) {
                if (isOk(index, array)) {
                    isThere = true;
                    ans = "";
                    for (int i = 0; i < array.length; i++) {
                        ans += array[i];
                    }
                }
                return;
            }
            for (Character c : possible[index]) {
                array[index] = c;
                if (isOk(index, array)) {
                    recur(index + 1, array);
                }
            }
        }

        public boolean isOk(int index, char array[]) {
            int diff[] = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < index; j++) {
                    if (a[i].charAt(j) != array[j]) {
                        diff[i]++;
                    }
                }
            }
            for (int i = 0; i < a.length; i++) {
                if (diff[i] > 1) {
                    return false;
                }
            }
            return true;
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

