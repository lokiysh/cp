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
            char oleg[] = in.next().toCharArray();
            char igor[] = in.next().toCharArray();
            Arrays.sort(oleg);
            Arrays.sort(igor);
            int n = oleg.length;
            int olegIndexBegin = 0, olegIndexEnd = (n - 1) / 2;
            int igorIndexBegin = n - 1, igorIndexEnd = (n + 1) / 2;
            char answer[] = new char[n];
            int answerIndexBegin = 0, answerIndexEnd = n - 1;
            int turn = 0;

            for (int i = 0; i < n; i++) {
                //DebugUtils.debug(olegIndexBegin, olegIndexEnd, igorIndexBegin, igorIndexEnd, answer, answerIndexBegin, answerIndexEnd);
                if (i % 2 == 0) {
                    if (oleg[olegIndexBegin] < igor[igorIndexBegin]) {
                        answer[answerIndexBegin++] = oleg[olegIndexBegin++];
                    } else {
                        answer[answerIndexEnd--] = oleg[olegIndexEnd--];
                    }
                } else {
                    if (oleg[olegIndexBegin] >= igor[igorIndexBegin]) {
                        answer[answerIndexEnd--] = igor[igorIndexEnd++];
                    } else {
                        answer[answerIndexBegin++] = igor[igorIndexBegin--];
                    }
                }
            }
            for (int i = 0; i < answer.length; i++) {
                out.print(answer[i]);
            }
            out.printLine();
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

    }
}

