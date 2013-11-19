import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Hashtable;
import java.util.ArrayList;
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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int i, j;
        int a = in.nextInt();
        String s = in.next();
        if(a == 0) {
            out.printLine(getZero(s));
            return;
        }
        int len = s.length();
        int cumSum[] = new int[len + 1];
        cumSum[0] = 0;
        for(i=0;i<len;i++) {
            cumSum[i + 1] = cumSum[i] + s.charAt(i) - '0';
        }
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for(i=1;i<=len;i++) {
            for(j=i;j<=len;j++) {
                int p = cumSum[j] - cumSum[i - 1];
                if(table.containsKey(p))
                    table.put(p, table.get(p) + 1);
                else table.put(p, 1);
            }
        }

        table.remove(0);
        int find;
        long ans = 0;
        for(int key : table.keySet()) {
            find = a / key;
            if(key * find != a || !table.containsKey(find)) continue;
            ans += (long)(table.get(key)) * table.get(find);
        }
        out.printLine(ans);
    }
    public long getZero(String s) {
        int len = s.length(), i, count = 0;
        ArrayList<Long> zero = new ArrayList<Long>();
        for(i=0;i<len;i++) {
            if(s.charAt(i) == '0') {
                count++;
            }
            else {
                zero.add((long)count);
                count = 0;
            }
        }
        if(count > 0)
            zero.add((long)count);

        int size = zero.size();
        long ans = 0;
        for(i=0;i<size;i++) {
            ans += ((zero.get(i) + 1)*(len + 1) * zero.get(i) * len) / 2;
        }
        //DebugUtils.print(ans);
        for(i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                ans -= ((zero.get(i) + 1) * (zero.get(j) + 1) * zero.get(i) * zero.get(j)) / 4;
            }
        }
        return ans;
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

