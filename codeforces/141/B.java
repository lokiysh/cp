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
        double a,x,y;
        a=in.nextDouble();
        x=in.nextDouble();
        y=in.nextDouble();
        int k=0;
        boolean status;
        if(y==a||y==0)
            status=false;
        else if(y<a)
        {
            if(Math.abs(x)<a/2)
            {
                status=true;
                k=1;
            }
            else status=false;
        }
        else
        {
            if(y%a==0)
                status=false;
            else
            {
                int d=(int)(y/a);
                if(d%2==1)
                {
                    if(Math.abs(x)<a/2)
                    {
                        status=true;
                        k=d+(d+1)/2;
                    }
                    else status=false;
                }
                else
                {
                    if(x>0&&x<a)
                    {
                        status=true;
                        d/=2;
                        k=4*d-(d-1);
                    }
                    else if(x<0&&x>-a)
                    {
                        status=true;
                        d/=2;
                        k=3*d;
                    }
                    else status=false;
                }
            }
        }
        if(status)
            out.println(k);
        else out.println(-1);
	}
}

