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
        int red=in.nextInt(),blue=in.nextInt();
        int i;
        int limit=red+blue;
        int firstRed[]=new int[limit];
        int firstBlue[]=new int[limit];
        firstRed[0]=1;
        firstBlue[0]=2;
        int B=blue,R=red,fBlue=blue,fRed=red;
        red--;
        B--;
       
        for(i=1;i<limit;i++)
        {
            if(i%2==1)
            {
                if(firstRed[i-1]==1)
                {
                    if(blue>0)
                    {
                        firstRed[i]=2;
                        blue--;
                    }
                    else
                    {
                        firstRed[i]=1;
                        red--;
                    }
                }
                else
                {
                    if(red>0)
                    {
                        firstRed[i]=1;
                        red--;
                    }
                    else
                    {
                        firstRed[i]=2;
                        blue--;
                    }
                }
            }
            else
            {
                if(firstRed[i-1]==1)
                {
                    if(red>0)
                    {
                        firstRed[i]=1;
                        red--;
                    }
                    else
                    {
                        firstRed[i]=2;
                        blue--;
                    }
                }
                else
                {
                    if(blue>0)
                    {
                        firstRed[i]=2;
                        blue--;
                    }
                    else
                    {
                        firstRed[i]=1;
                        red--;
                    }
                }
            }
        }
        for(i=1;i<limit;i++)
        {
            if(i%2==1)
            {
                if(firstBlue[i-1]==1)
                {
                    if(B>0)
                    {
                        firstBlue[i]=2;
                        B--;
                    }
                    else
                    {
                        firstBlue[i]=1;
                        R--;
                    }
                }
                else
                {
                    if(R>0)
                    {
                        firstBlue[i]=1;
                        R--;
                    }
                    else
                    {
                        firstBlue[i]=2;
                        B--;
                    }
                }
            }
            else
            {
                if(firstBlue[i-1]==1)
                {
                    if(R>0)
                    {
                        firstBlue[i]=1;
                        R--;
                    }
                    else
                    {
                        firstBlue[i]=2;
                        B--;
                    }
                }
                else
                {
                    if(B>0)
                    {
                        firstBlue[i]=2;
                        B--;
                    }
                    else
                    {
                        firstBlue[i]=1;
                        R--;
                    }
                }
            }
        }
        int x=calc(firstRed);
        int y=calc(firstBlue);
        y=Math.max(x,y);
        out.printLine(y,fRed+fBlue-1-y);
    }
    public int calc(int a[])
    {
        int last=a[0];
        int x=0;
        for(int i=1;i<a.length;i++)
        {
            if(a[i]==last)
                x++;
            last=a[i];
        }
        return x;
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

