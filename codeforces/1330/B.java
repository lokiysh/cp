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
        TaskB solver = new TaskB();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            HashSet<Integer> forward = new HashSet<>(), backward = new HashSet<>();
            boolean fPossible[] = new boolean[N], bPossible[] = new boolean[N];
            long sum = 0;
            long correctSum = 0;
            for (int i = 0; i < N; i++) {
                forward.add(a[i]);
                sum += a[i];
                correctSum += (i + 1);
                if (forward.size() == i + 1 && sum == correctSum) {
                    fPossible[i] = true;
                }
            }
            sum = 0;
            correctSum = 0;
            int seq = 0;
            for (int i = N - 1; i >= 0; i--) {
                backward.add(a[i]);
                seq++;
                sum += a[i];
                correctSum += (seq);
                if (backward.size() == seq && sum == correctSum) {
                    bPossible[i] = true;
                }
            }
            ArrayList<String> answers = new ArrayList<>();
            for (int i = 0; i < N - 1; i++) {
                if (fPossible[i] && bPossible[i + 1]) {
                    answers.add((i + 1) + " " + (N - i - 1));
                }
            }
            out.printLine(answers.size());
            for (String ans : answers) {
                out.printLine(ans);
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

