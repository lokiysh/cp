import java.util.*;
public class a111
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
String s1=in.next();
String s2=in.next();
int out;
s1=s1.toUpperCase();
s2=s2.toUpperCase();
if(s1.compareTo(s2)>0)
out=1;
else if(s1.compareTo(s2)<0)
out=-1;
else
out=0;
System.out.println(out);
}
}