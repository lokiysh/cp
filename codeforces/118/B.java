
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class b89
{
    public static void main(String args[])//throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        int n=in.nextInt();
        int i;
        String s;
        if(n==2)
        {
        out.println("    0");
        out.println("  0 1 0");
        out.println("0 1 2 1 0");
        out.println("  0 1 0");
        out.println("    0");
    }
    else if (n==3)
    {
        out.println("      0");
        out.println("    0 1 0");
        out.println("  0 1 2 1 0");
        out.println("0 1 2 3 2 1 0");
        out.println("  0 1 2 1 0");
        out.println("    0 1 0");
        out.println("      0");
    }
    else if (n==4)
    {
        out.println("        0");
        out.println("      0 1 0");
        out.println("    0 1 2 1 0");
        out.println("  0 1 2 3 2 1 0");
        out.println("0 1 2 3 4 3 2 1 0");
        out.println("  0 1 2 3 2 1 0");
        out.println("    0 1 2 1 0");
        out.println("      0 1 0");
        out.println("        0");
    }
    else if(n==5)
    {
        out.println("          0");
        out.println("        0 1 0");
        out.println("      0 1 2 1 0");
        out.println("    0 1 2 3 2 1 0");
        out.println("  0 1 2 3 4 3 2 1 0");
        out.println("0 1 2 3 4 5 4 3 2 1 0");
        out.println("  0 1 2 3 4 3 2 1 0");
        out.println("    0 1 2 3 2 1 0");
        out.println("      0 1 2 1 0");
        out.println("        0 1 0");
        out.println("          0");
    }
    else if (n==6)
    {
        out.println("            0");
       out.println("          0 1 0");
        out.println("        0 1 2 1 0");
        out.println("      0 1 2 3 2 1 0");
        out.println("    0 1 2 3 4 3 2 1 0");
        out.println("  0 1 2 3 4 5 4 3 2 1 0");
        out.println("0 1 2 3 4 5 6 5 4 3 2 1 0");
       out.println("  0 1 2 3 4 5 4 3 2 1 0");
        out.println("    0 1 2 3 4 3 2 1 0");
        out.println("      0 1 2 3 2 1 0");
        out.println("        0 1 2 1 0");
        out.println("          0 1 0");
        out.println("            0");
    }
    else if (n==7)
    {
        out.println("              0");
        out.println("            0 1 0");
        out.println("          0 1 2 1 0");
        out.println("        0 1 2 3 2 1 0");
        out.println("      0 1 2 3 4 3 2 1 0");
        out.println("    0 1 2 3 4 5 4 3 2 1 0");
        out.println("  0 1 2 3 4 5 6 5 4 3 2 1 0");
        out.println("0 1 2 3 4 5 6 7 6 5 4 3 2 1 0");
        out.println("  0 1 2 3 4 5 6 5 4 3 2 1 0");
        out.println("    0 1 2 3 4 5 4 3 2 1 0");
        out.println("      0 1 2 3 4 3 2 1 0");
        out.println("        0 1 2 3 2 1 0");
        out.println("          0 1 2 1 0");
        out.println("            0 1 0");
        out.println("              0");
    }
    else if(n==8)
    {
        out.println("                0");
        out.println("              0 1 0");
        out.println("            0 1 2 1 0");
        out.println("          0 1 2 3 2 1 0");
        out.println("        0 1 2 3 4 3 2 1 0");
        out.println("      0 1 2 3 4 5 4 3 2 1 0");
        out.println("    0 1 2 3 4 5 6 5 4 3 2 1 0");
        out.println("  0 1 2 3 4 5 6 7 6 5 4 3 2 1 0");
        out.println("0 1 2 3 4 5 6 7 8 7 6 5 4 3 2 1 0");
        out.println("  0 1 2 3 4 5 6 7 6 5 4 3 2 1 0");
        out.println("    0 1 2 3 4 5 6 5 4 3 2 1 0");
        out.println("      0 1 2 3 4 5 4 3 2 1 0");
        out.println("        0 1 2 3 4 3 2 1 0");
        out.println("          0 1 2 3 2 1 0");
        out.println("            0 1 2 1 0");
        out.println("              0 1 0");
        out.println("                0");
    }
    else if(n==9)
    {
        out.println("                  0");
        out.println("                0 1 0");
        out.println("              0 1 2 1 0");
        out.println("            0 1 2 3 2 1 0");
        out.println("          0 1 2 3 4 3 2 1 0");
        out.println("        0 1 2 3 4 5 4 3 2 1 0");
        out.println("      0 1 2 3 4 5 6 5 4 3 2 1 0");
        out.println("    0 1 2 3 4 5 6 7 6 5 4 3 2 1 0");
        out.println("  0 1 2 3 4 5 6 7 8 7 6 5 4 3 2 1 0");
        out.println("0 1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1 0");
        out.println("  0 1 2 3 4 5 6 7 8 7 6 5 4 3 2 1 0");
        out.println("    0 1 2 3 4 5 6 7 6 5 4 3 2 1 0");
        out.println("      0 1 2 3 4 5 6 5 4 3 2 1 0");
        out.println("        0 1 2 3 4 5 4 3 2 1 0");
        out.println("          0 1 2 3 4 3 2 1 0");
        out.println("            0 1 2 3 2 1 0");
        out.println("              0 1 2 1 0");
        out.println("                0 1 0");
        out.println("                  0");
    }
        out.flush();
    } 
}
