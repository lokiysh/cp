import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Lokesh Khandelwal aka (codeKNIGHT | phantom11)
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		C solver = new C();
		solver.solve(1, in, out);
		out.close();
	}
}

class C {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n=in.nextInt(),m=in.nextInt();
        out.println((IntegerUtils.bigMod(3,n,m)-1+m)%m);
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

