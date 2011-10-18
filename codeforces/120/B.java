
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class saratov_b
{
    public static void main(String args[])throws IOException
    {
        //Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter("output.txt");
        //PrintWriter out=new PrintWriter(System.out);
        FileReader f=new FileReader("input.txt");
          Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i;
        String s;
        int n,k;
        n=in.nextInt();
        k=in.nextInt();
        int a[]=new int [n+1];
        for(i=1;i<=n;i++)
        {
            a[i]=in.nextInt();
        }
        
        while(a[k]!=1)
        {
            k++;
            if(k==n+1)
            k=1;
        }
        out.println(k);
        

        out.flush();
    } 
}
