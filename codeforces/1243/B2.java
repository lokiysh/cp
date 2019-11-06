import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        TaskB2 solver = new TaskB2();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB2 {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            char a[] = in.next().toCharArray();
            char b[] = in.next().toCharArray();
            HashSet<Integer> same = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (a[i] == b[i]) {
                    same.add(i);
                }
            }
            List<String> operations = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (a[i] != b[i]) {
                    int index = -1;
                    for (int j = i + 1; j < N; j++) {
                        if (same.contains(j)) continue;
                        if (a[j] == a[i]) {
                            index = j;
                            break;
                        }
                    }
                    if (index == -1) {
                        for (int j = i + 1; j < N; j++) {
                            if (same.contains(j)) continue;
                            if (a[i] == b[j]) {
                                index = j;
                                break;
                            }
                        }
                        if (index != -1) {
                            operations.add((index + 1) + " " + (index + 1));
                            char temp = a[index];
                            a[index] = b[index];
                            b[index] = temp;
                            operations.add((index + 1) + " " + (i + 1));
                            temp = b[i];
                            b[i] = a[index];
                            a[index] = temp;
                        }
                    } else {
                        operations.add((index + 1) + " " + (i + 1));
                        char temp = b[i];
                        b[i] = a[index];
                        a[index] = temp;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (a[i] != b[i]) {
                    out.printLine("NO");
                    return;
                }
            }
            if (operations.size() > 2 * N) {
                out.printLine("NO");
            } else {
                out.printLine("YES");
                out.printLine(operations.size());
                for (String s : operations) {
                    out.printLine(s);
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
}

