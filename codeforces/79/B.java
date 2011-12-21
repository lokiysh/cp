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
        int n,m,k,t,i,x,y;
        n=in.nextInt();
        m=in.nextInt();
        k=in.nextInt();
        t=in.nextInt();
        int a[]=new int[k];
        for(i=0;i<k;i++)
        {
            x=in.nextInt()-1;
            y=in.nextInt()-1;
            a[i]=x*m+y;
        }
        int waste=0;
        boolean st;
        for(i=0;i<t;i++)
        {
            x=in.nextInt()-1;
            y=in.nextInt()-1;
            int z=x*m+y;
            waste=0;
            st=true;
            for(int j=0;j<k;j++)
            {
                if(a[j]==z)
                {
                    st=false;
                    out.println("Waste");
                    break;
                }
                else if(a[j]<z)
                    waste++;

            }
            z-=waste;
            if(st)
            {
                if(z%3==0)
                    out.println("Carrots");
                else if(z%3==1)
                    out.println("Kiwis");
                else
                    out.println("Grapes");
            }
        }

	}
}

