import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt(),i;
        int a[]=new int[n];
        boolean allone=true;
        for(i=0;i<n;i++)     {
            a[i]=in.nextInt();
            if(a[i]!=1)
                allone= false;  }
        Arrays.sort(a);
        for(i=n-1;i>=1;i--)
            a[i]=a[i-1];
        a[0]=1;
        for(i=0;i<n-1;i++)
            out.print(a[i]+" ");
            if(allone)
                out.println("2");
            else
        out.println(a[n-1]);
	}
}

