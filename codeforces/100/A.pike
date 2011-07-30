void main()
{
int n,k,n1;
string s;
s=Stdio.stdin->gets();
sscanf(s,"%d %d %d",n,k,n1);
if((n>n1&&k>=4)||(n==n1&&k>=1))
write("YES");
else
write("NO");
}
