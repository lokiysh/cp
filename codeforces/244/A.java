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
 * @author Lokesh Khandelwal aka (codeKNIGHT | phantom11)
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		Task solver = new Task();
		solver.solve(1, in, out);
		out.close();
	}
}

class Task {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),k=in.nextInt();
        int i;
        int a[]=new int[n*k+1];
        int b[][]=new int[k][n];
        int count[]=new int[k];
        for(i=1;i<=k;i++)
        {
            int p=in.nextInt();
            a[p]=i;
            b[i-1][count[i-1]]=p;
            count[i-1]++;
        }

        for(i=1;i<=k;i++)
        {
            int c=1;
            for(int j=1;j<=n*k&&c<n;j++)
            {
                if(a[j]==0)
                {
                    a[j]=i;
                    c++;
                    b[i-1][count[i-1]]=j;
                    count[i-1]++;
                }
            }
        }
        
        int j;
        for(i=0;i<k;i++)
        {
            for(j=0;j<n;j++)
                out.print(b[i][j]+" ");
            out.printLine();
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

