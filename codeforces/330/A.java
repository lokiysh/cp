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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int r=in.nextInt(),c=in.nextInt(),i,j,a[][]=new int[r][c];
        boolean rows[]=new boolean[r],cols[]=new boolean[c];
        for(i=0;i<r;i++)
        {
            String s=in.next();
            for(j=0;j<c;j++)
            {
                if(s.charAt(j)!='.')
                {    a[i][j]=1;
                rows[i]=true;
                cols[j]=true;   }
            }
        }
        int count=0;
        for(i=0;i<r;i++)
        {
            if(!rows[i])
            for(j=0;j<c;j++)
            {
                if(a[i][j]==0){
                a[i][j]=2;
                count++;
                }
            }
        }
        for(i=0;i<c;i++)
        {
            if(!cols[i])
            {
                for(j=0;j<r;j++)
                {
                    if(a[j][i]==0)
                    {
                        a[j][i]=2;
                        count++;
                    }

                }
            }
        }
        out.printLine(count);

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

