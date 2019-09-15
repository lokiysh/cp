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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            char s[] = in.next().toCharArray();
            char t[] = in.next().toCharArray();
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (s[i] == 'a') {
                    count++;
                }
                if (t[i] == 'a') {
                    count++;
                }
            }
            if (count % 2 > 0) {
                out.printLine(-1);
                return;
            }
            int a = 0, b = 0;
            List<Integer> as = new ArrayList<>(), bs = new ArrayList<>();
            List<Integer> at = new ArrayList<>(), bt = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (s[i] != t[i]) {
                    if (s[i] == 'a') {
                        a++;
                        as.add(i + 1);
                        bt.add(i + 1);
                    } else {
                        b++;
                        bs.add(i + 1);
                        at.add(i + 1);
                    }
                }
            }
            int ans = 0;
            int asSize = as.size(), bsSize = bs.size();
            List<String> output = new ArrayList<>();
            int index = 0;
            while (asSize > 1) {
                ans++;
                asSize -= 2;
                output.add(as.get(index) + " " + as.get(index + 1));
                index += 2;
            }
            index = 0;
            while (bsSize > 1) {
                ans++;
                bsSize -= 2;
                output.add(bs.get(index) + " " + bs.get(index + 1));
                index += 2;
            }
            if (asSize == 1 && bsSize == 1) {
                ans += 2;
                output.add(as.get(as.size() - 1) + " " + as.get(as.size() - 1));
                output.add(as.get(as.size() - 1) + " " + bs.get(bs.size() - 1));
            }
            out.printLine(ans);
            for (String sout : output) {
                out.printLine(sout);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

