import java.io.*;
public class a
{
public static void main(String args[])throws IOException
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);
String s=br.readLine();
int i,counter=0,sum;
while(s.length()>1)
{
sum=0;
for(i=0;i<s.length();i++)
{
sum=sum+(s.charAt(i)-48);
}
counter++;
s=Integer.toString(sum);
}
System.out.println(counter);
}}