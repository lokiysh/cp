import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Lokesh Khandelwal aka (codeKNIGHT | phantom11)
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {

	public void solve(int testNumber, Scanner in, PrintWriter out) {
        long a=in.nextLong(),b=in.nextLong();
        out.println(count(b)-count(a-1));
    }
    public long count(long n)
    {
        if(n<10)
            return n;
        String s=Long.toString(n);
        return (n / 10 - 1) + (s.charAt(0) <= s.charAt(s.length() - 1) ? 1 : 0) + 9;
    }
}

