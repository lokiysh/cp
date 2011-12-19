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
        int n=in.nextInt(),i;
        int a[]=new int[5000];
        for(i=0;i<n;i++)
            a[in.nextInt()-1]+=1;

        int c=0;
        for(i=0;i<n;i++)
            if(a[i]>1)
         c+=a[i]-1;
        for(i=n;i<5000;i++)
            c+=a[i];
        out.println(c);
	}
}

