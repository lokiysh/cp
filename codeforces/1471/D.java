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
import java.util.Hashtable;
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
            List<Integer> primes[] = seiveOfEratosthenes();
            int T = in.nextInt();
            while (T-- > 0) {
                int N = in.nextInt();
                int a[] = new int[N];
                Hashtable<Long, Integer> table = new Hashtable<>();
                for (int i = 0; i < N; i++) {
                    a[i] = in.nextInt();
                    long left = 1;
                    for (int key : primes[a[i]]) {
                        int times = 0;
                        while (a[i] % key == 0 && a[i] > 1) {
                            a[i] /= key;
                            times++;
                        }
                        if (times % 2 == 1) {
                            left *= key;
                        }
                    }
                    table.put(left, table.getOrDefault(left, 0) + 1);
                }
                int perfect = 0;
                if (table.containsKey(1L)) {
                    perfect = table.get(1L);
                }
                int max = 0, even = 0;
                for (long key : table.keySet()) {
                    int size = table.get(key);
                    max = Math.max(max, size);
                    if (size % 2 == 0 && key > 1) {
                        even += size;
                    }
                }
                int afterOne = Math.max(max, perfect + even);
                int q = in.nextInt();
                while (q-- > 0) {
                    long w = in.nextLong();
                    if (w == 0) {
                        out.printLine(max);
                    } else {
                        out.printLine(afterOne);
                    }
                }
            }
        }

        public List[] seiveOfEratosthenes() {
            int N = (int) 1e6 + 1;
            List<Integer>[] list = new List[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }
            list[1].add(1);
            for (int i = 2; i < N; i++) {
                if (list[i].size() == 0) {
                    for (int j = 2 * i; j < N; j += i) {
                        list[j].add(i);
                    }
                    list[i].add(i);
                }
            }
            return list;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

