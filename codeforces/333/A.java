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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long a[]=new long[50];
        int i,k=0;
        long limit = (long)Math.pow(10,17);
        a[0]=1;
        while (a[k]<limit)
        {
            k++;
            a[k]=a[k-1]*3;
        }
        k++;
        a[k]=a[k-1]*3;
        long n=in.nextLong();
//        for(i=0;i<=k;i++)
//        {
//            if(a[i]>n)
//                break;
//        }
//        i--;
//        if(n%a[i]==0)
//        {
//            out.printLine(1);
//            return;
//        }
//        out.printLine(n/a[i]+1);
        i=0;
        while (n%a[i]==0)
        {
            i++;
        }
        if(n>a[i])
        {
            out.printLine(n/a[i]+1);
            return;
        }
        if(n%a[i-1]==0)
        {
            out.printLine(1);
            return;
        }
        out.printLine(n/a[i-1]+1);
        

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
    public long nextLong()
    {
        return Long.parseLong(next());
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

