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
        int n=in.nextInt();
        int rooms[][]=new int[n][3];
        int i;
        for(i=0;i<n;i++)
        {
            rooms[i][0]=in.nextInt();
            rooms[i][1]=in.nextInt();
            rooms[i][2]=in.nextInt();
        }
        int m=in.nextInt();
        int wall[][]=new int[m][3];
        for(i=0;i<m;i++)
        {
            wall[i][0]=in.nextInt();
            wall[i][1]=in.nextInt();
            wall[i][2]=in.nextInt();
        }
        int p,max=0,j,k,number,sum=0,cuts,area;
        double t;
        for(i=0;i<n;i++)
        {
            p=2*(rooms[i][0]+rooms[i][1]);
            //area=(rooms[i][0]+rooms[i][1])*rooms[i][2]*2;
            max=Integer.MAX_VALUE;
            for(j=0;j<m;j++)
            {
                cuts=wall[j][0]/rooms[i][2];
                if(cuts==0)
                    continue;
                number=(int)Math.ceil((double )p/(double )(wall[j][1]*cuts));
                if(number*wall[j][2]<max)
                    max=number*wall[j][2];
            }

             sum+=max;
        }
        out.println(sum);
	}
}

