import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Lokesh Khandelwal
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    boolean visited[];
    int x[],y[],k;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),i;
        visited=new boolean[n];
        x=new int[n];
        y=new int[n];
        k=0;
        for(i=0;i<n;i++)
        {
            int p=in.nextInt(),a=in.nextInt(),b=in.nextInt();
            if(p==1)
            {
                x[k]=a;
                y[k]=b;
                k++;
            }
            else
            {
                Arrays.fill(visited,false);
                dfs(a - 1);
                if(visited[b-1])
                    out.printLine("YES");
                else out.printLine("NO");
                //out.printLine(visited[b-1]);
            }
        }
    }
    public void dfs(int a)
    {
        visited[a]=true;
        int i;
        for(i=0;i<k ;i++)
        {
            if(!visited[i]&&((x[i]<x[a]&&x[a]<y[i])||(x[i]<y[a]&&y[a]<y[i])))
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

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object...objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}
}

