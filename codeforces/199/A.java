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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt();
        int fib[]=new int[100];
        int i;
        fib[0]=0;
        fib[1]=1;
        int c=1,k=3;
        fib[2]=1;
        while(c<=1000000000)
        {
            c=fib[k-1]+fib[k-2];
            fib[k++]=c;
        }

        //System.out.println(k+" "+fib[k-1]);

            boolean status=false;
        for(i=0;i<k;i++)
        {
            if(status)
                break;
            for(int j=0;j<k;j++)
            {
                if(status)
                    break;
                for(int l=0;l<k;l++)
                {
                    if(fib[i]+fib[j]+fib[l]==n)
                    {
                        status=true;
                        out.println(fib[i]+" "+fib[j]+" "+fib[l]);
                        break;
                    }
                }
            }
        }
        if(!status)
        {
            //System.out.println(t);
            out.println("I'm too stupid to solve this problem");
        }

	}
}

