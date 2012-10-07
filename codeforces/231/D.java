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
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int x=in.nextInt(),y=in.nextInt(),z=in.nextInt(),x1=in.nextInt(),y1=in.nextInt(),z1=in.nextInt();
        int a[]=new int[6];
        int i;
        int ans=0;
        for(i=0;i<6;i++)
            a[i]=in.nextInt();
        if(y<0)
            ans+=a[0];
        if(y>y1)
            ans+=a[1];
        if(z<0)
            ans+=a[2];
        if(z>z1)
            ans+=a[3];
        if(x<0)
            ans+=a[4];
        if(x>x1)
            ans+=a[5];
        out.println(ans);

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

