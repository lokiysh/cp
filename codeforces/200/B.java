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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt();
        double a[]=new double[n];
        int i;
        double sum=0;
        for(i=0;i<n;i++)
        {
            sum+=in.nextDouble()/100.0;
        }
        out.println((sum*100)/n);

	}
}

