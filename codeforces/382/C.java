import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int a[] = new int[n], i;
        for(i=0;i<n;i++) {
            a[i] = in.nextInt();
        }
        if(n == 1) {
            out.printLine(-1);
            return;
        }
        a = ArrayUtils.mergeSort(a, 0, n - 1);
        if(a[0] == a[n - 1]) {
            out.printLine(1);
            out.printLine(a[0]);
            return;
        }
        int diff;
        if(n == 2) {
            diff = a[1] - a[0];
            if((a[1] - a[0]) % 2 == 1) {
                out.printLine(2);
                out.printLine((a[0] - diff)+" "+(a[1] + diff));
            } else {
                out.printLine(3);
                out.printLine((a[0] - diff)+" "+(a[0] + diff / 2)+" "+(a[1] + diff));
            }
            return;
        }
        int commonDiff[] = new int[n - 1];
        for(i=1;i<n;i++) {
            commonDiff[i - 1] = a[i] - a[i - 1];
        }
        boolean allSame = true;
        for(i=1;i<commonDiff.length;i++) {
            if(commonDiff[i] != commonDiff[0]) {
                allSame = false;
                break;
            }
        }
        if(allSame) {
            out.printLine(2);
            out.printLine((a[0] - commonDiff[0])+" "+(a[n - 1] + commonDiff[0]));
            return;
        }
        int b[] = new int[commonDiff.length];
        for(i=0;i<commonDiff.length;i++) {
            b[i] = commonDiff[i];
        }
        b = ArrayUtils.mergeSort(b, 0, commonDiff.length - 1);
        int smallCount = 0, largeCount = 0;
        int small = b[0], large = b[b.length - 1];
        for(i=0;i<b.length;i++) {
            if(b[i] == small) {
                smallCount++;
            }
            else if(b[i] == large) {
                largeCount++;
            }
        }
        if(large == 2 * small && smallCount == b.length - 1 && largeCount == 1) {
            out.printLine(1);
            //DebugUtils.print(large, small, commonDiff);
            for(i=0;i<commonDiff.length;i++) {
                if(commonDiff[i] == large) {
                    out.printLine((a[i + 1] + a[i]) / 2);
                    break;
                }
            }
            //out.printLine();
        }
        else out.printLine(0);
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

	static public long counter=0;
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

