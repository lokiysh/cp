
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class saratov_e
{
    public static void main(String args[])throws IOException
    {
        //Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter("output.txt");
        FileReader f=new FileReader("input.txt");
            Scanner in=new Scanner(f);
        int t=in.nextInt();
        int i,n;
        String s;
        for(i=0;i<t;i++)
        {
            n=in.nextInt();
            if(n%2==0)
            out.println(1);
            else
            out.println(0);
        }

        out.flush();
    } 
}
