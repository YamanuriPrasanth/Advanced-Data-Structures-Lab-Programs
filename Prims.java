import java.util.*;
class Prims 
{
	public static void main(String[] args) 
	{
		int cost[][]=new int[10][10];
		boolean visited[]=new boolean[10];
		int n,ne=1,a=0,b=0,x,min,mincost=0;
		Scanner s=new Scanner(System.in);
		System.out.println("enter the no.of vretice");
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
			System.out.println("enter the cost of"+i+"and"+j);
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
System.out.println("\n Edge :<"+a+","+b+">"+" cost:"+cost[a][b]+"ne:"+ne+"min="+min); 
mincost+=min; 
visited[b]=visited[a]=true; 
ne++;
}
System.out.println("\n Minimun cost="+mincost); 
}
}
