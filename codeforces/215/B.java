import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt(),i,m,k,a[]=new int[n],p=0;
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            if(a[i]>p)
                p=a[i];
        }
        m=in.nextInt();
        int b[]=new int[m];
        for(i=0;i<m;i++)
            b[i]=in.nextInt();
        k=in.nextInt();
        int c[]=new int[k];
        for(i=0;i<k;i++)
            c[i]=in.nextInt();
        int A=in.nextInt(),B=in.nextInt();
        int j;double max=Integer.MIN_VALUE;
        double val;
        for(i=0;i<m;i++)
        {
            for(j=0;j<k;j++)
            {
                double x=(double )(B*b[i])/(A*c[j]+B*b[i]);
                x=Math.sqrt(x);
                if(x>max)
                    max=x;
            }
        }
        out.println(max*p);
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

