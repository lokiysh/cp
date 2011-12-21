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
	public void solve(int testNumber, Scanner in, PrintWriter out){
        //BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        in.useDelimiter("\n");
        String s=in.next();
        int i,c=0;
        char ch;
        //System.out.println(s);
        for(i=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                c++;
        }
        if(c!=5)
        {
             out.println("NO");
            return;
        }
        c=0;
        s=in.next();
        for(i=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                c++;
        }
        if(c!=7)
        {
            out.println("NO");
            return ;
        }
        c=0;
        s=in.next();
        for(i=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                c++;
        }
        if(c!=5)
        {
            out.println("NO");
            return;
        }

        out.println("YES");
	}

}

