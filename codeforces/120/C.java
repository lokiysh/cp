
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class saratov_c
{
    public static void main(String args[])throws IOException
    {
        //Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter("output.txt");
        FileReader f=new FileReader("input.txt");
            Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i,s=0;
        //String s;
        int n,k,p;
        n=in.nextInt();
        k=in.nextInt();
        int a[]=new int [n];
        for(i=0;i<n;i++)
        a[i]=in.nextInt();
        //Arrays.sort(a);
        for(i=0;i<n;i++)
        {
            p=0;
            while(a[i]>=k&&p<3)
            {
                a[i]=a[i]-k;
                p++;
            }
        }
        for(i=0;i<n;i++)
        s+=a[i];
        out.println(s);
        out.flush();
    } 
}
