import java.util.Scanner;
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
    public static void main(String[] args1) throws IOException{
        
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i;
            int n=Integer.parseInt(br.readLine()),m,k,j;
            //System.out.println(n);

        String temps[][]=new String[n][60];
        int args[]=new int[n];
        //String dem=",|(|)|";
        for(i=0;i<n;i++)
        {

            StringTokenizer st=new StringTokenizer(br.readLine().trim(),",() +");
            String s[]=new String[100];
            int p=0;
            while(st.hasMoreTokens())
            {
                s[p++]=st.nextToken();
                //System.out.println(s[p-1]);
            }
            //String s[]=(in.next().trim()).split("");
            int arg=0;
            //System.out.println(p);
            for(j=0;j<p;j++)
            {
                //System.out.print(s[j]+" ");
                //if(s[j].equals("(")||s[j].equals(")")||s[j].equals(",")||s[j].equals("void"))
                  //  continue;
                if(s[j].equals("void"))
                    continue;
                temps[i][arg++]=s[j];
                //System.out.print(temps[i][arg-1]+" ");
            }
            //System.out.println();
            args[i]=arg-1;
        }
        m=Integer.parseInt(br.readLine());
        String var[][]=new String[m][2];
        for(i=0;i<m;i++)
        {
            //String s[]=(in.next().trim()).split("[\\s,()]+");
            StringTokenizer st=new StringTokenizer(br.readLine().trim(),",() +");
            String s[]=new String[100];
            int p=0;
            while(st.hasMoreTokens())
                s[p++]=st.nextToken();
            var[i][0]=s[1];
            var[i][1]=s[0];
        }
        k=Integer.parseInt(br.readLine());
        String func[][]=new String[k][60];
        int argfunc[]=new int[k];
        for(i=0;i<k;i++)
        {
            //String s[]=(in.next().trim()).split("[\\s,()]+");
            StringTokenizer st=new StringTokenizer(br.readLine().trim(),",() +");
            String s[]=new String[100];
            int p=0;
            while(st.hasMoreTokens())
                s[p++]=st.nextToken();
            int arg=0;
            for(j=0;j<p;j++)
            {
                if(s[j].equals("(")||s[j].equals(")")||s[j].equals(",")||s[j].equals("void"))
                    continue;
                func[i][arg++]=s[j];
            }
            argfunc[i]=arg-1;
            for(j=1;j<arg;j++)
            {
                for(p=0;p<m;p++)
                {
                    if(var[p][0].equals(func[i][j]))
                    {
                        func[i][j]=var[p][1];
                        break;
                    }
                }
            }
        }
        for(i=0;i<k;i++)
        {
            int c=0;

            for(j=0;j<n;j++)
            {
                if(argfunc[i]==args[j]&&func[i][0].equals(temps[j][0]))
                {
                    boolean status=true;

                    for(int p=1;p<args[j]+1;p++)
                    {
                        if(!(temps[j][p].equals("T")||func[i][p].equals(temps[j][p])))
                            status=false;
                    }
                    if(status)
                        c++;
                }
            }
            System.out.println(c);
        }
        }
        
}

