import java.util.*;
public class a
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
int n=in.nextInt()-10;
int a[]={1,2,3,4,5,6,7,8,9,10,10,10,10,11};
int i,c=0;
for(i=0;i<a.length;i++)
{
if(a[i]==n)
{
if(i==11)
c=c+3;
else
c=c+4;
}
}
System.out.println(c);
}}