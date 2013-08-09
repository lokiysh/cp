import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import java.util.HashSet;
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
            a[i]=in.nextInt();
        int copy=a[n-1];
        int numBits=0;
        while (copy>0)
        {
            copy>>=1;
            numBits++;
        }
        int bits[][]=new int[n][numBits];
        int j;
        for(i=0;i<n;i++)
        {
            copy=a[i];
            j=0;
            while (copy>0)
            {
                bits[i][j]=copy&1;
                copy>>=1;

                j++;
            }
            //DebugUtils.print(bits[i]);
        }
        //DebugUtils.print(numBits);
        for(i=numBits-1;i>=0;i--)
        {
            HashSet<Integer> hash=new HashSet<Integer>(n);
            hash.clear();
            long allOne=(long)Math.pow(2,i+1)-1;
            //DebugUtils.print(allOne);
            for(j=0;j<n;j++)
            {
                if(bits[j][i]==1)
                {
                    hash.add(a[j]);
                    allOne&=a[j];
                }
            }
            //DebugUtils.print(allOne);
            if(allOne==(long)Math.pow(2,i))
            {
                out.printLine(hash.size());
                for(int k :hash)
                    out.print(k+" ");
                return;
            }
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

