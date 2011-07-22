import java.io.*;
public class a1
{
public static void main(String args[])throws IOException
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader (isr);
String s=br.readLine();
int i,p=0;
for(i=0;i<s.length();i++)
{
if(s.charAt(i)=='.')
{
p=i;
break;
}}
String s1=s.substring(0,p);
String s2=s.substring(p+1,s.length()),ans="";
if(s1.charAt(s1.length()-1)=='9')
ans="GOTO Vasilisa.";
else
{
if((s2.charAt(0))>=53)
{
int t=s1.charAt(s1.length()-1)-48;
t=t+1;
ans=s1.substring(0,s1.length()-1)+Integer.toString(t);
}
else
ans=s1;
}
System.out.println(ans);
}
}

