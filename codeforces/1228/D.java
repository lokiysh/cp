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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        boolean[] visited;
        List<HashSet<Integer>> graph;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int N = in.nextInt(), M = in.nextInt();
            graph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                graph.add(new HashSet<>());
            }
            int setNumber[] = new int[N];
            int setCount[] = new int[4];
            visited = new boolean[N];
            for (int i = 0; i < M; i++) {
                int u = in.nextInt() - 1, v = in.nextInt() - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            setNumber[0] = 1;
            setCount[1]++;
            for (int i = 1; i < N; i++) {
                if (!graph.get(0).contains(i)) {
                    setNumber[i] = 1;
                    setCount[1]++;
                }
            }
            for (int i = 1; i < N; i++) {
                if (setNumber[i] == 0) {
                    setNumber[i] = 2;
                    setCount[2]++;
                    for (int j = i + 1; j < N; j++) {
                        if (!graph.get(i).contains(j)) {
                            setNumber[j] = 2;
                            setCount[2]++;
                        }
                    }
                    break;
                }
            }
            for (int i = 1; i < N; i++) {
                if (setNumber[i] == 0) {
                    setNumber[i] = 3;
                    setCount[3]++;
                    for (int j = i + 1; j < N; j++) {
                        if (!graph.get(i).contains(j)) {
                            setNumber[j] = 3;
                            setCount[3]++;
                        }
                    }
                    break;
                }
            }
            for (int i = 0; i < N; i++) {
                if (setNumber[i] == 0) {
                    out.printLine(-1);
                    return;
                }
            }
            for (int i = 1; i <= 3; i++) {
                int count = 0;
                if (setCount[i] == 0) {
                    out.printLine(-1);
                    return;
                }
                for (int j = 0; j < N; j++) {
                    if (setNumber[j] == i) {
                        int degeee = graph.get(j).size();
                        if (degeee != N - setCount[i]) {
                            out.printLine(-1);
                            return;
                        }
                        if (!visited[j]) {
                            dfs(j, setNumber, i);
                            count++;
                        }
                    }
                }
                if (count != setCount[i]) {
                    out.printLine(-1);
                    return;
                }
            }
            for (int i = 0; i < N; i++) {
                out.print(setNumber[i] + " ");
            }
        }

        public void dfs(int index, int setNumber[], int i) {
            visited[index] = true;
            for (Integer v : graph.get(index)) {
                if (!visited[v] && setNumber[v] == i) {
                    dfs(v, setNumber, i);
                }
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

