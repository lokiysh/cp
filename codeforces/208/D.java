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
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt();
        int a[]=new int[n];
        int i;
        for(i=0;i<n;i++)
            a[i]=in.nextInt();
        int prize[]=new int[5];
        for(i=0;i<5;i++)
            prize[i]=in.nextInt();
        long c=0,tot=0;
        long num[]=new long[5];
        for(i=0;i<n;i++)
        {
            tot+=a[i];
            if(tot>=prize[0])
            {
                int j;
                for( j=4;j>=0;j--)
                {
                    if(prize[j]<=tot)
                    {
                        long k=tot/prize[j];
                        tot-=k*prize[j];
                        num[j]+=k;
                    }
                }
            }
        }
        for(i=0;i<4;i++)
            out.print(num[i]+" ");
        out.println(num[i]);
        out.println(tot);
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
    public int nextInt()
    {
        return Integer.parseInt(next());
    }
    }

