import java.util.List;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        int n=in.nextInt(),m=in.nextInt(),i,j;
        int a[]=new int[n+1],b[]=new int[m+1];
        for(i=0;i<=n;i++)
            a[i]=in.nextInt();
        for(i=0;i<=m;i++)
            b[i]=in.nextInt();
        if(n>m)
        {
            if((a[0]>=0&&b[0]>=0)||(a[0]<0&&b[0]<0))
                out.println("Infinity");
            else out.println("-Infinity");
        }

        else if(m>n)
                out.println("0/1");
        else
        {
            int gcd=(int) IntegerUtils.gcd(Math.abs(a[0]),Math.abs(b[0]));
            a[0]/=gcd;
            b[0]/=gcd;
            int k=0;
            if(a[0]<0)
                k++;
            if(b[0]<0)
                k++;
            if(k%2==0)
                out.println(Math.abs(a[0])+"/"+Math.abs(b[0]));
            else out.println("-"+Math.abs(a[0])+"/"+Math.abs(b[0]));
        }
    }
}

class IntegerUtils {
    public static long gcd(long a,long b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }

}

