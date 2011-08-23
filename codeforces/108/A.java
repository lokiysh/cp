import java.util.*;
public class a107
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
String s=in.next(),out;
String s1=s.substring(0,2);
String s2=s.substring(3,5),s3="";
int i;
for(i=s1.length()-1;i>=0;i--)
s3=s3+s1.charAt(i);
int b=Integer.parseInt(s3);
int a=Integer.parseInt(s1);
int c=Integer.parseInt(s2);
if(a<5)
{
if(c>=b)
{
a=a+1;
s1="";
if(a<10)
s1="0"+Integer.toString(a);
else
s1=Integer.toString(a);
s3="";
for(i=s1.length()-1;i>=0;i--)
s3=s3+s1.charAt(i);
out=s1+":"+s3;
}
else
out=s1+":"+s3;
}
else if(a<10)
out="10:01";
else if(a==10 &&c==0)
out="10:01";

else if(a<15)
{
if(c>=b)
{
a=a+1;
s1="";
if(a<10)
s1="0"+Integer.toString(a);
else
s1=Integer.toString(a);
s3="";
for(i=s1.length()-1;i>=0;i--)
s3=s3+s1.charAt(i);
out=s1+":"+s3;
}
else
out=s1+":"+s3;
}
else if(a==15&&c<=50)
out="15:51";
else if(a<=19)
out="20:02";
else if(a==20&&c<2)
out="20:02";
else if(a>=20&&a<23)
{if(c>=b)
{
a=a+1;
s1="";
s1=Integer.toString(a);
s3="";
for(i=s1.length()-1;i>=0;i--)
s3=s3+s1.charAt(i);
out=s1+":"+s3;
}
else
out=s1+":"+s3;
}
else if(a==23&&c<32)
out="23:32";
else
out="00:00";
System.out.println(out);
}
}