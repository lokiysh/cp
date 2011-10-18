
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class saratov_a
{
    public static void main(String args[])throws IOException
    {
        //Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter("output.txt");
        FileReader f=new FileReader("input.txt");
        
        
            Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i;
        String s=in.next();
        int n=in.nextInt();
        char ch;
        if(s.equals("front"))
        {
            if(n==1)
            ch='L';
            else
            ch='R';
        }
        else
        {
            if(n==1)
            ch='R';
            else
            ch='L';
        }
        out.println(ch);
    
        out.flush();
    } 
}
