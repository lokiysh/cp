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
        String s=in.next(),com="1000000";
        int  a,b,c,max=0,d;
        int i,j,n=s.length();
        boolean st=false;
        for(i=1;i<=n-2;i++)
        {
            for(j=i+1;j<=n-1;j++)
            {
                String x=s.substring(0,i);
                String y=s.substring(i,j);
                String z=s.substring(j,n);
                if(x.length()>7||y.length()>7||z.length()>7)
                    continue;
                if(x.length()==7&&!x.equals(com)||y.length()==7&&!y.equals(com)||z.length()==7&&!z.equals(com))
                    continue;
                //Debug.print(x+" "+y+" "+z);
                if(x.startsWith("0")&&x.length()>1||y.startsWith("0")&&y.length()>1||z.startsWith("0")&&z.length()>1)
                    continue;
                a=Integer.parseInt(x);
                b=Integer.parseInt(y);
                c=Integer.parseInt(z);
                d=a+b+c;
                if(d>=max)
                {
                    st=true;
                    max=d;
                }
            }
        }
        if(!st)
            out.println(-1);
        else
        out.println(max);
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

