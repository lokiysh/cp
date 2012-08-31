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
        int n=in.nextInt(),i,m=in.nextInt();
        int a[]=new int[n];
        int count[]=new int[n+1];
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            if(a[i]<=n)
            count[a[i]]++;
        }
        int b[][]=new int[m][2];
        for(i=0;i<m;i++)
        {
            b[i][0]=in.nextInt();
            b[i][1]=in.nextInt();
        }
        int ans[]=new int[m];
        for(i=1;i<=n;i++)
        {
            if(count[i]>=i)
            {
                int array[]=new int[n+1],j;
                array[0]=0;
                for(j=1;j<=n;j++)
                    if(a[j-1]==i)
                        array[j]=array[j-1]+1;
                    else array[j]=array[j-1];
                for(j=0;j<m;j++)
                    if(array[b[j][1]]-array[b[j][0]-1]==(i))
                        ans[j]++;
            }
        }
        for(i=0;i<m;i++)
            out.println(ans[i]);
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

