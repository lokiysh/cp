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
		C solver = new C();
		solver.solve(1, in, out);
		out.close();
	}
}

class C {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s=in.next();
        int i,n=s.length();
        long k=in.nextInt();
        long MOD=(long)Math.pow(10,9)+7;
        long ans=0;
        long q=(IntegerUtils.bigMod(2,n,MOD)-1)%MOD;
        long t=IntegerUtils.extededGCD(MOD,q)[0];
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='0'||s.charAt(i)=='5')
            {
                long p=(IntegerUtils.bigMod(2,n*k,MOD)-1)%MOD;
                long r=IntegerUtils.bigMod(2,i,MOD);
                long z=(p*r)%MOD;
                z=(z*t)%MOD;
                ans=(ans+ z)%MOD;
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
    public static int[] extededGCD(long MOD,long a)
    {
        long x=0,y=1,lastx=1,lasty=0,m1=MOD;
        while (MOD!=0)
        {
            long q=a/MOD,r=a%MOD;
            long m=lastx-q*x,n=lasty-q*y;
            lastx=x;
            lasty=y;
            x=m;
            y=n;
            a=MOD;
            MOD=r;
        }
        while (lastx<0)
            lastx+=m1;
        return new int[]{(int)lastx,(int)lasty};
    }

}

