
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class b91
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i;
        String s=in.next();
        int f=0,se=0;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='4')
            f++;
            else if(s.charAt(i)=='7')
            se++;
        }
        if(f==0&&se==0)
        out.println(-1);
        else if(se>f)
        out.println(7);
        else out.println(4);
            

        out.flush();
    } 
}
