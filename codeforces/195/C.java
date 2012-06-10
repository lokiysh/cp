import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.*;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Lokesh Khandelwal aka (codeKNIGHT | phantom11)
 */

public class TaskC {
    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(in.readLine());
        int i;
        int depth=0,tdepth=-1;
        String thro=null;
        for(i=0;i<n;i++)
        {
            String s=in.readLine().trim();
            if(s.startsWith("try"))
            {
                depth++;
            }
            else if(s.startsWith("throw"))
            {
                tdepth=depth;
                thro=s.substring(s.indexOf("(")+1,s.lastIndexOf(")")).trim();
            }
            else if(s.startsWith("catch"))
            {
                //System.out.println("hello");
                String s1=s.substring(s.indexOf("(")+1,s.lastIndexOf(")")).trim();
                String exception=s1.substring(0,s1.indexOf(",")).trim();
                String msg=s1.substring(s1.indexOf("\"")+1,s1.lastIndexOf("\""));
                //System.out.println(thro+" "+exception+" "+msg);
                if(thro!=null&&thro.equals(exception)&&tdepth>=depth)
                {
                    System.out.println(msg);
                    return;
                }
                if(tdepth==depth&&tdepth>=0)
                    tdepth--;
                depth--;
                
            }
            //System.out.println(i+" "+depth);
        }
        System.out.println("Unhandled Exception");
    }
}

