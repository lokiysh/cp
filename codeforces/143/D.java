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
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt();
        int m=in.nextInt();
        int i,ans,j;
        int max=Math.max(n,m);
        int min=Math.min(n,m);
        if(min==1)
            ans=max;
        else if(min==2)
        {
            i=max/4;
            if(max==4*i)
                ans=4*i;
            else if(max==4*i+1)
                ans=4*i+2;
            else
                ans=4*i+4;
        }
        else ans=(max*min+1)/2;

        out.println(ans);
	}
}

