
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class d91
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i,j=0;
        int n=in.nextInt(),k=in.nextInt();
        String s=in.next();
        boolean status=false,st=false;
        char a[]=s.toCharArray();
        for(i=0;i<a.length-1;i++)
        {
            if(k==0)
            break;
            if(a[i]=='4'&&a[i+1]=='7')
            {
                if(i>=1&&a[i-1]=='4'&&i%2==1)
                {
                    if(k%2==0)
                    {
                        a[i]='4';
                    }else
                    a[i]='7';
                    break;
                }
                if(i%2==0)
                a[i+1]='4';
                else
                a[i]='7';
                k--;
            }
        }
        for(i=0;i<a.length;i++)
        System.out.print(a[i]);
        System.out.println();
            
        
        //out.println(s);
        out.flush();
    } 
}
