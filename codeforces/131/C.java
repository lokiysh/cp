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
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt();
        int m=in.nextInt();
        int t=in.nextInt();
        long c=0;
        int i,j;
        for(i=4;i<=n;i++)
        {
            j=t-i;
            if(j>=1&&j<=m)
            c+=count_Combinations(n,i)*count_Combinations(m,j);
        }
        out.println(c);
	}
    public static long count_Combinations(int n, int k)
{
		if(n - k == 1 || k == 1)
			return n;

		long [][] b = new long[n+1][n-k+1];
		b[0][0] = 1;
		for(int i = 1; i < b.length; i++)
		{
			for(int j = 0; j < b[i].length; j++)
			{
				if(i == j || j == 0)
					b[i][j] = 1;
				else if(j == 1 || i - j == 1)
					b[i][j] = i;
				else
					b[i][j] = b[i-1][j-1] + b[i-1][j];
			}
		}
		return b[n][n-k];
}
}

