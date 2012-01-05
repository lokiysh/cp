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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n,r,R;
        n=in.nextInt();
        R=in.nextInt();
        r=in.nextInt();
        if(R==r)
            if(n==1)
            {
                out.println("YES");
                return;
            }
            else {
                out.println("NO");
                return;
            }
        else if(r>R)
            out.println("NO");
        else if(2*r>R)
        {
            if(n==1)
            out.println("YES");
            else out.println("NO");
        }
        else if(2*r==R)
        {
            if(n<=2)
                out.println("YES");
            else out.println("NO");
        }
           /* else
            {
                float a=1-((float )(2*r*r)/((R-r)*(R-r)));

                if((Math.abs(a)<=1)&&(Math.acos(a)*n)<=(2*Math.PI)+1e-8)
                    out.println("YES");
                else out.println("NO");

	     }  */
        else {
            double a=r*Math.sin((Math.PI/2)*(1-(double)(2/n)));
            double b=(R-r)*(Math.sin(Math.PI/n));
            if(a<=(b+1e-8))
                out.println("YES");
            else out.println("NO");
        }
}   }

