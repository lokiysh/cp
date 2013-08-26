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
        int n=in.nextInt(),m=in.nextInt(),i,j,k;
        int total = (1<<(n+1))-1;
        int a[]=new int[total];
        for(i=total-(1<<n);i<total;i++)
            a[i]=in.nextInt();
        k=0;
        for(i=n-1;i>=0;i--)
        {
            int limit= (1<<(i+1))-1;
            for(j=(1<<i)-1;j<limit;j++)
            {
                if(k%2==0)
                {
                    a[j] = a[2*j+1] | a[2*j+2];
                }
                else
                {
                    a[j] = a[2*j+1] ^ a[2*j +2];
                }
            }
            k++;
        }
        //DebugUtils.print(a);
        for(i=0;i<m;i++)
        {
            int p = in.nextInt()-1 + (1<<n)-1,b=in.nextInt();
            int parent = (p-1)/2;
            int x=b;
            k=0;
            a[p]=x;
            boolean status=false;
            while (parent>=0&&!status)
            {
                //DebugUtils.print(p,parent,x);
                if(parent==0)
                    status=true;
                if(p == 2*parent+1)
                {
                    if(k%2==0)
                    {
                        x  = x |a[2*parent+2];
                    }
                    else
                    {
                        x^=a[2*parent+2];
                    }
                }
                else
                {
                    if(k%2==0)
                    {
                        x  = x |a[2*parent+1];
                    }
                    else
                    {
                        x^=a[2*parent+1];
                    }
                }
                k++;
                p=parent;
                a[p]=x;
                parent=(p-1)/2;
            }
            out.printLine(a[0]);
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

