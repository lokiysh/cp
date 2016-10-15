import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.text.DecimalFormat;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String s = in.next();
            int i, n = s.length();
            double total = 0;
            for (i = 0; i < n; i++) {
                if (Character.isAlphabetic(s.charAt(i))) continue;
                StringBuilder str = new StringBuilder("");
                int j = i;
                for (j = i; j < n; j++) {
                    if (Character.isAlphabetic(s.charAt(j))) break;
                    str.append(s.charAt(j));
                }
                if (str.length() > 0) {
                    i = j;
                    total += parseMoney(str.toString());
                }
            }
            String ans = "";
            int integer = (int) total;
            //DebugUtils.debug(total);
            StringBuilder integerString = new StringBuilder(Integer.toString(integer));
            integerString.reverse();
            int length = integerString.length();
            StringBuilder ans1 = new StringBuilder("");
            //DebugUtils.debug(integerString);
            for (i = 0; i < length; i += 3) {

                ans1.append(integerString.substring(i, Math.min(length, i + 3)));
                ans1.append(".");
            }
            ans1 = ans1.reverse();
            // DebugUtils.debug(ans1);
            int start = 0;
            //int end = ans1.length() - 1;
            while (ans1.charAt(start) == '.') {
                start++;
            }
            ans = ans1.substring(start);
            int end = ans.length() - 1;
            while (ans.charAt(end) == '.') {
                end--;
            }
            //DebugUtils.debug(ans);
            ans = ans.substring(0, end + 1);
            if (total % 1 != 0) {
                DecimalFormat nf = new DecimalFormat(".00");
                String totalString = nf.format(total);
                //DebugUtils.debug(totalString);
                StringTokenizer k = new StringTokenizer(totalString, ".");
                String toCents = "";
                while (k.hasMoreTokens()) {
                    toCents = k.nextToken();
                }


                //toCents = nf.format(Double.parseDouble(toCents));
                ans += "." + toCents;
            }
            out.printLine(ans);
        }

        public double parseMoney(String s) {
            double amount = 0;
            StringTokenizer str = new StringTokenizer(s, ".");
            String tokens[] = new String[10];
            int p = 0;
            while (str.hasMoreTokens()) {
                String x = str.nextToken();
                if (x.length() > 3 || x.length() == 0) return 0;
                tokens[p++] = x;
            }
            if (p == 1) {
                return Double.parseDouble(tokens[0]);
            }
            if (tokens[p - 1].length() < 3) {
                if (tokens[p - 1].length() != 2) return 0;

                String q = "";
                for (int i = 0; i < p - 1; i++) {
                    q += tokens[i];
                }
                if (q.startsWith("0") && !q.equals("0")) return 0;
                q += "." + tokens[p - 1];
                //DebugUtils.debug(q);

                return Double.parseDouble(q);
            } else {
                String q = "";
                for (int i = 0; i < p; i++) {
                    q += tokens[i];
                }
                if (q.startsWith("0") && !q.equals("0")) return 0;
                return Double.parseDouble(q);
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
}

