import java.util.Scanner;
import java.io.PrintStream;
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
		Task solver = new Task();
		solver.solve(1, in, out);
		out.close();
	}
}

class Task {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
	String s=in.next();
	String hello="hello";
	int j=0;
	for(int i=0;i<s.length();i++)
	{
        if(j==5)
            break;
		if(s.charAt(i)==hello.charAt(j))
		j++;
	}
	if(j==5)
	out.println("YES");
	else System.out.println("NO");
    }



}

