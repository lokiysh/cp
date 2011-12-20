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
        String s=in.next();
        int i,c=1;
        char ch=s.charAt(0);
        boolean status=false;
        for(i=1;i<s.length();i++)
        {
            if(s.charAt(i)==ch)
                c++;
            else
            {
                c=1;
                ch=s.charAt(i);
            }
            if(c==7)
            {
                status=true;
                break;
            }
        }
        if(status)
            out.println("YES");
        else
            out.println("NO");
	}
}

