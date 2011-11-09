
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class b93
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
        int n=in.nextInt();
        int a[]=new int[n];
        int count[]=new int [100];
        int pairs=0;
        for(i=0;i<n;i++)
        a[i]=in.nextInt();
        for(i=0;i<n;i++)
        {
            count[a[i]-1]+=1;
        }
            for(i=0;i<100;i++)
            {
                pairs+=count[i]/2;
            }
            out.println(pairs/2);
        

        out.flush();
    } 
}
