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
    long b[];
    boolean stat;
    boolean x[];
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int i,j;
        long s=in.nextInt();
        int k=in.nextInt();
        long sum=0;
        long a[]=new long[50];
        a[0]=a[1]=1;
        int n=2;
        while (sum<s)
        {
            sum=0;
            for(i=Math.max(0,n-k);i<n;i++)
                sum+=a[i];
            a[n++]=sum;
        }
        b=new long[n-1];
        x=new boolean[n-1];
        for(i=1;i<n;i++)
            b[i-1]=a[i];
        for(i=0;i<n-1;i++)
            if(b[i]==s)
            {
                out.println(2);
                out.println("0 "+s);
                return;
            }
        stat=false;
        subsetSum(b.length-1,s,new boolean[n-1]);
        int m=0;
        for(i=0;i<n-1;i++)
            if(x[i])
                m++;
        out.println(m);
            for(i=0;i<n-1;i++)
            if(x[i])
                out.print(b[i]+" ");
	}
    public void subsetSum(int i,long s,boolean a[])
    {
        if(s==0)
        {
            stat=true;
            System.arraycopy(a,0,x,0,a.length);
        }
        else if(i>=0&&s>0&&!stat)
        {
            a[i]=true;
            subsetSum(i-1,s-b[i],a);
            a[i]=false;
            subsetSum(i-1,s,a);
        }
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

