
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class b
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i;
        
        String s1=in.next(),s="";
        

        int l=0,j;
        Hashtable h=new Hashtable();
        for(j=0;j<s1.length();j++)
        {
            if(s1.charAt(j)=='>')
            {
            s=s.substring(1,s.length());
            if(s.length()==1)
            {
                for(i=0;i<2*l;i++)
                System.out.print(" ");
                System.out.println("<"+s+">");
                l++;
            }
            else
            {
                l--;
                for(i=0;i<2*l;i++)
                System.out.print(" ");
                System.out.println("<"+s+">");
                
                
            }
            s="";
        }
        else
        s+=s1.charAt(j);
        }
        

        out.flush();
    } 
}
