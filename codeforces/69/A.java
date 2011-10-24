/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class physics
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        int t=in.nextInt();
        int i,xs=0,ys=0,zs=0;
        String s;
        for(i=0;i<t;i++)
        {
            xs+=in.nextInt();
            ys+=in.nextInt();
            zs+=in.nextInt();
        }
        if(xs==0&&ys==0&&zs==0)
        s="YES";
        else
        s="NO";
        out.println(s);
        

        out.flush();
    } 
}
