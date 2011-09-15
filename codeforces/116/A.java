import java.util.*;
public class ar87
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
int n,i,a,b,c=0,max=0;
n=in.nextInt();
for(i=0;i<n;i++)
{
a=in.nextInt();
b=in.nextInt();
c=c+b-a;
max=Math.max(c,max);
}
System.out.println(max);
}
}