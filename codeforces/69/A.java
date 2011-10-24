import java.util.*;
public class Main
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int i,j,x[]=new int[n],y[]=new int[n],z[]=new int[n],xs=0,ys=0,zs=0;
for(i=0;i<n;i++)
{
xs+=in.nextInt();
ys+=in.nextInt();
zs+=in.nextInt();
}
if(xs==0&&ys==0&&zs==0)
System.out.println("YES");
else System.out.println("NO");
}
}