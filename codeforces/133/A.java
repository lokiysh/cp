
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
        int i;
        String s=in.next();
        boolean status=false;
        char ch;
        for(i=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            if(ch=='H'||ch=='Q'||ch=='9')
            {
                status=true;
                break;
            }
        }
        if(status)
        out.println("YES");
        else
        out.println("NO");
        out.flush();
    } 
}
