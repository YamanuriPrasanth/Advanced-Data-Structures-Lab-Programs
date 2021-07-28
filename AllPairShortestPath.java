Write a Java Program to implement shortest path between all pair of vertices.
    
Aim:To implement shortest path between all pair of vertices using java Programming

Description:The all pair shortest path algorithm is also known as Floyd-Warshall algorithm is used to find all pair shortest path problem from
a given weighted graph. As a result of this algorithm, it will generate a matrix, which will represent the minimum distance from any node to all
other nodes in the graph

Program:
import java.util.*;
import java.lang.*;
import java.io.*;
class AllPairShortestPath
{
    final static int INF = 99999, V = 4;
    void floydWarshall(int graph[][])
    {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
            for (k = 0; k < V; k++)
            {
                for (i = 0; i < V; i++)
                {
                    for (j = 0; j < V; j++)
                    {
                        if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
            printSolution(dist);
    }
    void printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args)
    {

        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        AllPairShortestPath a = new AllPairShortestPath();
        a.floydWarshall(graph);
    }
}

Output:
The following matrix shows the shortest distances between every pair of vertices
0   5   8   9   
INF 0   3   4   
INF INF 0   1   
INF INF INF 0 

