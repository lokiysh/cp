import java.util.*;
public class b111
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int x=in.nextInt();
int y=in.nextInt();
String out="YES";
if(n==2)
out="NO";
else if((x==n/2||x==n/2+1)&&(y==n/2||y==n/2+1))
out="NO";
System.out.println(out);
}
}