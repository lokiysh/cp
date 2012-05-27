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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt(),i,a[]=new int[n],b[]=new int[n];
        for(i=0;i<n;i++)
        a[i]=in.nextInt();
        int min=Math.min(a[0],a[a.length-1]);
        if(n<=3)
            out.println(min);
        else 
        {
            b[0]=a[0];
            b[1]=Math.min(a[0],a[1]);
            for(i=2;i<n;i++)
            {
                b[i]=Math.max(b[i-1],b[i-2]);
                b[i]=Math.min(b[i],a[i]);
            }
            out.println(b[n-1]);
        }
        
	}
}

