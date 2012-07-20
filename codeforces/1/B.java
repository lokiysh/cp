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
        int test=in.nextInt();
        for(int t=0;t<test;t++){
        String s=in.next();
        int row=s.indexOf('R');
        int col=s.indexOf('C');
        if(row==0&&col>1&&Character.isDigit(s.charAt(1)))
        {
            row=Integer.parseInt(s.substring(row+1,col));
            col=Integer.parseInt(s.substring(col+1));
            StringBuffer s1=new StringBuffer("");
            while (col>0)
            {
                col-=1;
                s1.append((char)('A'+col%26));
                col/=26;
            }
            s1=s1.reverse();
            s1.append(row);
            out.println(s1);
        }
        else
        {
            int index=0;
            while (!Character.isDigit(s.charAt(index)))
                index++;
            row=Integer.parseInt(s.substring(index));
            String c=s.substring(0,index);
            col=0;
            for(int i=c.length()-1;i>=0;i--)
                col+=Math.pow(26,c.length()-1-i)*(c.charAt(i)-'A'+1);
            out.println("R"+row+"C"+col);
        }
    } }
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

