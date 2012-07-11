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
        int min=Integer.MAX_VALUE;
        int i,index=0;
        boolean status=false;
        for(i=0;i<n;i++)
        {
            int k=in.nextInt();
            if(k<min)
            {
                min=k;
                index=i+1;
                status=false;
            }
            else if(min==k)
            {
                status=true;
            }
        }
        if(status)
            out.println("Still Rozdil");
        else out.println(index);
	}
}

