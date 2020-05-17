import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        BufferInput in = new BufferInput(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskD1 solver = new TaskD1();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD1 {
        public void solve(int testNumber, BufferInput in, OutputWriter out) {
            try {
                int N = in.nextInt(), q = in.nextInt();
                int limit = (int) 1e6 + 1;
                BinaryIndexTree bit = new BinaryIndexTree(limit);
                for (int i = 0; i < N; i++) {
                    int x = in.nextInt();
                    bit.updateBIT(x, 1);
                }
                for (int i = 0; i < q; i++) {
                    int k = in.nextInt();
                    if (k > 0) {
                        bit.updateBIT(k, 1);
                    } else {
                        k = -k;
                        int low = 0, high = limit, ans = 0;
                        while (low <= high) {
                            int mid = (low + high) / 2;
                            if (bit.getSum(mid) < k) {
                                low = mid + 1;
                            } else {
                                ans = mid;
                                high = mid - 1;
                            }
                        }
                        bit.updateBIT(ans, -1);
                    }
                }
                for (int i = 1; i < limit; i++) {
                    if (bit.getSum(i) > 0) {
                        out.printLine(i);
                        return;
                    }
                }
                out.printLine(0);
            } catch (IOException e) {

            }
        }

    }

    static class BufferInput {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;

        public BufferInput(InputStream in) {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public BufferInput(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
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

    static class BinaryIndexTree {
        int[] tree;
        int N;

        public BinaryIndexTree(int N) {
            tree = new int[N + 1];
            this.N = N;
        }

        int getSum(int index) {
            int sum = 0;
            for (; index > 0; index -= (index & (-index))) {
                sum += tree[index];
            }
            return sum;
        }

        void updateBIT(int index, int val) {
            for (; index <= N; index += index & (-index)) {
                tree[index] += val;
            }
        }

    }
}

