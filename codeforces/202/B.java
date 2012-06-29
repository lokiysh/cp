import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    ArrayList<String> hs=new ArrayList<String>();
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt();
        int i,m,k,j;
        String a[]=new String [n];
        for(i=0;i<n;i++)
            a[i]=in.next();
        m=in.nextInt();
        String b[][]=new String[m][20];
        int size[]=new int[m];
        for(i=0;i<m;i++)
        {
            k=in.nextInt();
            size[i]=k;
            for(j=0;j<k;j++)
                b[i][j]=in.next();
        }
        char c[]=new char[n];
        for(char ch='1';ch<'1'+n;ch++)
            c[ch-49]=ch;
        permute(c,0,n);
        int inv[]=new int[hs.size()],t,x;
        for(i=0;i<hs.size();i++)
        {
            String p=hs.get(i);
            int count=0;
            for(j=0;j<n;j++)
            {
                for(t=j+1;t<n;t++)
                {
                    if(p.charAt(j)>p.charAt(t))
                        count++;
                }
            }
            inv[i]=count;
        }
        boolean status=false;
        int max=-1,index=-1;
        for(i=0;i<m;i++)
        {
            for(j=0;j<hs.size();j++)
            {
                int last=0;
                String p=hs.get(j);
                int st=0;
                for(t=0;t<n;t++)
                {
                    for(x=last;x<size[i];x++)
                    {
                        if(b[i][x].equals(a[p.charAt(t)-1-48]))
                        {
                            st++;
                            last=x+1;
                            break;
                        }
                    }
                }
                if(st==n)
                {
                    status=true;
                    int z=n*(n-1)/2+1-inv[j];
                    if(z>max)
                    {
                        max=z;
                        index=i+1;
                    }
                }
            }
        }
        if(!status)
            out.println("Brand new problem!");
        else {
            out.println(index);
            out.print("[:");
            for(i=0;i<max;i++)
                out.print("|");
            out.println(":]");
        }
	}
    public void permute(char a[],int i,int n)
    {
        int j;
        char temp;
        String s="";
        if(i==n-1)
        {
            for(j=0;j<n;j++)
            s+=a[j];
            if(!hs.contains(s))
            hs.add(s);
        }
        else
        {
            for(j=i;j<n;j++)
            {
            temp=a[i];a[i]=a[j];a[j]=temp;
            permute(a,i+1,n);
            temp=a[i];a[i]=a[j];a[j]=temp;
        }
        }

    }
}

