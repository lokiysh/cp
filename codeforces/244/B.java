import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
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
		OutputWriter out = new OutputWriter(outputStream);
		B solver = new B();
		solver.solve(1, in, out);
		out.close();
	}
}

class B {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n=in.nextInt();
        long x,y,len;
        String s;
        int i,j;
        int ans=0;
        for(x=1;x<=9;x++)
        {
            for(len=1;len<10;len++)
            {
                s="";
                for(i=0;i<len;i++)
                    s+=x;
                if(Long.parseLong(s)<=n)
                    ans++;
            }
        }
        DebugUtils.print(ans);
        for(x=0;x<=9;x++)
        {
            for(y=x+1;y<=9;y++)
            {
                
                DebugUtils.print("Printing for "+x+" "+y);
                for(len=2;len<10;len++)
                {
                    int limit=(1<<len)-1;
                    for(i=1;i<limit;i++)
                    {
                        s=Long.toBinaryString(i);
                        while (s.length()<len)
                            s="0"+s;
                        StringBuilder str=new StringBuilder("");

                         //DebugUtils.print(p+" "+q);
                        for(int k=0;k<len;k++)
                        {
                            if(s.charAt(k)=='0')
                                str.append(x);
                            else str.append(y);
                        }
                        //DebugUtils.print(str);
                        s=str.toString();
                        if(s.startsWith("0"))
                            continue;
                        if(Long.parseLong(s)<=n)
                        {
                            ans++;
                            //DebugUtils.print(s);
                        }
                    }
                }
            }
        }
        if(n==1000000000)
            ans++;
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

class DebugUtils {
    public static void print(Object... a)
    {
        boolean oj=System.getProperty("ONLINE_JUDGE")!=null;
        if(!oj)
            System.out.println(Arrays.deepToString(a));
    }
}

