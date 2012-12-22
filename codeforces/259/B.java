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
        int i,j,a[][]=new int[3][3];
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                a[i][j]=in.nextInt();
            }
        }
        int limit=(int)Math.pow(10,5);
        for(i=1;i<=limit;i++)
        {
            int b[][]=a;
            b[0][0]=i;
            int sum=b[0][0]+b[0][1]+b[0][2];
            b[1][1]=sum-b[1][0]-b[1][2];
            b[2][2]=sum-b[2][0]-b[2][1];
            int p=0;
            boolean status=true;

            for(j=0;j<3;j++)
            {
                p=0;
                for(int k=0;k<3;k++)
                {
                   p+=b[k][j]; 
                }
                if(p!=sum)
                    status=false;
            }
            p=b[0][0]+b[1][1]+b[2][2];
            if(p!=sum)
            status=false;
            p=b[2][0]+b[1][1]+b[0][2];
            if(p!=sum)
                status=false;
            if(status)
            {
                for(i=0;i<3;i++)
                {
                    for(j=0;j<3;j++)
                    {
                        out.print(b[i][j]+" ");
                    }
                    out.printLine();
                }
                return;
            }
            
        }
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

