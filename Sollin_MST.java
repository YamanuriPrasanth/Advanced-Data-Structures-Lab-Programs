class GraphEdge
{
    int v;
    int u;
    int cost;
    GraphEdge(int v,int u,int cost)
    {
        this.v=v;
        this.u=u;
        this.cost=cost;
    }
}
class Sollin_MST
{
    static int parent[]=new int[7];
    static int min[]=new int[7];
    public static void main(String[] args)
    {
        GraphEdge g[]=new GraphEdge[10];
        int n=6;
        g[1]=new GraphEdge(1,2,1);
        g[2]=new GraphEdge(1,4,4);
        g[3]=new GraphEdge(2,4,7);
        g[4]=new GraphEdge(2,5,3);
        g[5]=new GraphEdge(2,6,6);
        g[6]=new GraphEdge(3,2,5);
        g[7]=new GraphEdge(3,6,9);
        g[8]=new GraphEdge(6,5,2);
        g[9]=new GraphEdge(5,4,8);
        int edges=g.length-1;
        init(n);
        int components=n;
        int mincost=0;
        while(components>1)
        {
            for(int i=1;i<=n;i++)
            {
                min[i]=-1;
            }
            for(int i=1;i<=edges;i++)
            {
                if(root(g[i].v)==root(g[i].u))
                    continue;
                int rv=root(g[i].v);
                if(min[rv]==-1 || g[i].cost<g[min[rv]].cost)
                    min[rv]=i;

                int ru=root(g[i].u);
                if(min[ru]==-1 || g[i].cost<g[min[ru]].cost)
                    min[ru]=i;

            }
            for(int i=1;i<=n;i++)
            {
                if(min[i]!=-1)
                {
                    if (merge(g[min[i]].v, g[min[i]].u))
                    {
                        mincost += g[min[i]].cost;
                        components--;
                    }
                }
            }
        }
        System.out.println("The cost of the spanning tree is "+mincost);
    }
    static int root(int v)
    {
        if(parent[v]==v)
            return v;
        return parent[v]=root(parent[v]);
    }
    static boolean merge(int v,int u)
    {
        v=root(v);
        u=root(u);
        if(v==u)
            return false;
        parent[v]=u;
        return true;
    }
    static void init(int n)
    {
        for(int i=1;i<=n;i++)
            parent[i] = i;
    }

}
