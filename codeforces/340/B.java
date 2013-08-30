import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Lokesh Khandelwal
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    double distance[][];
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt(),i,j,k;
        int x[]=new int[n],y[]=new int[n];
        for(i=0;i<n;i++) {
            x[i]=in.nextInt();
            y[i]=in.nextInt();
        }
        distance=new double[n][n];
        for(i=0;i<n;i++) {
            for(j=i+1;j<n;j++) {
                distance[i][j] = distance[j][i] = Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
            }
        }
        double maxArea = 0;
        for(i=0;i<n;i++) {
            for(j=i+1;j<n;j++) {
//                double a=0,b=0,c=0,den=1;
//                if(x[i] == x[j]) {
//
//                }
//                else  {
//                    double m= (y[i] -y[j])/(x[i]-x[j]);
//                    a = m;
//                    b = -1;
//                    c = y[i]-m*x[i];
//                    den = Math.sqrt(1+m*m);
//                }
//                double maxUpper = 0,maxLower = 0;
//                for(k=1;k<n;k++) {
//                    if(k==i||k==j) continue;
//                    int p = direction(x[i],x[j],x[k],y[i],y[j],y[k]);
//                    if(p>0) {
//                        maxUpper = Math.max(maxUpper,Math.abs(a*x[k]+b*y[k]+c));
//                    }
//                    else if(p<0) {
//                        maxLower = Math.max(maxLower,Math.abs(a*x[k]+b*y[k]+c));
//                    }
//                    //if(i==0&&j==3) DebugUtils.print(maxUpper,maxLower,a,b,c);
//                }
//                maxLower/=den;
//                maxUpper/=den;
//                double dist = Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
//                maxArea = Math.max(maxArea,((maxLower+maxUpper)*dist)/2.0);
//                //DebugUtils.print(i,j,maxArea);
                double maxUpper = 0 , maxLower = 0;
                for(k=0;k<n;k++) {
                    if(k==i||k==j) continue;
                    int p = direction(x[i],x[j],x[k],y[i],y[j],y[k]);
                    if(p>0)
                        maxUpper=Math.max(maxUpper,area(i,j,k));
                    else if(p<0)
                        maxLower=Math.max(maxLower,area(i,j,k));
                }
                if(maxUpper>0&&maxLower>0)
                    maxArea=Math.max(maxArea,maxLower+maxUpper);
                //DebugUtils.print(i,j,k,maxArea);
            }
        }
        out.printLine(maxArea);
    }
    public int direction(int x1,int x2,int x3,int y1,int y2,int y3)
    {
        return (x3-x1)*(y2-y1)-(x2-x1)*(y3-y1);
    }
    public double area(int i,int j,int k) {
        double a = distance[i][j];
        double b = distance[i][k];
        double c = distance[k][j];
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}

class InputReader
{
    BufferedReader in;
    StringTokenizer tokenizer=null;

    public InputReader(InputStream inputStream)
    {
        in=new BufferedReader(new InputStreamReader(inputStream));
    }
    public String next()
    {
        try{
            while (tokenizer==null||!tokenizer.hasMoreTokens())
            {
                tokenizer=new StringTokenizer(in.readLine());
            }
            return tokenizer.nextToken();
        }
        catch (IOException e)
        {
            return null;
        }
    }
    public int nextInt()
    {
        return Integer.parseInt(next());
    }
    }

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object...objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}
}

