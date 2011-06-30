import java.util.*;
public class b94
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
int n=in.nextInt(),i,a1,b,max,min;
int a[][]=new int[5][5];
for(i=0;i<n;i++)
{
a1=in.nextInt();
b=in.nextInt();
max=Math.max(a1,b);
min=Math.min(a1,b);
a[max-1][min-1]=1;
}
String out="FAIL";
int c3=0,c4=0;
if(a[3][0]==a[3][1]&&a[3][1]==a[1][0]||a[3][1]==a[3][2]&&a[3][2]==a[2][1]||a[3][0]==a[3][2]&&a[3][2]==a[2][0]||a[2][0]==a[2][1]&&a[2][1]==a[1][0])
out="WIN";
else if(a[4][0]==a[4][1]&&a[4][1]==a[1][0]||a[4][1]==a[4][2]&&a[4][2]==a[2][1]||a[4][2]==a[4][3]&&a[4][3]==a[3][2]||a[4][0]==a[4][2]&&a[4][2]==a[2][0]||a[4][0]==a[4][3]&&a[4][3]==a[3][0]||a[4][1]==a[4][3]&&a[4][3]==a[3][1])
out="WIN";
System.out.println(out);
}
}