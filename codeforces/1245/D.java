import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.AbstractCollection;
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
        TaskD1 solver = new TaskD1();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD1 {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt();
            Points points[] = new Points[N];
            for (int i = 0; i < N; i++) {
                points[i] = new Points(i);
            }
            for (int i = 0; i < N; i++) {
                points[i].x = in.nextInt();
                points[i].y = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                points[i].c = in.nextInt();
                points[i].cost = points[i].c;
            }
            for (int i = 0; i < N; i++) {
                points[i].k = in.nextInt();
            }

            PriorityQueue<Points> queue = new PriorityQueue<>(new Comparator<Points>() {

                public int compare(Points o1, Points o2) {
                    if (o1.cost != o2.cost) {
                        return Long.compare(o1.cost, o2.cost);
                    }
                    return o1.index - o2.index;
                }
            });
            for (int i = 0; i < N; i++) {
                queue.add(points[i]);
            }
            long cost = 0;
            boolean isStation[] = new boolean[N];
            ArrayList<Integer> stations = new ArrayList<>();
            ArrayList<String> edges = new ArrayList<>();
            while (!queue.isEmpty()) {
                Points point = queue.poll();
                if (point.visited) {
                    continue;
                }
                if (point.parent == -1) {
                    stations.add(point.index + 1);
                } else {
                    edges.add((point.parent + 1) + " " + (point.index + 1));
                }
                cost += point.cost;
                point.visited = true;
                for (int i = 0; i < N; i++) {
                    if (!points[i].visited) {
                        long p = (Math.abs(points[i].x - point.x) + Math.abs(points[i].y - point.y)) * (points[i].k + point.k);
                        if (p <= points[i].cost) {
                            points[i].parent = point.index;
                            points[i].cost = p;
                            queue.remove(points[i]);
                            queue.add(points[i]);
                        }
                    }
                }
            }
//        for (int i = 0; i < N; i++) {
//            if (!isStation[points[i].index]) {
//                long min = Constants.INFINITY;
//                int minIndex = -1;
//                for (int j = 0; j < N; j++) {
//                    if (isStation[points[j].index]) {
//                        long p = (Math.abs(points[i].x - points[j].x) + Math.abs(points[i].y - points[j].y)) * (points[i].k + points[j].k);
//                        DebugUtils.debug(p, points[j], points[i]);
//                        if (p < min) {
//                            min = p;
//                            minIndex = j;
//                        }
//                    }
//                }
//                cost += min;
//                edges.add((points[i].index + 1) + " " + (points[minIndex].index + 1));
//            }
//        }
            out.printLine(cost);
            out.printLine(stations.size());
            for (int i : stations) {
                out.print(i + " ");
            }
            out.printLine();
            out.printLine(edges.size());
            for (String s : edges) {
                out.printLine(s);
            }
        }

        class Points {
            int x;
            int y;
            int index;
            long k;
            long c;
            long cost;
            boolean visited;
            int parent;

            public Points(int index) {
                this.index = index;
                this.parent = -1;
            }

            public String toString() {
                return index + " " + cost + "\n";
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

