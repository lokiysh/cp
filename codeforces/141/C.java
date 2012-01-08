import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;
import java.util.Vector;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author codeKNIGHT
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt();
        int i;
        people a[]=new people[n];
        Vector<String> ans=new Vector<String>();
        for(i=0;i<n;i++)
        {
            a[i]=new people(in.next(),in.nextInt());
        }
        Arrays.sort(a);

        for(i=0;i<n;i++)
        {
            if(i>=a[i].a)
            {
                ans.insertElementAt(a[i].name,ans.size()-a[i].a);
            }
            else
            {
                out.println(-1);
                return;
            }
        }
        for(i=0;i<n;i++)
        {
            a[i].a=ans.indexOf(a[i].name)+1;
        }
        for(i=0;i<n;i++)
            out.println(a[i].name+" "+a[i].a);
	}
    class people implements Comparable<people>
    {
        String name;
        int a;
        public people(String name,int a)
        {
            this.name=name;
            this.a=a;
        }
        public int compareTo(people p)
        {
            if(p.a<this.a)
                return 1;
            return -1;
        }
    }
}

