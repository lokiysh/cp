import java.util.*;
import java.math.*;
import java.io.*;

public class nuts 
{
    public static void main(String args[])throws Exception
    {
        Scanner in=new Scanner(System.in);
       
        PrintWriter out=new PrintWriter(System.out);
     
        int t,i; long sum=0;
        t=in.nextInt();
        int a[]=new int[t];
        for(i=0;i<t;i++)
        a[i]=in.nextInt();
        sum=t+t-1+a[0];
        for(i=1;i<t;i++)
        {
            sum+=Math.abs(a[i-1]-a[i]);
            }
            System.out.println(sum);
            }
            }