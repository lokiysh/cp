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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    int X[],Y[],visited[];
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt();
        X=new int[n];
        Y=new int[n];
        visited=new int[n];
        int i;
        for(i=0;i<n;i++)
        {
            X[i]=in.nextInt();
            Y[i]=in.nextInt();
        }
        int min=0;
        for(int j=0;j<n;j++)
        {
            if(visited[j]==0)
            {
                dfs(j);
                min++;
            }


        }
        out.println(min-1);
	}
    public void dfs(int index)
    {
        visited[index]=1;

        int i;
        for(i=0;i<X.length;i++)
        {
            if(visited[i]==0&&(X[i]==X[index]||Y[i]==Y[index]))
            {
                dfs(i);
            }
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

