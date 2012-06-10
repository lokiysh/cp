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
        int n=in.nextInt(),m=in.nextInt(),i,j;
        i=(m+1)/2;
        int startj=j=Math.min((m+1)/2+1,m);
        int a[]=new int[m],cou=0,k=0;
        if(m%2==1)
        {
            out.println((m+1)/2);
            a[cou++]=i;
            i--;
            n--;
        }

        for(int c=1;c<=n;c++)
        {
            if(cou==m)
                break;
            if(i<=0)
                i=(m+1)/2;
            if(j>m)
                j=startj;
            if(c%2==1)
            {
                out.println(i);
                a[cou++]=i;
                i--;
            }
            else
            {
                out.println(j);
                a[cou++]=j;
                j++;
            }
            k++;
            //System.out.println(i+" "+j);
        }
        cou=0;
        for(i=k+1;i<=n;i++)
        {
            if(cou==m)
                cou=0;
            out.println(a[cou++]);
        }
	}
}

