import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt(),m=in.nextInt(),k=in.nextInt(),i,j;
        int a[][]=new int[n][m];
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
                a[i][j]=in.nextInt();
        }
        int row[]=new int[n];
        int col[]=new int[m];
        for(i=0;i<n;i++)
            row[i]=i;
        for(i=0;i<m;i++)
            col[i]=i;
        for(i=0;i<k;i++)
        {
            char s=in.next().charAt(0);
            int x=in.nextInt()-1,y=in.nextInt()-1;
            if(s=='r')
            {
                int temp=row[x];
                row[x]=row[y];
                row[y]=temp;
            }
            else if(s=='c')
            {
                int temp=col[x];
                col[x]=col[y];
                col[y]=temp;
            }
            else 
            {
                out.println(a[row[x]][col[y]]);
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

