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
        int n=in.nextInt();
        int i;
        int a[]=new int[n];
        long count[]=new long[21];
        for(i=0;i<=20;i++)
            count[i]=0;
        for(i=0;i<n;i++)
        {
            int k=in.nextInt();
            count[k+10]+=1;
        }

        long c=0;
        int min;
        for(i=0;i<10;i++)
        {

               c+=count[i]*count[20-i];
        }
        c+=(count[10]*(count[10]-1))/2;
        out.println(c);
	}
}

