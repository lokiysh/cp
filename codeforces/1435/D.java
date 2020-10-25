import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.AbstractCollection;
import java.util.Vector;
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
            int N = in.nextInt();
            Events events[] = new Events[2 * N];
            for (int i = 0; i < 2 * N; i++) {
                events[i] = new Events(in.next().charAt(0));
                if (events[i].type == '-') {
                    events[i].value = in.nextInt();
                }
            }
            Stack<Events> stack = new Stack<>();
            for (int i = 0; i < 2 * N; i++) {
                if (events[i].type == '+') {
                    stack.push(events[i]);
                } else {
                    if (stack.isEmpty()) {
                        out.printLine("NO");
                        return;
                    }
                    Events e = stack.pop();
                    e.value = events[i].value;
                }
            }
            PriorityQueue<Events> queue = new PriorityQueue<>(new Comparator<Events>() {

                public int compare(Events o1, Events o2) {
                    return o1.value - o2.value;
                }
            });

            for (int i = 0; i < 2 * N; i++) {
                if (events[i].type == '+') {
                    queue.add(events[i]);
                } else {
                    if (queue.isEmpty()) {
                        out.printLine("NO");
                        return;
                    }
                    Events e = queue.poll();
                    if (e.value != events[i].value) {
                        out.printLine("NO");
                        return;
                    }
                }
            }
            out.printLine("YES");
            for (int i = 0; i < 2 * N; i++) {
                if (events[i].type == '+') {
                    out.print(events[i].value + " ");
                }
            }
            out.printLine();
        }

        class Events {
            char type;
            int value;

            public Events(char type) {
                this.type = type;
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

