import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.OutputStream;
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
        int n=in.nextInt(),i,j;
        int a[][]=new int[50][50];
        int sizes[]=new int[50];
        for(i=0;i<n;i++)
            sizes[i]=in.nextInt();
        int b[][]=new int[50][50];
        int k=0;
        int row[]=new int[2501];
        int col[]=new int[2501];
        int drow[]=new int[2501];
                int dcol[]=new int[2501];
        for(i=0;i<n;i++)
        {
            for(j=0;j<sizes[i];j++)
            {
                //b[i][j]=k++;
                a[i][j]=in.nextInt();
                row[a[i][j]]=i+1;
                col[a[i][j]]=j+1;

                k++;
                drow[k]=i+1;
                dcol[k]=j+1;
            }

        }

        ArrayList<String > ou=new ArrayList<String>();
        for(i=1;i<=k;i++)
        {
            if(row[i]==drow[i]&&col[i]==dcol[i])
                continue;
            for(j=i+1;j<=k;j++)
            {
                if(row[j]==drow[i]&&col[j]==dcol[i])
                {
                    String s=row[i]+" "+col[i]+" "+row[j]+" "+col[j];
                    ou.add(s);
                    row[j]=row[i];
                    col[j]=col[i];

                    break;
                }
            }
        }
        out.println(ou.size());
        for(i=0;i<ou.size();i++)
        {
            //out.println(row.get(i)+" "+col.get(i)+" "+row.get(i+1)+" "+col.get(i+1));
            out.println(ou.get(i));
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

