    import java.io.*;
    public class pass1
    {
    public static void main(String args[])throws IOException
    {
    InputStreamReader isr=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(isr);
    String pass=br.readLine();
    String s1,a[]=new String[10],out="";
    int i,j;
    for(i=0;i<10;i++)
    a[i]=br.readLine();
    for(i=0;i<80;i+=10)
    {
    s1=pass.substring(i,i+10);
    for(j=0;j<10;j++)
    {
    if(s1.equals(a[j])==true)
    {out=out+Integer.toString(j);
    break;}}
    }
    System.out.println(out);
    }}