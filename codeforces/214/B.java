import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintStream;
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
        int n=in.nextInt(),a[]=new int[10],i;
        boolean stat=false;
        int sum=0;
        for(i=0;i<n;i++)
        {
            int k=in.nextInt();
            a[k]++;
            sum+=k;
        }
        if(a[0]==0)
        {
            out.println(-1);
            return;
        }
        int used[]=new int[10];


        int j,dec=0;
        if(sum%3==1)
        {
            for(j=1;j<10;j++)
            {
                if(a[j]>0&&j%3==1)
                {
                    dec=j;
                    DebugUtils.print(dec);
                    a[j]-=1;
                    break;
                }
            }
            sum-=dec;
        }
        DebugUtils.print(sum);

        DebugUtils.print(sum);
        if(sum%3==2)
        {
            for(j=2;j<10;j++)
            {
                if(a[j]>0&&j%3==2)
                {
                    dec=j;
                    a[j]-=1;
                    break;
                }
            }
            sum-=dec;
        }
        if(sum%3!=0)
        {
            int mod=3-sum%3;
            int count=0;
            for(j=1;j<10;)
            {
                if(count==2)
                    break;
                if(j%3!=mod)
                {
                    j++;
                    continue;
                }
                if(a[j]>0)
                {
                    a[j]-=1;
                    count++;
                }
                else j++;
            }
            if(count<2)
            {
                StringBuilder s=new StringBuilder("");
                for(i=1;i<10;i++)
                {
                     if(i%3==0&&a[i]>0)
                     stat=true;
                 }
                if(!stat)
                {
                    out.println(0);
                    return;
                }
                for(i=9;i>=0;i--)
                {
                    if(i%3==0)
                        for(j=0;j<a[i];j++)
                            s.append(i);

                }
                out.println(s);
                return;
            }
        }
        for(i=1;i<10;i++)
        {
            if(a[i]>0)
                stat=true;
        }
        DebugUtils.print(sum);

        if(!stat)
        {
            out.println(0);
            return;
        }
        StringBuilder s=new StringBuilder("");
        for(i=9;i>=0;i--)
        {
            for(j=0;j<a[i];j++)
                s.append(i);
        }
        out.println(s);
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
                String s;
                if((s=in.readLine())!=null)
                tokenizer=new StringTokenizer(s);
                else return null;
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

class DebugUtils {
    public static void print(Object... a)
    {
        boolean oj=System.getProperty("ONLINE_JUDGE")!=null;
        if(!oj)
            System.out.println(Arrays.deepToString(a));
    }
}

