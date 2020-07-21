import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskA solver = new TaskA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            boolean a[] = new boolean[N], b[] = new boolean[N];
//        boolean firstCopy[] = new boolean[N];
            String A = in.next(), B = in.next();
            for (int i = 0; i < N; i++) {
                if (A.charAt(i) == '1') {
                    a[i] = true;
//                firstCopy[i] = true;
                }
                if (B.charAt(i) == '1') {
                    b[i] = true;
                }
            }
            boolean first = a[0];
            int count = 0;

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = N - 1; i > 0; i--) {
                if (first == b[i]) {
                    result.add(1);
//                firstCopy[0] = !firstCopy[0];
                }
                result.add(i + 1);
//            int left = 0, right = i;
//            while (left <= right) {
//                boolean temp = firstCopy[left];
//                firstCopy[left] = !firstCopy[right];
//                firstCopy[right] = !temp;
//                left++;
//                right--;
//            }
                if (count % 2 == 0) {
                    first = !a[N - 1 - count / 2];
                } else {
                    first = a[count / 2 + 1];
                }
                count++;
            }
            if (first != b[0]) {
                result.add(1);
//            firstCopy[0] = !firstCopy[0];
            }
//        DebugUtils.debug(firstCopy);
            out.print(result.size() + " ");
            for (int x : result) {
                out.print(x + " ");
            }
            out.printLine();
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

