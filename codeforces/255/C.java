import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Hashtable;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
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
		OutputWriter out = new OutputWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),i,j;
        int a[]=new int[n];
        /*HashSet<Integer> hs=new HashSet<Integer>();
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            hs.add(a[i]);
        }
        int s=hs.size();
        if(n==1)
        {
            out.printLine(1);
            return;
        }
        Hashtable<Integer,Integer> set[]=new Hashtable[n];
        for(i=0;i<n;i++)
            set[i]=new Hashtable<Integer,Integer>(s,(float)s);
        set[0].put(a[0],1);
        int max=2;
        for(i=1;i<n;i++)
        {
            set[i].put(a[i],1);
            for(j=i-1;j>=0;j--)
            {
                if(set[j].containsKey(a[i]))
                {
                    int p=set[j].get(a[i])+1,q=0;
                    if(set[i].containsKey(a[j]))
                        q=set[i].get(a[j]);
                    int k=Math.max(p,q);

                    set[i].put(a[j], k);
                    max=Math.max(max,k);
                }
                else
                {
                    int q=0;
                    if(set[i].containsKey(a[j]))
                        q=set[i].get(a[j]);
                    int k=Math.max(q,2);
                    set[i].put(a[j],k);
                    max=Math.max(max,k);
                }

            }

        }
        
        out.printLine(max);
        */
        int s=0;
        Hashtable<Integer,Integer> table=new Hashtable<Integer, Integer>(4000,1);
        for(i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            if(!table.containsKey(a[i]))
            {
                table.put(a[i],s);
                s++;
            }
        }
        int A[][]=new int[n][n];
        if(n==1)
        {
            out.printLine(1);
            return;
        }
        A[0][0]=1;
        int p,q,max=2,x,y,k;
        for(i=1;i<n;i++)
        {
            p=table.get(a[i]);
            A[i][p]=1;
            for(j=i-1;j>=0;j--)
            {
                q=table.get(a[j]);
                y=A[i][q];
                x=A[j][p];
                if(x>0)
                {
                    x++;
                }
                else x=2;
                k=Math.max(x,y);
                A[i][q]=k;
                max=Math.max(max,k);
            }
        }
        out.printLine(max);
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

