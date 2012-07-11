import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
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
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt();
        int i,front[]=new int[n],back[]=new int[n];
        java.util.Hashtable<Integer,Integer> table=new java.util.Hashtable<Integer, Integer>();
        java.util.Hashtable<Integer,Integer> fr=new java.util.Hashtable<Integer, Integer>();
        for(i=0;i<n;i++)
        {
            front[i]=in.nextInt();
            back[i]=in.nextInt();
            if(front[i]!=back[i])
            {
                if(table.containsKey(back[i]))
                    table.put(back[i], table.get((Integer)back[i]) + 1);
                else table.put(back[i],1);
            }
            if(fr.containsKey(front[i]))
            {
                fr.put(front[i],fr.get((Integer)front[i])+1);

            }
            else fr.put(front[i],1);

        }
        int limit=fr.size();
        int min=Integer.MAX_VALUE;
        Set<Integer> h=fr.keySet();
        boolean status=false;
        int need=(n+1)/2,ans=Integer.MAX_VALUE;
        Iterator<Integer> itr=h.iterator();
        while (itr.hasNext())
        {
            int k=itr.next();
            int a=fr.get(k);
            if(a>=need)
            {
                status=true;
                ans=0;
            }
            else{
                if(table.containsKey(k))
                { int b=table.get(k);
                if(b+a>=need)
                {
                    status=true;
                    ans=Math.min(ans,need-a);
                }}
            }
        }
        h=table.keySet();
        itr=h.iterator();
        while (itr.hasNext())
        {
            int k=itr.next();
            int a=table.get(k);
            if(a>=need)
            {
                status=true;
                ans=Math.min(ans,need);
            }
        }
        if(!status)
            out.println(-1);
        else out.println(ans);
	}
}

