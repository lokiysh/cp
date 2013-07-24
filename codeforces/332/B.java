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
        int n=in.nextInt(),k=in.nextInt(),i,a[]=new int[n];
        long cum[]=new long[n];
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            if(i==0)
                cum[0]=a[0];
            else cum[i]=cum[i-1]+a[i];
        }
        long first= 0,second = 0;
        int fIndex=-1,sIndex=-1;
        long arrays[]=new long[n];
        for(i=k-1;i<n;i++)
        {
            long score=0;
            if(i==k-1)
                score=cum[i];
            else score =cum[i]-cum[i-k];
            arrays[i-k+1] = score;

        }
        long max[]=new long[n];
        int index[]=new int[n];
        long l_Max=0;
        int l_index=-1;
        for(i=n-k;i>=0;i--)
        {
            if(arrays[i]>=l_Max)
            {
                max[i] = arrays[i];
                index[i]=i;
                l_Max=arrays[i];
                l_index=i;
            }
            else
            {
                max[i]=l_Max;
                index[i]=l_index;
            }
        }
        l_Max=0;
        int j;
        //DebugUtils.print(max,index);
        for(i=0;i<n-k;i++)
        {
            long value = arrays[i] + max[i+k];
            if(value>l_Max)
            {
                first=i+1;
                second=index[i+k]+1;
                l_Max=value;
            }
        }
        out.printLine(first+" "+second);
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

