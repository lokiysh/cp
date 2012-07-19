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
        int n=in.nextInt(),m=in.nextInt(),r=in.nextInt();
        int i,j,k,l;
        int graph[][][]=new int[m][n][n];
        for(i=0;i<m;i++)
            for(j=0;j<n;j++)
                for(k=0;k<n;k++)
                    graph[i][j][k]=in.nextInt();
        int dp[][][]=new int[n][n][n];

        for(l=0;l<m;l++)
            for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                    for(k=0;k<n;k++)
                        graph[l][j][k]=Math.min(graph[l][j][k],graph[l][j][i]+graph[l][i][k]);
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                int cur=Integer.MAX_VALUE;
                for(k=0;k<m;k++)
                    cur=Math.min(cur,graph[k][i][j]);
                dp[0][i][j]=cur;
            }

        }
        for(i=1;i<n;i++)
            for(j=0;j<n;j++)
                for(k=0;k<n;k++)
                {
                    int cur=Integer.MAX_VALUE;
                    for(l=0;l<n;l++)
                        cur=Math.min(cur,dp[i-1][l][k]+dp[0][j][l]);
                    dp[i][j][k]=cur;
                }
        for(i=0;i<r;i++)
        {
            int s=in.nextInt()-1,f=in.nextInt()-1;
            k=Math.min(in.nextInt(),n-1);
            out.println(dp[k][s][f]);
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

