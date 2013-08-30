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
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),i,a[]=new int[n];
        for(i=0;i<n;i++)
            a[i] = in.nextInt();
        out.printLine(DynamicProgramming.LongestIncreasingSubsequence(a));
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

class DynamicProgramming {
    public static int LongestIncreasingSubsequence(int a[])
    {
        int b[]=new int[a.length];
        int u,v,n=a.length;
        b[0]=0;
        int size=1;
        int p[]=new int[n];
        for(int i=1;i<n;i++)
        {
            // If next element a[i] is greater than last element of current longest subsequence
            if(a[b[size-1]]<=a[i])
            {
                p[i]=b[size-1];
                b[size++]=i;
                continue;
            }
            // Binary search to find the smallest element referenced by b which is just bigger than a[i]
            for(u=0,v=size-1;u<v;)
            {
                int c=(u+v)/2;
                if(a[b[c]]<a[i])
                    u=c+1;
                else v=c;
            }
            // Update b if new value is smaller then previously referenced value
            if(a[i]<a[b[u]])
            {
                if(u>0)
                    p[i]=b[u-1];
                b[u]=i;
            }
        }
        //for(u=size-1,v=b[size-1];u>=0;v=p[v],u--)
          //  b[u]=a[v];
        //b now contains the elements of the array uptil size
        return size;
    }

}

