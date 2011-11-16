
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class c82
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i,n,m,c0,d0,j,k;
        String s;
        n=in.nextInt();
        m=in.nextInt();
        c0=in.nextInt();
        d0=in.nextInt();
        int a[]=new int[m+1];
        int b[]=new int[m+1];
        int c[]=new int[m+1];
        int d[]=new int[m+1];
        for(i=1;i<=m;i++)
        {
            a[i]=in.nextInt();
            b[i]=in.nextInt();
            c[i]=in.nextInt();
            d[i]=in.nextInt();
        }
        int dp[][]=new int [n+1][m+1];
        for(i=0;i<n;i++)
        {
            dp[i][0]=0;
        }
        for(i=0;i<=n;i++)
        {
            for(j=1;j<=m;j++)
            {
                for(k=0;k<=a[j]/b[j];k++)
                {
                    if(i-c[j]*k>=0)
                    {
                        dp[i][j]=Math.max(dp[i][j],dp[i-c[j]*k][j-1]+(d[j]*k));
                    }
                }
            }
        }
        int ans=0;
        for(k=0;k<=n;k++)
        {
            ans=Math.max(ans,dp[k][m]+(n-k)/c0*d0);
        }
        out.println(ans);
        out.flush();
    } 
}
