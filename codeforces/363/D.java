import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
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
    long price;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.nextInt(), m = in.nextInt(), a = in.nextInt();
        int i;
        long b[] = new long[(int)n], p[] = new long[(int)m];
        int low = 1, high = (int)Math.min(n, m), mid;
        for(i=0;i<n;i++)
            b[i] = in.nextInt();
        for(i=0;i<m;i++)
            p[i]= in.nextInt();
        Arrays.sort(b);
        Arrays.sort(p);
        int ans = 0;
        long price = 0;
        while (low <= high) {
            mid = (low + high)/ 2;
            this.price = 0;
            if(check(mid, b, p, a)) {
                ans = mid;
                price = this.price;
                low = mid + 1;
            }
            else  {
                high = mid - 1;
            }
        }
        out.printLine(ans +" "+price);
    }
    public boolean check(int x, long b[] , long p[], long a) {
        int i = 0, j = b.length - x;
        long extra = 0, shared = a, sum = 0;
        for(i=0;i<x;i++, j++) {
            if(b[j] < p[i]) {
                extra += p[i] - b[j];
                //shared -= p[i] - b[j];
                //price += b[j];
            }
            sum += p[i];
        }
        if(extra > a)
            return false;
        price = sum - a;
        price = Math.max(0, price);
        return true;
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

