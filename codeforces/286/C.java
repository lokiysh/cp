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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),i;
        int a[]=new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
        }
        boolean seq[]=new boolean[n];
        Arrays.fill(seq,true);
        int t=in.nextInt();
        boolean neg[]=new boolean[n];
        for(i=0;i<t;i++)
            neg[in.nextInt()-1]=true;
        int index=0;
        int stack[]=new int[n];
        for(i=n-1;i>=0;i--)
        {
            if(neg[i])
                stack[index++]=a[i];
            else
            {
                if(index>0&&stack[index-1]==a[i])
                {
                    seq[i]=false;
                    index--;
                }
                else stack[index++]=a[i];
            }
        }
        for(i=0;i<n;i++)
        {
            if(seq[i])
                a[i]*=-1;
        }
        if(index!=0)
        {
            out.printLine("NO");
        }
        else
        {
            out.printLine("YES");
            for(i=0;i<n-1;i++)
                out.print(a[i]+" ");
            out.printLine(a[i]);
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

