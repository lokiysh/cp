import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        in.useDelimiter("\n");
        int i,points[]=new int[4],scored[]=new int[4],missed[]=new int[4],j,index=0,num[]=new int[4];
        String tea1,tea2="";
        ArrayList<String> team=new ArrayList<String>();
        for(i=0;i<5;i++)
        {
            String s[]=in.next().split(" ");
            tea1=s[0];
            tea2=s[1];
            if(!team.contains(tea1))
            {
                team.add(tea1);

            }
            index=team.indexOf(tea1);
            scored[index]+=s[2].charAt(0)-48;
            missed[index]+=s[2].charAt(2)-48;
            if(s[2].charAt(0)>s[2].charAt(2))
                points[index]+=3;
            else if(s[2].charAt(0)==s[2].charAt(2))
                points[index]+=1;
            num[index]+=1;
            if(!team.contains(tea2))
            {
                team.add(tea2);

            }
            index=team.indexOf(tea2);
            scored[index]+=s[2].charAt(2)-48;
            missed[index]+=s[2].charAt(0)-48;
            if(s[2].charAt(0)<s[2].charAt(2))
                points[index]+=3;
            else if(s[2].charAt(0)==s[2].charAt(2))
                points[index]+=1;
            num[index]+=1;
        }
        table a[]=new table[4];
        for(i=0;i<4;i++)
            a[i]=new table(team.get(i),points[i],scored[i],missed[i]);
        for(i=0;i<4;i++)
        {
            if(num[i]==2&&(team.get(i).equals("BERLAND")==false))
                tea2=team.get(i);

        }
        Arrays.sort(a);
        int index2=0;
        for(i=0;i<4;i++)
        {
            if(a[i].tname.equals("BERLAND"))
                index=i;
            if(a[i].tname.equals(tea2))
                index2=i;

        }
        if(index<2)
        {
            out.println("1:0");
            return;
        }
        if(a[1].points-a[index].points>3)
        {
            out.println("IMPOSSIBLE");
            return;
        }
        if(a[1].points-a[index].points<3)
        {
            out.println("1:0");
            return;
        }
        a[index].points+=3;
        Arrays.sort(a);
        for(i=0;i<4;i++)
        {
            if(a[i].tname.equals("BERLAND"))
                index=i;
            if(a[i].tname.equals(tea2))
                index2=i;

        }
        if(index<2)
        {
           out.println("1:0");
            return;
        }
        int k,min=Integer.MAX_VALUE,x=0,y=0;
        for(i=1;i<=50;i++)
        {
            for(j=0;j<i;j++)
            {
                table fin[]=new table[4];
                for(k=0;k<4;k++)
                {
                    if(team.get(k).equals("BERLAND"))
                        fin[k]=new table("BERLAND",points[k]+3,scored[k]+i,missed[k]+j);
                    else if(team.get(k).equals(tea2))
                        fin[k]=new table(tea2,points[k],scored[k]+j,missed[k]+i);
                    else
                        fin[k]=new table(team.get(k),points[k],scored[k],missed[k]);
                }
                Arrays.sort(fin);
                index=0;
                for(k=0;k<4;k++)
                    if(fin[k].tname.equals("BERLAND"))
                        index=k;
                if(index<2&&(i-j)<min)
                {
                    min=Math.min(min,i-j);
                    x=i;
                    y=j;
                }
            }
        }
        out.println(x+":"+y);

	}
    class table implements Comparable<table>
    {
        String tname;
        int points,s,m;
        public table(String tname,int points,int s,int m)
        {
            this.tname=tname;
            this.points=points;
            this.s=s;
            this.m=m;
        }
        public int compareTo(table a)
        {
            if(a.points>this.points)
                return 1;
            else if(a.points<this.points)
                return -1;
            else
            {
                int diff1=a.s-a.m;
                int diff2=this.s-this.m;
                if(diff1>diff2)
                    return 1;
                else if(diff1<diff2) return -1;
                else
                {
                    if(a.s>this.s) return 1;
                    else if(a.s<this.s) return -1;
                    else
                    {
                        return ((a.tname).compareTo(this.tname)<0?1:-1);
                    }
                }
            }
        }
    }
}

