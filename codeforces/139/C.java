import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt(),k=in.nextInt(),i,j,c=0;
        String s,s1,s2,s3,res,a[]=new String[n];
        boolean status=true;
        for(i=0;i<n;i++)
        {
            s=in.next();
            s1=in.next();
            s2=in.next();
            s3=in.next();
            c=0;
            for(j=s.length()-1;j>=0;j--)
            {
                if(s.charAt(j)=='a'||s.charAt(j)=='e'||s.charAt(j)=='i'||s.charAt(j)=='o'||s.charAt(j)=='u')
                    c++;
                if(c==k)
                    break;
            }
            if(c<k)
            {
                status=false;
                break;
            }
            s=s.substring(j,s.length());
            c=0;
            for(j=s1.length()-1;j>=0;j--)
            {
                if(s1.charAt(j)=='a'||s1.charAt(j)=='e'||s1.charAt(j)=='i'||s1.charAt(j)=='o'||s1.charAt(j)=='u')
                    c++;
                if(c==k)
                    break;
            }
            if(c<k)
            {
                status=false;
                break;
            }
            s1=s1.substring(j,s1.length());
            c=0;
            for(j=s2.length()-1;j>=0;j--)
            {
                if(s2.charAt(j)=='a'||s2.charAt(j)=='e'||s2.charAt(j)=='i'||s2.charAt(j)=='o'||s2.charAt(j)=='u')
                    c++;
                if(c==k)
                    break;
            }
            if(c<k)
            {
                status=false;
                break;
            }
            s2=s2.substring(j,s2.length());
            c=0;
            for(j=s3.length()-1;j>=0;j--)
            {
                if(s3.charAt(j)=='a'||s3.charAt(j)=='e'||s3.charAt(j)=='i'||s3.charAt(j)=='o'||s3.charAt(j)=='u')
                    c++;
                if(c==k)
                    break;
            }
            if(c<k)
            {
                status=false;
                break;
            }
            s3=s3.substring(j,s3.length());
            //System.out.println(s+" "+s1+" "+s2+" "+s3);
            if(s.equals(s1)&&s.equals(s2)&&s.equals(s3))
                res="aaaa";
            else if(s.equals(s1)&&s2.equals(s3))
                res="aabb";
            else if(s.equals(s2)&&s1.equals(s3))
                res="abab";
            else if(s.equals(s3)&&s1.equals(s2))
                res="abba";
            else
            {
                status=false;
                break;
            }
            a[i]=res;
        }
        if(!status)
        out.println("NO");
        else
        {
            Arrays.sort(a);
            res=a[n-1];
            for(i=0;i<n-1;i++)
            {
                if(a[i].equals(res)||a[i].equals("aaaa"))
                    continue;
                else
                {
                    status=false;
                    break;
                }
            }
            if(!status)
                out.println("NO");
            else
                out.println(res);
        }
	}
}

