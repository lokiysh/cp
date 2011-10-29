
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class a
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int n=in.nextInt();
        int i=n/3;
        int rem=n%3;
        if(rem==2)
        i=i+1;
        int f=i/12;
        i=i%12;
        out.println(f+" "+i);
        out.flush();
    } 
}
