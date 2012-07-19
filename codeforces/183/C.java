import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    ArrayList<Integer> from[],to[];
    int ans=0,color[];
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt(),m=in.nextInt();
        int i;
        from=new ArrayList[n];
        to=new ArrayList[n];
        for(i=0;i<n;i++)
        {
            from[i]=new ArrayList<Integer>();
            to[i]=new ArrayList<Integer>();
        }
        for(i=0;i<m;i++)
        {
            int v1=in.nextInt()-1,v2=in.nextInt()-1;
            from[v2].add(v1);
            to[v1].add(v2);
        }
        color=new int[n];
        Arrays.fill(color,Integer.MAX_VALUE);
        for(i=0;i<n;i++)
        {
            if(color[i]==Integer.MAX_VALUE)
            {
                dfs(i,0);
            }
        }
        out.println(ans==0?n : ans);
	}
    public void dfs(int v,int c)
    {
        color[v]=c;
        for(int vert : to[v])
        {
            if(color[vert]==Integer.MAX_VALUE)
                dfs(vert,c+1);
            else
                ans= IntegerUtils.gcd(ans,Math.abs(color[vert]-(c+1)));
        }
        for(int vert : from[v])
        {
            if(color[vert]==Integer.MAX_VALUE)
                dfs(vert,c-1);
            else
                ans= IntegerUtils.gcd(ans,Math.abs(color[vert]-(c-1)));
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

class IntegerUtils {
    public static int gcd(int a,int b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }

}

