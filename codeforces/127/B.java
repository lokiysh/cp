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
        int i;
        int n=in.nextInt();
        int a[]=new int[n],c=0,count[]=new int[100];
        for(i=0;i<n;i++)
            a[i]=in.nextInt();
        for(i=0;i<n;i++)
            count[a[i]-1]+=1;
        for(i=0;i<100;i++)
            c+=count[i]/2;
        out.println(c/2);
	}
}

