import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
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
        String s=in.next();
        int a[][]=new int[26][s.length()];
        int i,j;
        int freq[]=new int[26];

        for(i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            a[index][freq[index]]=i;
            freq[index]++;
        }
        //String res="";
        boolean status=false;
        StringBuilder res=new StringBuilder("");
        int last=0;

                for(i=25;i>=0;i--)
                {
                    if(freq[i]==0)
                        continue;
                    if(freq[i]>0&&!status)
                    {
                        status=true;
                        for(j=0;j<freq[i];j++)
                            res.append((char )(i+97));
                        last=a[i][freq[i]-1];
                        continue;
                    }
                    boolean done=false;
                    for(j=freq[i]-1;j>=0;j--)
                    {
                        if(a[i][j]>last)
                        {
                            res.append((char )(i+97));
                            done=true;
                        }
                        else break;
                    }
                    if(done)
                    last=a[i][freq[i]-1];
                    //System.out.println(res);
                }
               out.println(res);
	}
}

