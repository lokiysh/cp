import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.util.Comparator;
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
            int N = in.nextInt(), K = in.nextInt();
            Segments segments[] = new Segments[N];
            int MAX = 200001;
            int finished[] = new int[MAX];
            List<Segments> start[] = new List[MAX];
            for (int i = 0; i < MAX; i++) {
                start[i] = new ArrayList<>();

            }
            for (int i = 0; i < N; i++) {
                segments[i] = new Segments(in.nextInt(), in.nextInt(), i + 1);
                finished[segments[i].right]++;
                start[segments[i].left].add(segments[i]);
            }
            if (N == 1) {
                out.printLine(0);
                return;
            }
            List<Integer> deleted = new ArrayList<>();
            int finish = 0;
            TreeSet<Segments> openIntervals = new TreeSet<>(new Comparator<Segments>() {

                public int compare(Segments o1, Segments o2) {
                    if (o1.right != o2.right) {
                        return o2.right - o1.right;
                    } else if (o2.left != o1.left) {
                        return o2.left - o1.left;
                    } else {
                        return 1;
                    }
                }
            });
            for (int i = 0; i < MAX; i++) {
                openIntervals.addAll(start[i]);
                int k = 0;
                while (openIntervals.size() - finish > K) {
                    if (openIntervals.size() == 0) {
                        break;
                    }
                    Segments s = openIntervals.pollFirst();
                    deleted.add(s.index);
                    finished[s.right]--;
                }
                finish += finished[i] - k;
            }
            out.printLine(deleted.size());
            for (int i : deleted) {
                out.print(i + " ");
            }
            out.printLine();
        }

        class Segments {
            int left;
            int right;
            int index;
            boolean deleted;

            public Segments(int l, int r, int i) {
                left = l;
                right = r;
                index = i;
            }

            public String toString() {
                return "[" + left + "," + right + "]" + deleted;
            }

            public int hashCode() {
                return Integer.parseInt(toString());
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

