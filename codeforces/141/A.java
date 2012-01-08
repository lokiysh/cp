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
        String a=in.next();
        String b=in.next();
        String c=in.next();
        int i,j;
        char ar[]=c.toCharArray();
        boolean status=true,st1;
        for(i = 0;i<a.length();i++)
        {
            char ch=a.charAt(i);
            st1=true;
            for(j=0;j<ar.length;j++)
                if(ar[j]==ch)
                {
                    ar[j]='0';
                    st1=true;
                    break;
                }
            else st1=false;
            if(st1==false)
                status=false;
        }
        for(i=0;i<b.length();i++)
        {
            char ch=b.charAt(i);
            st1=true;
            for(j=0;j<ar.length;j++)
                if(ar[j]==ch)
                {
                    ar[j]='0';
                    st1=true;
                    break;
                }
            else st1=false;
            if(st1==false)
                status=false;
        }
        for(i=0;i<ar.length;i++)
            if(ar[i]!='0')
                status=false;
        if(!status)
            out.println("NO");
        else out.println("YES");
	}
}

