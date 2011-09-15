import java.util.*;
public class br87
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
int n,m,i,j,c=0;
boolean status;
n=in.nextInt();
m=in.nextInt();
String s;
char a[][]=new char[n][m];
for(i=0;i<n;i++)
{
s=in.next();
for(j=0;j<m;j++)
a[i][j]=s.charAt(j);
}
for(i=0;i<n;i++)
for(j=0;j<m;j++)
{
if(a[i][j]=='W')
{
status=false;
if(i-1>=0)
if(a[i-1][j]=='P')
{
a[i-1][j]='.';
status=true;
}
if(j-1>=0)
if(a[i][j-1]=='P'&&status==false)
{
a[i][j-1]='.';
status=true;
}
if(i+1<n)
if(a[i+1][j]=='P'&&status==false)
{
a[i+1][j]='.';
status=true;
}
if(j+1<m)
if(a[i][j+1]=='P'&&status==false)
{
a[i][j+1]='.';
status=true;
}
if(status==true)
c++;
}
}
System.out.println(c);
}}