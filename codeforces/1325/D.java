import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long xor = in.nextLong(), sum = in.nextLong();
            if (xor > sum) {
                out.printLine(-1);
                return;
            }
            if (sum == 0) {
                out.printLine(0);
                return;
            }
            if (sum == xor) {
                out.printLine(1);
                out.printLine(sum);
                return;
            }
            if ((sum - xor) % 2 == 0) {
                List<Long> answers = new ArrayList<>();
                long x = (sum - xor) / 2;
                long rem = sum - 2 * x;
                answers.add(x);
                answers.add(x);
                if (rem > 0) {
                    if (x != rem && (x ^ rem) + x == sum) {
                        answers.clear();
                        answers.add(x ^ rem);
                        answers.add(x);
                    } else {
                        answers.add(rem);
                    }
                }
                out.printLine(answers.size());
                StringBuilder str = new StringBuilder();
                for (long p : answers) {
                    str.append(p + " ");
                }
                out.printLine(str.toString().trim());
            } else {
                out.printLine(-1);
            }
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

