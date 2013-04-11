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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),m=in.nextInt(),k=in.nextInt();
        long a[]=new long[n];
        int i;
        long start[]=new long[m],end[]=new long[m];
        for(i=0;i<n;i++)
            a[i]=in.nextInt();
        int operations[][]=new int[m][3];
        for(i=0;i<m;i++)
        {
            operations[i][0]=in.nextInt()-1;
            operations[i][1]=in.nextInt()-1;
            operations[i][2]=in.nextInt();
        }
        long t=0;
        long times[]=new long[m];
        for(i=0;i<k;i++)
        {
            int x=in.nextInt()-1,y=in.nextInt()-1;
            start[x]++;
            end[y]++;
        }
        //DebugUtils.print(start,end);
        for(i=0;i<m;i++)
        {
            t+=start[i];
            times[i]=t;
            t-=end[i];
        }
        long s[]=new long[n],e[]=new long[n];
        for(i=0;i<m;i++)
        {
            s[operations[i][0]]+=times[i]*operations[i][2];
            e[operations[i][1]]+=times[i]*operations[i][2];
        }
        t=0;
        for(i=0;i<n;i++)
        {
            t+=s[i];
            a[i]+=t;
            t-=e[i];
        }
        for(i=0;i<n-1;i++)
            out.print(a[i]+" ");
        out.printLine(a[i]);
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

