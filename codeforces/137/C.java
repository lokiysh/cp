import java.util.List;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.InputStream;

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
        int n=in.nextInt(),i,j,t;
        ArrayList<Points> a=new ArrayList<Points>();
        for(i=0;i<n;i++)
        {
            j=in.nextInt();
            t=in.nextInt();
            a.add(new Points(j,t));
        }
        Collections.sort(a);
        int c=0,max=a.get(0).end;
        for(i=1;i<n;i++)
        {
            if(a.get(i).end<max)
                c++;
            if(a.get(i).end>max)
                max=a.get(i).end;
        }
        out.println(c);
	}
}

class Points implements Comparable<Points>
{
    int start,end;
    public Points(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
    @Override
    public int compareTo(Points a)
    {
        if(a.start<this.start)
            return 1;
        return 0;
    }

}

