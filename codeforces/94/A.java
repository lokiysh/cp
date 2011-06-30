import java.util.*;
public class a94
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
String s=in.next();
String a[]=new String[10];
int i,j;
for(i=0;i<10;i++)
{
a[i]=in.next();
}
String out="",s1;
for(i=0;i<80;i+=10)
{
s1=s.substring(i,i+10);
for(j=0;j<10;j++)
{
if(s1.equals(a[j])==true)
out+=Integer.toString(j);
}
}
System.out.println(out);
}}