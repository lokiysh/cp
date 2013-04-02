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
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    boolean visited[];
    int k;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),k=in.nextInt();
        int i;
        this.k=k;
        visited=new boolean[k];
        long c=1;
        if(k==1) c=1;
        else if(k==2) c=2;
        else if(k==3) c=9;
        else if(k==4) c=64;
        else if(k==5) c=625;
        else if(k==6)
            c=7776;
        else if(k==7) c=117649;
        else c=2097152;
        /*
        for(i=(int)Math.pow(k,k)-1;i>0;i--)
        {
            s=Integer.toString(i,k);
            Arrays.fill(visited,false);

            while (s.length()<k) s="0"+s;
            for(int j=0;j<k;j++)
            {
                if(s.charAt(j)=='0')
                    dfs(j);
            }
            boolean status=true;
            for(int j=0;j<k;j++)
            {
                if(!visited[j])
                {
                    status=false;
                    break;
                }
            }
            //if(!status) DebugUtils.print(s);
            if(status)
                c++;
        }       */
        long mod=(long)Math.pow(10,9)+7;
        long p= IntegerUtils.bigMod(n-k,n-k,mod);
        long ans=(p*c)%mod;
       //DebugUtils.print(c);
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

}

