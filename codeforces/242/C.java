import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Collection;
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
        long x0=in.nextInt(),y0=in.nextInt(),x1=in.nextInt(),y1=in.nextInt(),n=in.nextInt();
        HashSet<Long> hash=new HashSet<Long>();
        int i;
        for(i=0;i<n;i++)
        {
            long r=in.nextInt(),a=in.nextInt(),b=in.nextInt();
            for(long j=a;j<=b;j++)
                hash.add((r<<32)+j);
        }
        Queue<Item> queue=new LinkedList<Item>();
        queue.add(new Item(x0,y0,0));
        hash.remove((x0<<32)+y0);
        while (!queue.isEmpty())
        {
            Item p=queue.poll();
            if(p.x==x1&&p.y==y1)
            {
                out.printLine(p.d);
                return;
            }
            for(int dx=-1;dx<=1;dx++)
                for(int dy=-1;dy<=1;dy++)
                {
                    long xx=p.x+dx,yy=p.y+dy,dd=p.d+1;
                    long k=(xx<<32)+yy;
                    if(hash.contains(k))
                    {
                        hash.remove(k);
                        queue.add(new Item(xx,yy,dd));
                    }
                }
        }
        out.printLine(-1);
	}
    class Item
    {
        long x,y,d;
        public Item(
                long x,long y,long d)
        {
            this.x=x;
            this.y=y;
            this.d=d;
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

