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
        int i,j,x=in.nextInt(),t=in.nextInt(),ca=in.nextInt(),cb=in.nextInt(),da=in.nextInt(),db=in.nextInt();
        boolean status=false;
        if(x==0)
        {
            status=true;
        }
        for(i=0;i<t;i++)
        {
            for(j=0;j<t;j++)
            {
                int points=(ca-da*i)+(cb-db*j);
                if(points==x)
                {
                    //System.out.println(i+" "+j);
                    status=true;
                }
                else if(x==(ca-da*i)||x==(cb-db*j))
                    status=true;
            }
        }
        if(status)
            out.println("YES");
        else out.println("NO");
	}
}

