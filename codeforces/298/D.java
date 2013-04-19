import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.Hashtable;
import java.util.Set;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),m=in.nextInt(),k=in.nextInt();
        int i;
        Hashtable<Integer,Integer> Alice=new Hashtable<Integer, Integer>(n+m);
       // Hashtable<Integer,Integer> Bob=new Hashtable<Integer, Integer>(m);
        for(i=0;i<n;i++)
        {
            int p=in.nextInt();
            if(Alice.containsKey(p))
                Alice.put(p,Alice.get(p)+1);
            else Alice.put(p,1);
        }
        for(i=0;i<m;i++)
        {
            int p=in.nextInt();
            if(Alice.containsKey(p))
                Alice.put(p,Alice.get(p)-1);
            else Alice.put(p,-1);
        }
        Items a[]=new Items[Alice.size()];
        int l=0;
        for (int p : Alice.keySet())
        {
            a[l++]=new Items(p,Alice.get(p));
        }
        Arrays.sort(a);
        
        int diff=0;
        boolean status=false;
        for(i=a.length-1;i>=0;i--)
        {
            diff+=a[i].val;
            if(diff>0)
            {
                status=true;
                break;
            }
        }
        if(status)
            out.printLine("YES");
        else out.printLine("NO");

    }
    class Items implements Comparable<Items>
    {
        int key,val;
        public Items(int k,int v)
        {
            this.key = k;
            this.val=v;

        }
        public int compareTo(Items a)
        {
            return -a.key+this.key;
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

