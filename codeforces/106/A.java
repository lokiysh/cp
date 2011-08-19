import java.util.*;
public class a106
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
String s=in.next();
char c=s.charAt(0);
char a[]={'6','7','8','9','T','J','Q','K','A'};
s=in.next();
int i,p=0,q=0;
char a1=s.charAt(0);
char c1=s.charAt(1);
for(i=0;i<a.length;i++)
{
if((int)a1==(int)a[i])
{p=i;
break;
}}
s=in.next();
char a2=s.charAt(0);
char c2=s.charAt(1);
for(i=0;i<a.length;i++)
if((int)a2==(int)a[i]){
q=i;break;}
String out="";

if((int)c1==(int)c2)
{
if(p>q)
out="YES";
else 
out="NO";
}
else if(c1==c)
out="YES";
else
out="NO";
System.out.println(out);
}

}