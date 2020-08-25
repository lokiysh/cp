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
        TaskB solver = new TaskB();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long p = in.nextInt(), f = in.nextInt();
            long cnts = in.nextInt(), cntw = in.nextInt();
            long s = in.nextInt(), w = in.nextInt();
            long maxAns = 0;
            for (long i = 0; i <= cnts; i++) {
                if (i * s <= p) {
                    long totalSwords = i;
                    long totalWarAxes = Math.min((p - i * s) / w, cntw);
                    if (s <= w) {
                        long totalSwordsf = Math.min(f / s, cnts - totalSwords);
                        long totalWarAxesf = Math.min((f - totalSwordsf * s) / w, cntw - totalWarAxes);
                        maxAns = Math.max(maxAns, totalSwords + totalWarAxes + totalSwordsf + totalWarAxesf);
                    } else {
                        long totalWarAxesf = Math.min(f / w, cntw - totalWarAxes);
                        long totalSwordsf = Math.min((f - totalWarAxesf * w) / s, cnts - totalSwords);
                        maxAns = Math.max(maxAns, totalSwords + totalWarAxes + totalSwordsf + totalWarAxesf);
                    }
                }
            }
            out.printLine(maxAns);
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

