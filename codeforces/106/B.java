import java.util.*;
public class b106
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
int n=in.nextInt();
int a[][]=new int[n][4];
int i,j,p=0;
int out[]=new int [n];
for(i=0;i<n;i++)
out[i]=1;
for(i=0;i<n;i++)
{
for(j=0;j<4;j++)
a[i][j]=in.nextInt();
}
int s=a[0][0];
int r=a[0][1],h=a[0][2],c=a[0][3];
boolean status;
for(i=0;i<n-1;i++)
{
for(j=i+1;j<n;j++)
{

if(a[i][0]>a[j][0]&&a[i][1]>a[j][1]&&a[i][2]>a[j][2])
{
out[j]=0;
}

else if(a[i][0]<a[j][0]&&a[i][1]<a[j][1]&&a[i][2]<a[j][2])
{
out[i]=0;
}
}}
p=0;int min=99999;status=true;
for(i=0;i<n;i++)
{
if(out[i]==1)
{
if(status==true)
{
status=false;
min=a[i][3];
p=i+1;
}
else if(a[i][3]<min)
{min=a[i][3];p=i+1;}}}
System.out.println(p);
}}