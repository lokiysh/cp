import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
    long x[][],y[][],a[];
    int n;
    int start;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();
        int i,j;
        this.n=n;
        x=new long[n+1][2];
        y=new long[n+1][2];
        a=new long[n+1];

        for(i=2;i<=n;i++)
            a[i]=in.nextInt();

        for(i=1;i<=n-1;i++)
        {
            a[1]=i;
            start=i;
            x[1][0]=0;
            long ans=dfs(1,0);
            out.printLine(ans);
        }
    }
    public long dfs(int index,int para)
    {
        if(index<1||index>n) return 0;
        if(x[index][para]==start||x[index][para]==-1) return -1;
        if(x[index][para]!=0) return y[index][para];
        long val;
        x[index][para]=start;
        if(para==1)
        {
            val=dfs(index-(int)a[index],0);
        }
        else val=dfs(index+(int)a[index],1);
        if(val==-1) return x[index][para]=-1;
        return y[index][para]=val+a[index];
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

