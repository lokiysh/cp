import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
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
        int n=in.nextInt(),d=in.nextInt(),a=in.nextInt(),b=in.nextInt(),i;
        toursist array[]=new toursist[n];
        for(i = 0;i<n;i++)
        {
            int x=in.nextInt(),y=in.nextInt();
            array[i]=new toursist(i+1,x*a+y*b);
        }
        Arrays.sort(array);
        int c=0;
        StringBuilder s=new StringBuilder("");
        i=0;
       
        while (d>0&&i<n)
        {
            if(array[i].space<=d)
            {
                d-=array[i].space;
                c++;
                s.append(array[i].index+" ");

            }
            else break;
            i++;
        }
        out.println(c);
        String a1=s.toString();
        a1=a1.trim();
        out.println(a1);
	}
    class toursist implements Comparable<toursist>
    {
        int index,space;
        public toursist(int index,int space)
        {
            this.index=index;
            this.space=space;
        }
        public int compareTo(toursist a)
        {
            if(a.space>this.space)
                return -1;
            else if(a.space<this.space)
                return 1;
            else return 0;
        }
    }
}

