import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        boolean minus=false;
        String s=in.next();
        if(s.startsWith("-"))
        {
            minus=true;
            s=s.substring(1,s.length());
        }
        int j;
        boolean p=false;
        for(j=0;j<s.length();j++)
            if(s.charAt(j)=='.')
               p=true;
        String Int="",point="";
        if(p)
        {Int=s.substring(0,s.indexOf("."));
        point=s.substring(s.indexOf(".")+1,s.length());
        }
        else
        {
            Int=s;
        }
        while (point.length()<2)
            point=point+"0";
        point=point.substring(0,2);
        int i,c=0;
        String res="";
        for(i=Int.length()-1;i>=0;i--)
        {
            c++;

            res = Int.charAt(i)+res;
            if(c==3)
            {
                c=0;
                res=","+res;
            }
        }
        if(res.startsWith(","))
            res=res.substring(1,res.length());
        res+="."+point;
        res="$"+res;
        if(minus)
        {
            res = res+")";
            res="("+res;
        }

        out.println(res);
	}
}

