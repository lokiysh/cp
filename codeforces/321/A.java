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
 * @author Lokesh Khandelwal
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a=in.nextInt(), b=in.nextInt();
        String s=in.next();
        int i,n=s.length();
        int x[]=new int[n+1],y[]=new int[n+1];
        x[0]=a;
        y[0]=b;
        int sumx=0,sumy=0;
        for(i=1;i<=n;i++)
        {
            int dx=0,dy=0;
            if(s.charAt(i-1)=='D')
                dy++;
            else if(s.charAt(i-1)=='U')
                dy--;
            else if(s.charAt(i-1)=='L')
                dx++;
            else dx--;
            sumx+=(-dx);
            sumy+=(-dy);
            x[i]=x[i-1]+dx;
            y[i]=y[i-1]+dy;
        }
        boolean visited=false;
        DebugUtils.print(sumx,sumy);
        DebugUtils.print(x,y);
        if(sumx==0&&sumy==0) {
            for(i=0;i<=n;i++) {
                if(x[i] ==0 &&y[i]==0)
                {
                    visited=true;
                    break;
                }
            }
        }
        else if(sumx==0)
        {
            for(i=0;i<=n;i++) {
                if(x[i] ==0 &&y[i]%sumy==0&&isSame(y[i],sumy))
                {
                    visited=true;
                    break;
                }
            }
        }
        else if(sumy==0)
        {
            for(i=0;i<=n;i++) {
                if(x[i]%sumx ==0 &&y[i]==0&&isSame(x[i],sumx))
                {
                    visited=true;
                    break;
                }
            }
        }
        else
        {
            for(i=0;i<=n;i++) {
                if(x[i]%sumx ==0)
                {
                    int k = x[i]/sumx;
                    if(k<0) k*=-1;
                    if(sumy*k ==y[i]){
                    visited=true;
                    break;
                    }
                }
            }
        }
        if(visited)
            out.printLine("Yes");
        else out.printLine("No");
    }
    public boolean isSame(int a,int b) {
        if(a>=0&&b>=0)
            return true;
        if(a<=0&&b<=0)
            return true;
        return false;
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

