import java.io.*;
import java.util.*;
import java.math.*;
public class tester {
    public static void main(String args[])throws Exception {
        
        PrintWriter out = new PrintWriter(System.out);
        InputReader in=new InputReader(System.in);
        //Scanner in=new Scanner(System.in);
        int i;
        //String s1=in.next(),s2=in.next(),s3=in.next();
        String a[]=new String []{"scissors","paper","rock"};
        int count[]=new int[3];
        String names[]=new String [3];
        for(i=0;i<3;i++)
        {
            names[i]=in.next();
            //System.out.print(names[i]);
        }
        
        for(i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                if(a[j].equals(names[i]))
                    count[j]++;
        }   
        
        char win[]=new char[]{'F','M','S'};
        boolean status=true;
        for(i=0;i<3;i++)
        {
            if(count[i]==1&&count[(i+1)%3]==2)
            {
                for(int j=0;j<3;j++)
                {
                    if(a[i].equals(names[j]))
                    {
                        out.println(win[j]);
                        status=false;
                    }
                }
            }
        }
        if(status)
        out.println("?");
        out.flush();
    }
}
    class InputReader
    {
        BufferedReader in;
        StringTokenizer tokenizer=null;

        public InputReader(InputStream inputStream)
        {
            in=new BufferedReader(new InputStreamReader(inputStream));
        }
        public String next()
        {
            try{
                while (tokenizer==null||!tokenizer.hasMoreTokens())
                {
                    tokenizer=new StringTokenizer(in.readLine());
                }
                return tokenizer.nextToken();
            }
            catch (IOException e)
            {
                return null;
            }
        }
        public int nextInt()
        {
            return Integer.parseInt(next());
        }
    }


    