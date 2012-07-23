import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s1=in.next();
        //StringBuffer s1=new StringBuffer(s);
        while (s1.startsWith("WUB"))
            s1=s1.substring(3);
        while (s1.endsWith("WUB"))
            s1=s1.substring(0,s1.length()-3);
        String ans=s1.replaceAll("WUB"," ");
        String a[]=ans.split(" ");
        String s="";
        for(int i=0;i<a.length;i++)
            if(a[i].length()>0)
                s+=a[i]+" ";
        s=s.trim();
        out.println(s);
	}
}

class InputReader
{
    BufferedReader in;
    StringTokenizer tokenizer=null;

    public InputReader(InputStream inputStream)
    {
        in=new BufferedReader(new InputStreamReader(inputStream));
    }
    public String next()
    {
        try{
            while (tokenizer==null||!tokenizer.hasMoreTokens())
            {
                tokenizer=new StringTokenizer(in.readLine());
            }
            return tokenizer.nextToken();
        }
        catch (IOException e)
        {
            return null;
        }
    }
    }

