
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class a93
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i;
        String s;
        int n,k;
        double d=0;
        n=in.nextInt();
        k=in.nextInt();
        int x[]=new int[n];
        int y[]=new int[n];
        for(i=0;i<n;i++)
        {
            x[i]=in.nextInt();
            y[i]=in.nextInt();
        }
        for(i=0;i<n-1;i++)
        {
            d+=Math.sqrt(Math.pow((x[i]-x[i+1]),2)+Math.pow((y[i]-y[i+1]),2));
        }
        out.println((d*k)/50);

        out.flush();
    } 
}
