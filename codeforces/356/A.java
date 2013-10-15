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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt(), m = in.nextInt(), i, j, a, b, c;
        int r[] = new int[n], win[] = new int[n];
        Arrays.fill(win, -1);
        for(i=0;i<m;i++) {
            a = in.nextInt() - 1;
            b = in.nextInt() - 1;
            c = in.nextInt() - 1;
            for(j=a;j<=b;j++) {
                if(j == c)
                    continue;
                if(win[j] != -1) {
//                    if(win[j] >= a && win[j] <= b && win[win[j]] == -1 && win[j] != c) {
//                        win[win[j]] = c;
//                        r[win[j]] = b;
//                    }
                    int temp = r[j] - 1;
                    if(j < c)
                        r[j] = c;
                    else r[j] = b + 1;
                    j = temp;

                }
                else {
                    win[j] = c;
                    if(j < c)
                        r[j] = c;
                    else r[j] = b + 1;
                }
            }
            //DebugUtils.print(win);
            //DebugUtils.print(r);
        }
        for(i=0;i<n;i++)
            out.print(win[i] + 1 +" ");
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

