import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.ArrayList;
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
    long MOD=(long)Math.pow(10,9)+7;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s=in.next();
        
        long ans= IntegerUtils.bigMod(2,s.length()-1,MOD);
        ans=(ans*toBinary(s))%MOD;
        out.printLine(ans);
    }
    public long toBinary(String s)
    {
        int len=s.length(),i;
        long p=0;
        int k=0;
        for(i=len-1;i>=0;i--)
        {
            if(s.charAt(i)=='1')
            {
                p=(p+IntegerUtils.bigMod(2,k,MOD))%MOD;
            }
            k++;
        }
        return p;
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

class IntegerUtils {

    public static long bigMod(long a,long b,long mod)
    {
        if(b==0)
            return 1;
        else if(b%2==0)
        {
            long x=bigMod(a,b/2,mod)%mod;
            return (x*x)%mod;
        }
        else  return ((a%mod)*bigMod(a,b-1,mod))%mod;
    }

}

