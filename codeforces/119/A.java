
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class a90
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
        int a,b,n;
        a=in.nextInt();
        b=in.nextInt();
        n=in.nextInt();
        i=0;
        while(n>0)
        {
            if(i%2==0)
            n=n-gcd(a,n);
            else
            n=n-gcd(b,n);
            i++;
        }
        out.println((i-1)%2);
        out.flush();
    } 
    public static int gcd(int a,int b)
    {
        if(b==0)
        return a;
        else
        return gcd(b,a%b);
    }
}
