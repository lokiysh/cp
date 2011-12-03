
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class b1
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i,j;
        String s=in.next(),ans="";
        char a[]={'>','<','+','-','.',',','[',']'},ch;
        long l=(s.length()-1)*4,m=0,t=1000003;
        long k=0;
        BigInteger b=BigInteger.valueOf(1),mod=BigInteger.valueOf(1000003);
       // System.out.println(1<<40);
        for(i=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            for(j=0;j<8;j++)
            {
                if(a[j]==ch)
                break;
            }
            ans+=Integer.toBinaryString(j+8);
        }
       // System.out.println(ans);
        for(i=ans.length()-1;i>=0;i--)
        {
            if(ans.charAt(i)=='1')
            {
                b=BigInteger.valueOf(1);
                b=b.shiftLeft(ans.length()-1-i);
                b=b.mod(mod);
                m=b.longValue();
                //System.out.println(d);
                k=(k+m)%t;
            }
        }
        //out.println(ans);
        out.println(k);
        out.flush();
    } 
}
