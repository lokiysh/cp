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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s=in.next();
        int n=s.length();
        ArrayList<String > a=new ArrayList<String>(100000);
        StringBuilder prev=new StringBuilder("");
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='-')
            {
                a.add(prev.toString());
                prev=new StringBuilder("");
            }
            else
            {
                prev.append(s.charAt(i));
            }
        }
        a.add(prev.toString());
       // DebugUtils.print(a);
        String c[]=new String[a.size()];
        int k=0;
        for(String s1 : a)
            c[k++]=s1;
        int days[]={31,28,31,30,31,30,31,31,30,31,30,31};
        Hashtable<String,Integer> hash=new Hashtable<String,Integer>();
        //DebugUtils.print(c);
        for(int i= 0;i<k-2;i++)
        {
            if(c[i].length()>=2&&c[i+1].length()==2&&c[i+2].length()>=4)
            {
                String date=c[i].substring(c[i].length()-2,c[i].length());
                String month=c[i+1];
                String year=c[i+2].substring(0,4);

                int y=Integer.parseInt(year),m=Integer.parseInt(month),d=Integer.parseInt(date);
                //DebugUtils.print(d,m,y);
                if(y>=2013&&y<=2015)
                {
                    if(m>=1&&m<=12)
                    {
                        if(d>=1&&days[m-1]>=d)
                        {

                            String key=date+"-"+month+"-"+year;
                            if(hash.containsKey(key))
                            {
                                hash.put(key,hash.get(key)+1);
                            }
                            else hash.put(key,1);
                        }
                    }
                }
            }
        }
        int max=0;
        String ans="";
        //DebugUtils.print(hash);
        for(String key: hash.keySet())
        {
            if(hash.get(key)>max)
            {
                max=hash.get(key);
                ans=key;
            }
        }
        out.printLine(ans);
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

