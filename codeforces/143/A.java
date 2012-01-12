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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
   int r1=in.nextInt(),r2=in.nextInt(),c1=in.nextInt(),c2=in.nextInt(),d1=in.nextInt(),d2=in.nextInt(),i,j=1,k=1,l=1;
boolean status=false;
for(i=1;i<10;i++)
for(j=1;j<10;j++)
for(k=1;k<10;k++)
for(l=1;l<10;l++)
{
    if(i==j||i==k||i==l||j==k||j==l||k==l)
        continue;
    if(((i+j)==r1)&&((k+l)==r2)&&((i+k)==c1)&&((j+l)==c2)&&((i+l)==d1)&&((j+k)==d2))
    {
    status=true;
        out.println(i+" "+j);
out.println(k+" "+l);
        return;
    //break;
    }
    }
        
if(status)
{
out.println(i+" "+j);
out.println(k+" "+l);
}
else
out.println(-1);


	}
}

