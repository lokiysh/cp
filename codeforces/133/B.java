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
        String s=in.next();
        char a[]={'>','<','+','-','.',',','[',']'};
        int i,j,mod=1000003;
        long k=0;
        for(i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            for(j=0;j<8;j++)
                if(ch==a[j])
                    break;
            k=(k*16)%mod;
            k+=j+8;
        }
        out.println(k);
	}
}

