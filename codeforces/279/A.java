import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int x=in.nextInt(),y=in.nextInt(),i,j,t;
        ArrayList<Integer> X=new ArrayList<Integer>(10000),Y=new ArrayList<Integer>(10000);
        int turns=0;
        i=0;
        j=0;
        t=1;
        boolean st=false;
        while (true)
        {
            if(i==x&&j==y)
                break;
            for(int k=1;k<=t;k++)
            {
                i++;
                if(i==x&&j==y)
                {
                    st=true;
                    break;
                }
            }
            if(st)
                break;
            turns++;
            for(int k=1;k<=t;k++)
            {
                j++;
                if(i==x&&j==y)
                {
                    st=true;
                    break;
                }
            }
            if(st)
                break;
            turns++;
            t++;
            for(int k=1;k<=t;k++)
            {
                i--;
                if(i==x&&j==y)
                {
                    st=true;
                    break;
                }
            }
            if(st) break;
            turns++;
            for(int k=1;k<=t;k++)
            {
                j--;
                if(i==x&&j==y)
                {
                    st=true;
                    break;
                }
            }
            if(st) break;
            t++;
            turns++;
        }

        out.printLine(turns);
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

