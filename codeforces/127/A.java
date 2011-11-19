import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author codeKNIGHT
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt()  ;
        int k=in.nextInt()  ;
        int i,x[]=new int[n],y[]=new int[n];
        double d=0;
        for(i=0;i<n;i++)
        {
            x[i]=in.nextInt();
            y[i]=in.nextInt()  ;

        }
        for(i=0;i<n-1;i++)
        {
            d+=Math.sqrt(Math.pow((x[i]-x[i+1]),2)+Math.pow((y[i]-y[i+1]),2));
        }
        out.println((d*k)/50);
	}
}

