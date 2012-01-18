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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt(),i,c=0;
        int a[]=new int[n];
        int b[]=new int[n];
        int max=0,min=1000,pmin=0,pmax=0;
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            b[i]=a[i];
            if(a[i]>max)
            {max=a[i];pmax=i;}
            if(a[i]<=min)
            {min=a[i];pmin=i;}
        }
        Arrays.sort(a);
        c=pmax+n-pmin-1;
        if(pmax>pmin)
            c--;
        out.println(c);

	}
}

