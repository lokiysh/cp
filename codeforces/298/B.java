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
        int t=in.nextInt(),sx=in.nextInt(),sy=in.nextInt(),ex=in.nextInt(),ey=in.nextInt(),i;
        int x[]=new int[t],y[]=new int[t];
        String s=in.next();
        for(i=0;i<t;i++)
        {
            if(s.charAt(i)=='E')
            {
                x[i]=1;
                y[i]=0;
            }
            else if(s.charAt(i)=='W')
            {
                x[i]=-1;
                y[i]=0;
            }
            else if(s.charAt(i)=='N')
            {
                x[i]=0;
                y[i]=1;
            }
            else
            {
                x[i]=0;
                y[i]=-1;
            }
        }
        int xdiff=ex-sx,ydiff=ey-sy;
        i=0;
        int last=0;
        while (xdiff!=0||ydiff!=0)
        {
            if(xdiff<0)
            {
                if(x[i]<0)
                {
                    xdiff++;
                }
            }
            else if(xdiff>0)
            {
                if(x[i]>0)
                    xdiff--;
            }
            if(ydiff<0)
            {
                if(y[i]<0)
                    ydiff++;
            }
            else if(ydiff>0)
            {
                if(y[i]>0)
                    ydiff--;
            }
            last=i+1;
            i++;
            if(i==t)
                break;
            //DebugUtils.print(xdiff,ydiff);
        }
        if(xdiff==0&&ydiff==0)
            out.printLine(last);
        else out.printLine(-1);
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

