
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class b94
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        int i,n,m,k,l;
        String s;
        n=in.nextInt();
        m=in.nextInt();
        int a[][]=new int[n][n],j;
        int count[]=new int[n],c=0;
        boolean status;
        Hashtable<Integer,ArrayList> h=new Hashtable<Integer,ArrayList>();
        for(i=0;i<m;i++)
        {
            k=in.nextInt();
            l=in.nextInt();
              a[k-1][l-1]=a[l-1][k-1]=1;
              count[k-1]+=1;
              count[l-1]+=1;
            }
            
            for(k=0;k<n;k++)
            {
                //status=true;
                ArrayList<Integer> al=new ArrayList<Integer>();
                al.clear();
                for(i=0;i<n;i++)
                {
                    if(count[i]==1)
                    al.add(i);
                }
                if(al.size()>=1)
                {
                    c++;
                    //System.out.println(al.size());
                for(i=0;i<al.size();i++)
                {
                    l=al.get(i);
                    status=false;
                    for(j=0;j<n;j++)
                    {
                        if(a[l][j]==1)
                        {
                            status=true;
                        break;}
                    }
                    if(status==true)
                    {
                    count[l]-=1;
                    count[j]-=1;
                    a[l][j]=a[j][l]=0;}
                }
            }
            else
            break;
            
        }
                    
            
    out.println(c);
                    
              
        

        out.flush();
    } 
}
