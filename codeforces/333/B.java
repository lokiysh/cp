import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        int n=in.nextInt(),m=in.nextInt(),i,j,a[][]=new int[n][n];

        int rowFirst[]=new int[n];
        int colFirst[]=new int[n];
        Arrays.fill(rowFirst,1);
        Arrays.fill(colFirst,1);
        for(i=0;i<m;i++)
        {

                int x=in.nextInt()-1,y=in.nextInt()-1;
                a[x][y]=1;
                rowFirst[x]=0;
                colFirst[y]=0;

        }

        int count=0;
        for(i=1;i<n/2;i++)
        {
            int val = rowFirst[i]+rowFirst[n-i-1]+colFirst[i]+colFirst[n-i-1];
           
            count+=val;
        }
        if(n%2==1)
             if(rowFirst[n/2]==1||colFirst[n/2]==1)
                 count++;
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

