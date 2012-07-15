import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    int n,m,a[][];
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        n=in.nextInt();
        m=in.nextInt();
        int i,j,c=0;
        a=new int[n][m];
        int x[]=new int[2];
        int y[]=new int[2];
        for(i=0;i<n;i++)
        {
            String s=in.next();
            for(j=0;j<m;j++)
            {
                if(s.charAt(j)=='#')
                {
                    a[i][j]=-1;
                    if(c<2)
                    {
                        x[c]=i;
                        y[c]=j;
                    }
                    c++;
                }
            }
        }
        if(c<3)
        {
            out.println(-1);
            return;
        }
        boolean status=false;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(a[i][j]==-1)
                {
                    boolean visited[][]=new boolean[n][m];
                    a[i][j]=0;
                    if(i==x[0]&&j==y[0])
                    dfs(x[1],y[1],visited);
                    else dfs(x[0],y[0],visited);
                    boolean stat1=true;
                    for(int p=0;p<n;p++)
                        for(int q=0;q<m;q++)
                            if(a[p][q]==-1&&!visited[p][q])
                                stat1=false;
                    a[i][j]=-1;
                    if(!stat1)
                    {
                        status=true;

                        break;
                    }
                }
            }
            if(status)
                break;
        }
        if(status)
            out.println(1);
        else out.println(2);
	}
    int dx[]={-1,0,1,0};
    int dy[]={0,1,0,-1};
    public void dfs(int x,int y,boolean visited[][])
    {
        if(a[x][y]!=-1)
        {
            return;
        }

            for(int i=0;i<4;i++)
            {
                if(isInGraph(x+dx[i],y+dy[i]))
                    if(!visited[x+dx[i]][y+dy[i]])
                    {
                        visited[x+dx[i]][y+dy[i]]=true;
                        dfs(x+dx[i],y+dy[i],visited);
                    }
            }
        }
    public boolean isInGraph(int x,int y)
    {
        if(x>=0&&x<n&&y>=0&&y<m)
            return true;
        return false;
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

