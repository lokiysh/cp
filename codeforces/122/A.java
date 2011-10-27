
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class a91
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i,c=0;
        String s;
        s=in.next();
        int n=Integer.parseInt(s);
        int a[]={4,7,44,47,74,77,444,447,474,477,744,747,774,777};
        boolean status=false;
        for(i=0;i<a.length;i++)
        {
            if(n%a[i]==0)
            status=true;
    }
    if(status==true)
    System.out.println("YES");
    else
    System.out.println("NO");
}
    
}
