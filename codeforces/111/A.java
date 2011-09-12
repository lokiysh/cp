import java.util.Scanner;
public class c111
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
long n,x,y,a,s,i;
n=in.nextLong();
x=in.nextLong();
y=in.nextLong();
a=y-n+1;
s=a*a+n-1;
if(a<1||s<x)
{
System.out.println("-1");
return;
}
else
{
System.out.println(a);
for(i=0;i<n-1;i++)
System.out.println("1");
}
}
}