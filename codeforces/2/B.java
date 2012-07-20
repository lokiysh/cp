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
        int n=in.nextInt(),i,j;
        int five[][]=new int[n][n],two[][]=new int[n][n],a[][]=new int[n][n];
        char path[][]=new char[n][n];
        boolean status=false;
        char path1[][]=new char[n][n];
        int row=0,col=0;
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
            {
                int k=in.nextInt();
                if(k==0)
                {
                    status=true;
                    k=10;
                    row=i;
                    col=j;
                }
                a[i][j]=k;
            }
        two[0][0]=count(a[0][0],2);
        five[0][0]=count(a[0][0],5);
        for(i=1;i<n;i++)
        {
            two[0][i]=two[0][i-1]+count(a[0][i],2);
            five[0][i]=five[0][i-1]+count(a[0][i],5);
            two[i][0]=two[i-1][0]+count(a[i][0],2);
            five[i][0]=five[i-1][0]+count(a[i][0],5);
            path[i][0]='D';
            path[0][i]='R';
            path1[i][0]='D';
            path1[0][i]='R';
        }
        for (i=1;i<n;i++)
        {
            for(j=1;j<n;j++)
            {
                two[i][j]=count(a[i][j],2);
                if(two[i-1][j]<two[i][j-1])
                {
                    two[i][j]+=two[i-1][j];
                    path[i][j]='D';
                }
                else
                {
                    two[i][j]+=two[i][j-1];
                    path[i][j]='R';
                }

                five[i][j]=count(a[i][j],5);
                if(five[i][j-1]<five[i-1][j])
                {
                    five[i][j]+=five[i][j-1];
                    path1[i][j]='R';
                }
                else
                {
                    five[i][j]+=five[i-1][j];
                    path1[i][j]='D';
                }
            }
        }
        //for(i=0;i<n;i++)
          //  for(j=0;j<n;j++)
            //    System.out.println(two[i][j]+" "+five[i][j]);
        i=n-1;
        j=n-1;
        if(status)
        {
            if(Math.min(two[i][j],five[i][j])>=1)
            {
                out.println(1);
                for(int p=0;p<row;p++)
                    out.print("D");
                for(int p=0;p<n-1;p++)
                    out.print("R");
                for(int p=row+1;p<n;p++)
                    out.print("D");
                out.println();
                return;
            }
        }
        if(two[i][j]<=five[i][j])
        {
            out.println(two[i][j]);
            out.println(printpath(path));
        }
        else
        {
            out.println(five[i][j]);
            out.println(printpath(path1));
        }
    }
    public String printpath(char a[][])
    {
        StringBuilder s=new StringBuilder("");
        int i=a.length-1,j=a.length-1;

        while (i>0||j>0)
        {
            s.append(a[i][j]);
            if(a[i][j]=='R')
            {
                j-=1;

            }
            else i-=1;

        }
        s=s.reverse();
        return s.toString();
    }
    public int count(int n,int digit)
    {
        int c=0;
        while (n%digit==0)
        {
            c++;
            n/=digit;
        }
        return c;
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

