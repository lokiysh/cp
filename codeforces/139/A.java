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
        int n=in.nextInt();
        int i;
        int a[]=new int[7];
        for(i=0;i<7;i++)
        {
            a[i]=in.nextInt();

        }
        i=0;
        while(n>0)
        {
            if(i==7)
                i=0;
            n-=a[i];
            i++;
        }
        out.println(i);
	}
}

