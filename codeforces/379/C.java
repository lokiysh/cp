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
import java.util.HashSet;
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
        int n = in.nextInt(), i;
        Pair a[] = new Pair[n];
        for(i=0;i<n;i++) a[i] = new Pair(i, in.nextInt());
        Arrays.sort(a);
        int lastUnused = 1;
        HashSet<Integer> set = new HashSet<Integer>();
        for(i=0;i<n;i++) {
            if(!set.contains(a[i].value)) {
                set.add(a[i].value);
                lastUnused = a[i].value + 1;
            }
            else {
                a[i].value = lastUnused;
                lastUnused++;
                set.add(a[i].value);
            }
        }
        int res[] = new int[n];
        for(i=0;i<n;i++) {
            res[a[i].index] = a[i].value;
        }
        for(i=0;i<n;i++)
            out.print(res[i] +" ");
    }
    class Pair implements Comparable<Pair> {
        int index, value;
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
        public int compareTo(Pair a) {
            return this.value - a.value;
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

	public void close() {
		writer.close();
	}
}

