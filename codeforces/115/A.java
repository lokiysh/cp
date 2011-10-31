
/*
********QUESTION DESCRIPTION*************
 
 
* @author (codeKNIGHT) 
 */
import java.util.*;
import java.math.*;
import java.io.*;
public class c87
{
static Graph g=new Graph();
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        //FileReader f=new FileReader("C:\\users\\Lokesh\\Desktop\\input.txt");
            //Scanner in=new Scanner(f);
        //int t=in.nextInt();
        c87 b=new c87();
        int i,p;
        String s;
        int n=in.nextInt();
        for(i=0;i<n;i++)
        g.addVertex(i);
        for(i=0;i<n;i++)
        {
            p=in.nextInt()-1;
            if(p!=-2)
            {
                g.addDEdge(p,i,0);
                g.p(i,p);
                
            }
            else
            g.p(i,-1);
            
            
        }
        
        b.DFS();
        int max=0;
        for(i=0;i<n;i++)
        {
            //System.out.println(g.getDepth(i)+" "+g.getP(i));
            if(g.getDepth(i)>max)
            max=g.getDepth(i);
        }
        out.println(max);
        out.flush();
    }
    int time;
    public void DFS()
{
    int i;
    for(i=0;i<g.vertex.size();i++)
    {
        g.color(i,'W');
        //g.p(i,-1);
        
    }
    time=0;
    for(i=0;i<g.vertex.size();i++)
    {
        if(g.getColor(i)=='W'&&g.getP(i)==-1)
        DFSVisit(i);
    }
}
public void DFSVisit(int u)
{
    int i,v;
    time+=1;
    g.discoverTime(u,time);
    g.color(u,'G');
    //int d=g.getDepth(u);
    g.depth(u,g.getDepth(g.getP(u))+1);
    ArrayList<Integer> adj=g.getNeighbours(u);
    if(adj!=null)
    for(i=0;i<adj.size();i++)
    {
        v=adj.get(i);
        if(g.getColor(v)=='W')
        {
            g.p(v,u);
            DFSVisit(v);
        }
    }
    g.color(u,'B');
    time+=1;
    g.finishTime(u,time);
    //System.out.println(u+ " "+time);
}
}
class Graph
{
ArrayList<Integer> vertex=new ArrayList<Integer>();
Hashtable<Integer,ArrayList> edges=new Hashtable<Integer,ArrayList>();
Hashtable<Integer,Character> colour=new Hashtable<Integer,Character>();
Hashtable<Integer,Integer> distance=new Hashtable<Integer,Integer>();
Hashtable<Integer,Integer> parent=new Hashtable<Integer,Integer>();
Hashtable<Integer,Integer> discover=new Hashtable<Integer,Integer>();
Hashtable<Integer,Integer> finish=new Hashtable<Integer,Integer>();
Hashtable<Integer,Integer> depth=new Hashtable<Integer,Integer>();
public void addVertex(int v)
{
if(!(vertex.contains(v)))
vertex.add(v);
}
public void addDEdge(int u,int v,int w)
{
if(edges.containsKey(u)==false)
{
ArrayList<Integer> t=new ArrayList<Integer>();
t.add(v);
edges.put(u,t);
}
else
{
ArrayList t=edges.get(u);
t.add(v);
edges.put(u,t);
}
}
public void addUEdge(int u,int v,int w)
{
if(edges.containsKey(u)==false)
{
ArrayList<Integer> t=new ArrayList<Integer>();
t.add(v);
edges.put(u,t);
}
else
{
ArrayList t=edges.get(u);
t.add(v);
edges.put(u,t);
}
if(edges.containsKey(v)==false)
{
ArrayList<Integer> t=new ArrayList<Integer>();
t.add(u);
edges.put(v,t);
}
else
{
ArrayList t=edges.get(v);
t.add(u);
edges.put(v,t);
}
}
public ArrayList getVertices()
{
return vertex;
}
public ArrayList getNeighbours(int u)
{
if(edges.containsKey(u))
return edges.get(u);
else
return null;
}
public void color(int u,char c)
{
colour.put(u,c);
}
public char getColor(int u)
{
return colour.get(u);
}
public void d(int u,int dist)
{
distance.put(u,dist);
}
public int getD(int u)
{
return distance.get(u);
}
public void p(int u,int p)
{
parent.put(u,p);
}
public int getP(int u)
{
return parent.get(u);
}
public void discoverTime(int u,int t)
{
discover.put(u,t);
}
public int getDiscoverTime(int u)
{
return discover.get(u);
}
public void finishTime(int u,int t)
{
finish.put(u,t);
}
public int getFinishTime(int u)
{
return finish.get(u);
}
public void depth(int u,int d)
{
depth.put(u,d);
}
public int getDepth(int u)
{
if(depth.get(u)!=null)
return depth.get(u);
else
return 0;
} 
}