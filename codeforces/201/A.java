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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, Scanner in, PrintWriter out) {

        int x=in.nextInt(),i;
         //for(int x=1;x<=20;x++){
        if(x==3)
            i=5;
        else 
        for(i=1;;i+=2)
        {
            int j=(i*i+1)/2;
            if(j>=x)
                break;
        }

        out.println(i);

	}
}

