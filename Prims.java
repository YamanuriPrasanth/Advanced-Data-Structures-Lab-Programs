Write a java program to implement Prims algorithm

Aim:To implement Prims algorithm using java programming

Description:
Prim's algorithm is an algorithm that finds a minimum spanning tree for a connected weighted undirected graph. This means it finds a subset of the edges that forms
a tree that includes every vertex, where the total weight of all the edges in the tree is minimized.
	
procedurePrim(G: weighted connected graph with n vertices)
	T := a minimum-weight edge
	for i = 1 to n − 2
	begin
e:= an edge of minimum weight adjacent to a vertex in T and not forming a cycle in T if added to T
		T :=T with e added
	end
return(T).
	
Program:
import java.util.*;
class Prims
{
    public static void main(String[] args)
    {
        int cost[][]=new int[10][10];
        boolean visited[]=new boolean[10];
        int n,ne=1,a=0,b=0,x,min,mincost=0;
        Scanner s=new Scanner(System.in);
        System.out.println("enter the no.of vertices");
        n=s.nextInt();
        System.out.println("enter the cost matrix");
        for(int i=1;i<=n;i++)
        {
            for (int j=1;j<=n;j++)
            {
                if(i==j)
                    cost[i][j]=999;
                else if(j>i)
                {
                    System.out.println("enter the cost of "+i+" and "+j);
                    cost[i][j]=cost[j][i]=s.nextInt();
                }
                else{}
            }
        }
        System.out.println("enter the starting vertex");
        x=s.nextInt();
        visited[x]=true;
        while(ne<n)
        {
            min=999;
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(cost[i][j]!=999&&((visited[i]&&!visited[j])||(visited[j]&&!visited[i])))
                    {
                        if(cost[i][j]<min)
                        {
                            min=cost[i][j];
                            a=i;
                            b=j;
                        }
                    }
                }
            }
            System.out.println("\n Edge :<"+a+","+b+">"+" cost: "+cost[a][b]+"ne:"+ne+" min="+min);
            mincost+=min;
            visited[b]=visited[a]=true;
            ne++;
        }
        System.out.println("\n Minimun cost="+mincost);
    }
}

Input and Output:
enter the no.of vertices
4
enter the cost matrix
enter the cost of 1 and 2
2
enter the cost of 1 and 3
1
enter the cost of 1 and 4
8
enter the cost of 2 and 3
6
enter the cost of 2 and 4
2
enter the cost of 3 and 4
4
enter the starting vertex
1

 Edge :<1,3> cost: 1ne:1 min=1

 Edge :<1,2> cost: 2ne:2 min=2

 Edge :<2,4> cost: 2ne:3 min=2

 Minimun cost=5
