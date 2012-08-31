import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt();
        int a[]=new int[n],b[]=new int[n];
        int i;
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            b[i]=a[i];
        }
        int c=0;
        ArrayUtils.mergeSort(b,0,n-1);
        for(i=0;i<n;i++)
            if(b[i]!=a[i])
                c++;
        if(c<=2)
            out.println("YES");
        else out.println("NO");
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

class ArrayUtils {

	static long counter=0;
    public static int[] mergeSort(int a[],int p,int q)
    {
        if(p<q)
        {
            int mid=(p+q)/2;
            mergeSort(a,p,mid);
            mergeSort(a,mid+1,q);
            a=merge(a,p,q,mid);
        }
        return a;
    }
    private static int[] merge(int a[],int p,int q,int mid)
    {
        int i,j;
        int left[]=new int[mid-p+2];
        int right[]=new int[q-mid+1];
        for(i=0;i<left.length-1;i++)
            left[i]=a[p+i];
        for(j=0;j<right.length-1;j++)
            right[j]=a[mid+j+1];
        left[i]=right[j]=Integer.MAX_VALUE;
        i=j=0;
        for(int k=p;k<=q;k++)
        {
            if(left[i]<=right[j])
            {
                a[k]=left[i];
                i++;
            }
            else
            {
                a[k]=right[j];
                j++;
                counter+=left.length-1-i;
            }
        }
        return a;
    }
}

