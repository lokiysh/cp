import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    int n,m;
    boolean a[][],visited[];
    List<Integer> knows[];
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n=in.nextInt();
        m=in.nextInt();
        knows=new List[m];
        int sum=0;
        int i;
        for(i=0;i<m;i++)
            knows[i]=new ArrayList<Integer>(n);
        a=new boolean[n][m];
        visited=new boolean[n];

        for(i=0;i<n;i++)
        {
            int k=in.nextInt();
            sum+=k;
            for(int j=0;j<k;j++)
            {
                int p=in.nextInt()-1;
                a[i][p]=true;
                knows[p].add(i);
            }
        }

        int c=0;
        for(i=0;i<n;i++)
        {
            if(visited[i])  continue;
            c++;
            dfs(i);

        }
        if(sum!=0)
            c--;
        out.printLine(c);
    }
    public void dfs(int index)
    {
        visited[index]=true;

        for(int i=0;i<m;i++)
        {
            if(a[index][i])
            {
                for(int p : knows[i])
                {
                    if(!visited[p])
                        dfs(p);
                }
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

