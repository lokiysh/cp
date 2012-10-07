import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
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
    int a[],l,n,d;
    int min[],max[];
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        n=in.nextInt();
        d=in.nextInt();
        l=in.nextInt();
        int i;
        a=new int[n];
        min=new int[n];
        max=new int[n];
        min[n-1]=1;
        max[n-1]=l;
        for(i=n-2;i>=0;i--)
        {
            min[i]=1-max[i+1];
            max[i]=l-min[i+1];
        }
        
        Arrays.fill(a,-1);

        boolean test=dfs(0,d);
        if(!test)
        {
            out.println(-1);
            return;
        }
        for(i=0;i<n-1;i++)
        {
            out.print(a[i]+" ");
        }
        out.println(a[i]);
	}
    public boolean dfs(int index,int d)
    {
        int i,p=Math.abs(d);

        if(index==n-1)
        {
            if(d>=1&&d<=l)
            {
                a[index]=d;
                return true;
            }
            else return false;
        }
        boolean test=false;
        for(i=1;i<=l;i++)
        {
            int k=i-d;
            if(k>=min[index+1]&&k<=max[index+1])
            {
                test=dfs(index+1,i-d);
                 if(test)
                {
                    a[index]=i;
                    return true;
                }
            }

        }
        return test;
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

