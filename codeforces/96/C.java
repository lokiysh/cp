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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
	    int n=in.nextInt(),i,j;
        String a[]=new String[n];

        for(i=0;i<n;i++)
            a[i]=in.next();
        String w=in.next();
        int b[]=new int[w.length()];
        int len;
        String rep=in.next(),s=w.toLowerCase();
        for(i=0;i<n;i++)
        {
            String t=a[i].toLowerCase();
            len=t.length();
            for(j=0;j<w.length()-len+1;j++)
            {
                if(s.substring(j,j+len).equals(t))
                for(int k=j;k<j+len;k++)
                    b[k]=1;
            }
        }
        String res="";
        
        for(i=0;i<b.length;i++)
            if(b[i]==1)
            {
                if(w.substring(i,i+1).equalsIgnoreCase(rep))
                {
                    if(w.charAt(i)>=65&&w.charAt(i)<91)
                    {
                        if(rep.equalsIgnoreCase("A"))
                            res+="B";
                        else
                            res+="A";
                    }
                    else
                    {
                        if(rep.equalsIgnoreCase("a"))
                            res+="b";
                        else
                            res+="a";
                    }
                }
                else if(w.charAt(i)>=65&&w.charAt(i)<91)
                    res+=rep.toUpperCase();
                else
                    res+=rep.toLowerCase();
            }
            else
                res+=w.charAt(i);
        out.println(res);


    }

}

