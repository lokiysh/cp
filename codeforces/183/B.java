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
        int n=in.nextInt(),m=in.nextInt(),i,j,k,c=0;
        int best[]=new int[n+1];
        int x[]=new int[m];
        int y[]=new int[m];
        for(i=0;i<m;i++)
        {
            x[i]=in.nextInt();
            y[i]=in.nextInt();
        }
        for(i=0;i<m;i++)
        {
            for(j=i+1;j<m;j++)
            {
                long index;
                index=doesIntersect(x[i],x[j],y[i],y[j]);
                if(index<1||index>n)
                    continue;
                c=0;
                for(k=0;k<m;k++)
                    if(areOnLine(x[i],y[i],x[j],y[j],x[k],y[k]))
                        c++;

                best[(int)index]=Math.max(best[(int)index],c);
            }
        }
        int sum=0;
        for(i=1;i<=n;i++)
        {
            if(best[i]==0)
                sum++;
            else
            sum+=best[i];
        }
        out.println(sum);
	}
    public long doesIntersect(long x1,long x2,long y1,long y2)
    {
        if(y1==y2)
            return -1;
        long k=(y1*(x1-x2));
        long dy=y1-y2;
        if(k%dy==0)
        {
            return (x1-k/dy);
        }
        return -1;
    }
    public boolean areOnLine(long x1,long y1,long x2,long y2,long a,long b)
    {
        return ((y2-y1)*(a-x1)==(x2-x1)*(b-y1));
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

