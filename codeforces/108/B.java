import java.util.*;
public class b107
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int a[]=new int [n],i,j;
String out="NO";
for(i=0;i<n;i++)
a[i]=in.nextInt();
Arrays.sort(a);
for(i=1;i<n;i++)
{
if(a[i]>1)
if(a[i-1]*2>a[i])
{
if(a[i]!=a[i-1]){
out="YES";
break;
}}}
System.out.println(out);
}
}