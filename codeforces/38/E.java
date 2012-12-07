import java.io.*;
import java.util.*;
import java.math.*;
public class tester {
    public static void main(String args[])throws Exception {
        
        PrintWriter out = new PrintWriter(System.out);
        InputReader in=new InputReader(System.in);
        int n=in.nextInt(),i,j;
        Items a[]=new Items[n];
        for(i=0;i<n;i++)
        {
            a[i]=new Items(in.nextInt(),in.nextInt());
        }
        Arrays.sort(a);
        
        long pinned[]=new long [n];
        long optimal[]=new long[n];
        optimal[0]=pinned[0]=a[0].c;
        for(i=1;i<n;i++)
        {
            pinned[i]=optimal[i-1]+a[i].c;
            long min=Long.MAX_VALUE,d=0;
            for(j=i-1;j>=0;j--)
            {
                long k=i-j;
                d+=(i-j)*(a[j+1].x-a[j].x);
                min=Math.min(min,d+pinned[j]);
            }
            optimal[i]=Math.min(min,pinned[i]);
        }
        out.println(Math.min(optimal[n-1],pinned[n-1]));
        out.flush();
    }
}
    class Items implements Comparable<Items>
    {
        long x,c;
        public  Items(long x,long c) {
            this.x=x;
            this.c=c;
            
        }
        public int compareTo(Items a)
        {
            if(a.x<this.x)
                return 1;
            return -1;
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


    