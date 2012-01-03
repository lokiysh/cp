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
        String s;
        int i;
        in.useDelimiter("\n");
        String res="";
        s=in.next();
        for(i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==' ')
            {
                res=res.trim();
                res+=ch;
            }
            else if(ch>=97&&ch<=122)
                res+=ch;
            else
            {
                res=res.trim();
                res+=ch+" ";
            }
        }
        res=res.trim();
        out.println(res);
	}
}

