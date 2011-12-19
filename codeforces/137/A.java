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
        int c=0,t=0;
        char ch='A';


        for(int i=0;i<s.length();i++)
        {
           if(s.charAt(i)==ch)
               t++;
           else
           {
               ch=s.charAt(i);
               t=1;
               c++;
           }
           if(t==5)
           {  t=0;
               
               ch='A';
           }

        }
        out.println(c);


	}
}

