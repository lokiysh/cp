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
        int i,a[]=new int[n];
        for(i=0;i<n;i++)
            a[i]=in.nextInt();
       long min=a[0],last=a[0],comp=a[0],max=a[0];
        long c=0;
        i=1;
        while (i<n)
        {
            boolean status=false;
            if(a[i]>=last)
            {
                last=a[i];
                comp=a[i];
                i++;
               continue;
            }
            min=Integer.MAX_VALUE;
            while (i<n&&a[i]<last)
            {
                if(a[i]<min)
                    min=a[i];
                last=a[i];
                i++;
                status=true;
            }
            if(status)
            c+=comp-min;
            if(i<n)
            {
                comp=a[i];
                last=a[i];

            }
            i++;
        }
        out.println(c);
	}
}

