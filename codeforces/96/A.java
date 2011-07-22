import java.io.*;
public class football
{
public static void main(String args[])throws IOException
{
InputStreamReader isr=new InputStreamReader (System.in);
BufferedReader br=new BufferedReader(isr);
String s=br.readLine(),s1,ans="NO";
int i;
int l=s.length();
for(i=0;i<l-6;i++)
{
s1=s.substring(i,i+7);
if(s1.equals("0000000")==true||s1.equals("1111111")==true)
{
ans="YES";
break;
}
}
System.out.println(ans);
}
}
