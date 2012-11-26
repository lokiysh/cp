import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.PrintStream;
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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt(),i;
        for(i=0;i<n;i++)
        {
            String s=in.nextString();
            String a[]=s.split(":");
            ArrayList<String> blocks=new ArrayList<String>();
            boolean stat=false;
            for(int j=0;j<a.length;j++)
            {
                if(a[j].equals(""))
                {
                    if(stat)
                        continue;
                    stat=true;
                    blocks.add("helloWorld!!");
                }
                else
                {
                    String p=a[j];
                    while (p.length()<4)
                        p="0"+p;
                    blocks.add(p);
                }
            }
            int pos=s.indexOf("::");
             DebugUtils.print(pos);
            if(pos==s.length()-2)
                blocks.add("helloWorld!!");
            //pos=blocks.indexOf("helloWorld!!");
           DebugUtils.print(blocks);
            StringBuilder ans=new StringBuilder("");

            for(String p: blocks)
            {
                if(p.equals("helloWorld!!"))
                {
                    
                    for(int x=0;x<=8-blocks.size();x++)
                        ans.append("0000:");
                }
                else
                    ans.append(p+":");
            }
            ans.deleteCharAt(ans.length()-1);
            out.printLine(ans);
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
    public String nextString()
    {
        try{
            return in.readLine();
        }
        catch (IOException e)
        {
            return null;
        }
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

class DebugUtils {
    public static void print(Object... a)
    {
        boolean oj=System.getProperty("ONLINE_JUDGE")!=null;
        if(!oj)
            System.out.println(Arrays.deepToString(a));
    }
}

