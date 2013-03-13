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
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();
        int i,a[]=new int[n],b[]=new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            b[i]=in.nextInt();
        }
        StringBuilder s=new StringBuilder("");
        int sa=0,sb=0;
        for(i=0;i<n;i++)
        {
            if(sa-sb+a[i]<=500)
            {
                s.append("A");
                sa+=a[i];
            }
            else
            {
                s.append("G");
                sb+=b[i];
            }
        }
        if(Math.abs(sa-sb)<=500)
        {
            out.printLine(s);
            return;
        }
        s=new StringBuilder("");
        sa=0;
        sb=0;
        for(i=0;i<n;i++)
        {
            if(sb-sa+b[i]<=500)
            {
                s.append("G");
                sb+=b[i];
            }
            else
            {
                s.append("A");
                sa+=a[i];
            }
        }
        if(Math.abs(sa-sb)<=500)
        {
            out.printLine(s);
            return;
        }
        out.printLine(-1);
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

