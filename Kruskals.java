Write a java Program to implement kruskals algorithm

Aim:To implement Krusals algorithm using java Programming

Description:
It is an algorithm in graph theory that finds a minimum spanning tree for a connected weighted graph.
This means it finds a subset of the edges that forms a tree that includes every vertex, where the total weight 
of all the edges in the tree is minimized.

Program:	
import java.util.*;
class Edge
{
    int node1;
    int node2;
    int wt;
}
class Kruskal
{
    Edge e[]=new Edge[20];
    int parent[]=new int[20];
    int m,n;
    void kruskal()
    {
        Scanner s=new Scanner(System.in);
        int i, j,k = 1,cost = 0;
        System.out.println("KRUSKAL's ALGORITHM");
        System.out.println("Enter number of vertices");
        n=s.nextInt();
        for( i=1;i<= n;i++)
        {
            parent[i]=-1;
        }
        System.out.println("Enter number of edges");
        m=s.nextInt();
        for(i=1;i<= m;i++)
        {
            System.out.println("enter an edge and wt\n");
            e[i]=new Edge();
            e[i].node1=s.nextInt();
            e[i].node2=s.nextInt();
            e[i].wt=s.nextInt();
        }
        sortedges();
        System.out.println("\n\nEdges of the tree\n");
        i=1;
        while(k< n)
        {
            if(checkcycle(e[i].node1,e[i].node2))
            {
                k++;
                cost=cost+e[i].wt;

            }
            i++;
        }
        System.out.println(cost);
    }

    void sortedges()
    {
        int i,j;

        for(i=1;i<= m-1;++i)
            for(j=i+1;j<= m;++j)
                if(e[i].wt>e[j].wt)
                {
                    Edge temp=new Edge();
                    temp=e[i];e[i]=e[j];e[j]=temp;}
        for(i=1;i<=m;i++)
            System.out.println("<"+e[i].node1+" "+e[i].node2+">:"+e[i].wt);
    }

    boolean checkcycle(int i,int j)
    {
        int v1,v2;
        v1 = i;
        v2 = j;
        while(parent[i]>-1)
            i = parent[i];
        while(parent[j]>-1)
            j = parent[j];
        if(i!=j)
        {
            parent[j]=i;
            System.out.println(v1+" "+v2);
            return true;
        }
        return false;
    }
}
class Kruskals
{
    public static void main(String args[])
    {
        Kruskal k=new Kruskal();
        k.kruskal();
    }
}

Input and Output:
KRUSKAL's ALGORITHM
Enter number of vertices
4
Enter number of edges
5
enter an edge and wt

2
3
4
enter an edge and wt

1
2
5
enter an edge and wt

3
4
2
enter an edge and wt

4
1
5
enter an edge and wt

4
2
1
<4 2>:1
<3 4>:2
<2 3>:4
<4 1>:5
<1 2>:5


Edges of the tree

4 2
3 4
4 1
8
