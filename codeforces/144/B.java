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
        int xa,xb,ya,yb,r,c=0,i,j;
        xa=in.nextInt();
        ya=in.nextInt();
        xb=in.nextInt();
        yb=in.nextInt();
        r=in.nextInt();
        int min=Math.min(ya,yb),max=Math.max(ya,yb);
        int xmax=Math.max(xa,xb),xmin=Math.min(xa,xb);
        int gen[][]=new int[2*(max-min+1)+2*(xmax-xmin-1)][2];

        int k=0;
        for(i=min;i<=max;i++)
        {
            gen[k][0]=xa;
            gen[k][1]=i;
            k++;
        }
        for(i=min;i<=max;i++)
        {
            gen[k][0]=xb;
            gen[k][1]=i;
            k++;
        }
        int p=2*(max-min+1);
        min=Math.min(xa,xb);
        max=Math.max(xa,xb);
        for(i=min+1;i<max;i++)
        {
            gen[k][0]=i;
            gen[k][1]=ya;
            k++;
        }
        for(i=min+1;i<max;i++)
        {
            gen[k][0]=i;
            gen[k][1]=yb;
            k++;
        }
        int ra;
        
        boolean status[]=new boolean[gen.length];
        for(i=0;i<r;i++)
        {
            xa=in.nextInt();
            ya=in.nextInt();
            ra=in.nextInt();
            for(j=0;j<gen.length;j++)
            {
                if(!status[j])
                {
                    //System.out.print(gen[j][0]+" "+gen[j][1]+" "+Math.pow(gen[j][0]-xa,2)+Math.pow(gen[j][1]-ya,2)+" "+(ra+1e-8));
                    if(Math.sqrt(Math.pow(gen[j][0]-xa,2)+Math.pow(gen[j][1]-ya,2))<=(double)(ra+1e-8))
                    {
                        status[j]=true;
                    }
                }
                //System.out.print(status[j]);
            }
            //System.out.println();
        }
        for(i=0;i<status.length;i++)
        {
            if(!status[i])
                c++;
            //System.out.println(status[i]);
        }
        out.println(c);

	}
}

