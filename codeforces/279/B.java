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
        int n=in.nextInt(),t=in.nextInt(),i;
        int a[]=new int[n];
        long cum[]=new long[n+1];
        cum[0]=0;
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            cum[i+1]=cum[i]+a[i];
        }
        int ans=0;
       // DebugUtils.print(cum);
        for(i=1;i<=n;i++)
        {
            int low=i,high=n;
            long key=cum[i-1]+t;
            int index=-1;
            while (low<=high)
            {
                int mid=(low+high)/2;
                if(cum[mid]==key)
                {
                    index=mid;
                    break;
                }
                else if(cum[mid]<key)
                {
                    index=Math.max(index,mid);
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            if(index!=-1)
            {
                ans=Math.max(ans,index-i+1);
            }
        }
        out.printLine(ans);

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

