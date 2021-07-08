Write a java program to implement Dijkstra's algorithm

Aim:To implement Dijkstra's algorithm using java programming
    
Description:

Program:
class Dijkstra
{
    static int dist[]=new int[10];
    static int p[]=new int[10];
    static int selected[]=new int[10];
    static int cost[][]={{99,7,9,99,99,14},{7,99,10,15,99,99},
            {9,10,99,11,99,2},{99,15,11,99,6,99},
            {99,99,99,6,99,9},{14,99,2,99,9,99}};
    static int n=6;



    public static void main(String[] args)
    {
        int min,newdist,dc,k,source=0;
        int n=6;
        for(int i=0;i<n;i++)
        {
            dist[i]=99;
            p[i]=-1;
            selected[i]=0;
        }
        shortestpath();
        for(int i=0;i<n;i++)
        {
            System.out.println(dist[i]);
        }

    }
    static void shortestpath()
    {
        int min,newdist,dc,k=0,source=0,n=6;

        dist[source]=0;
        selected[source]=1;
        while(!allselected())
        {
            min=99;
            dc=dist[source];
            for(int i=0;i<n;i++)
            {
                if(selected[i]==0)
                {

                    newdist=dc+cost[source][i];
                    if(newdist<dist[i])
                    {
                        dist[i]=newdist;
                        p[i]=source;
                    }
                    if(dist[i]<min)
                    {
                        min=dist[i];
                        k=i;
                    }

                }
            }
            source=k;
            selected[k]=1;
        }

    }
    static boolean allselected()
    {
        for(int i=0;i<n;i++)
            if(selected[i]==0)
                return false;
        return true;
    }
}

Input and Output:
0
7
9
20
20
11
