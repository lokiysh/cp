import java.util.*;
import java.io.*;
public class arrayquerry
{
 static public void main(String args[])
 {
     Scanner in=new Scanner(System.in);
     PrintWriter out=new PrintWriter(System.out);
     int n=in.nextInt();
     int m=in.nextInt();
     int a[]=new int[n];
     int i,count1=0,count2=0;
     for(i=0;i<n;i++)
     
         a[i]=in.nextInt();
         for(i=0;i<n;i++)
         {
         if(a[i]==1)
         count1++;
         else 
         count2++;
        }
     
     for(i=0;i<m;i++)
     {
         int l=in.nextInt();
         int r=in.nextInt();
         int t=r-l;
         if(t==0)
         {
             out.println(0);
             continue;
         }
         if((t+1)%2!=0)
         out.println(0);
         else if((t+1)%2==0)
         {
             if(((t+1)/2)<=count1&&((t+1)/2)<=count2)
             out.println(1);
             else
             out.println(0);
            }
        }
        out.flush();
    }
}