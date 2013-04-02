import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
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
        int n=in.nextInt(),m=in.nextInt(),d=in.nextInt(),i,j,a[]=new int[n*m];
        int freq[]=new int[10001];
        int sum=0;

        int k=0;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                a[k]=in.nextInt();
                freq[a[k]] ++;
                sum+=a[k];
                k++;
            }
        }
        int b[]= ArrayUtils.mergeSort(a,0,n*m-1);
       
        for(i=1;i<n*m;i++)
        {
            if((b[i]-b[i-1])%d!=0)
            {
                out.printLine(-1);
                return;
            }
        }
        //DebugUtils.print(sum,avg);
        int last=b[0],cur=1;
        ArrayList<Packets> ar=new ArrayList<Packets>();
       for(i=1;i<n*m;i++)
       {
            if(b[i]==last)
            {
                cur++;
            }
           else
            {
                ar.add(new Packets(last,cur));
                cur=1;
                last=b[i];
            }
       }
        ar.add(new Packets(last,cur));
        int ans=Integer.MAX_VALUE;
        for( Packets p : ar)
        {
            int cost=0;
            for( Packets q : ar)
            {
                cost+=q.f*Math.abs(p.index-q.index)/d;
            }
            ans=Math.min(ans,cost);
        }
        out.printLine(ans);

    }
    class Packets
    {
        int index,f;
        public Packets(int i,int f){
            this.index=i;
            this.f=f;
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

