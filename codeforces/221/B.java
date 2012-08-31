import java.io.InputStreamReader;
import java.io.IOException;
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
        int n=in.nextInt(),i;
        int ans=0;
        int sqrt=(int)Math.sqrt(n)+1;
        for(i=1;i<sqrt;i++)
        {
            if(n%i==0)
            {
                if(check(n,i))
                    ans++;
                int p=n/i;
                if(p==i)
                    continue;
                if(check(n,p))
                    ans++;
            }


        }
        out.println(ans);
	}
    public boolean check(int a,int b)
    {
        String s=Integer.toString(b);
        String s1=Integer.toString(a);
        int array[]=new int[10];
        for(int i=0;i<s.length();i++)
            array[s.charAt(i)-'0']++;
        for(int i=0;i<s1.length();i++)
            if(array[s1.charAt(i)-'0']>0)
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

