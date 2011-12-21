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
    int x,y;
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a=in.nextInt(),b=in.nextInt();
        this.x=a;
        this.y=b;
        int i=0;
        boolean status;
        while(true)
        {
           if(i%2==0)
           {
               status=ciel();
               if(!status)
               {
                   out.println("Hanako");
                   break;
               }
           }
            else
           {
               status=hanako();
               if(!status)
               {
                   out.println("Ciel");
                   break;
               }
           }
            i+=1;
        }
	}
    public boolean ciel()
    {
        if(x>=2&&y>=2)
        {
            x-=2;
            y-=2;
            return true;
        }
        if(x>=1&&y>=12)
        {
            x-=1;
            y-=12;
            return true;
        }
        if(y>=22)
        {
            y-=22;
            return true;
        }
        return false;
    }
    public boolean hanako()
    {
        if(y>=22)
        {
            y-=22;
            return true;
        }
        if(y>=12&&x>=1)
        {
            y-=12;
            x-=1;
            return true;
        }
        if(x>=2&&y>=2)
        {
            x-=2;
            y-=2;
            return true;
        }
        return false;
    }
}

