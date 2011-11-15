
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class a94
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i,n,even=0,odd=0,k;
        String s;
        n=in.nextInt();
        for(i=0;i<n;i++)
        {
            k=in.nextInt();
            if(k%2==0)
            even++;
        }
        odd=n-even;
        if(odd%2==1)
        out.println(odd);
        else
        out.println(even);

        out.flush();
    } 
}
