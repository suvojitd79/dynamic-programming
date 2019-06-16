//bellman-ford
import java.util.*;
public class bellmanFord{	


	private static final int INF=99999;

	public static void main(String[] args){

		int[][] graph={
				{0,4,2,INF,INF},
				{INF,0,3,2,3},
				{INF,1,0,4,5},
				{INF,INF,INF,0,INF},
				{INF,INF,INF,-5,0}
		};

		bFord(graph,0);

	}

	/*
		source is fixed so dont need to store source

	*/

	private static void bFord(int[][] graph,int source){

		int v=graph.length;
		int[] cache=new int[v];
		Arrays.fill(cache,INF);
		cache[source] = 0; 

		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{

				if(i==source)
					cache[j]=Math.min(cache[j],graph[i][j]);
				else
					cache[j]=Math.min(cache[j],graph[source][i]+graph[i][j]);
			}

		}


		System.out.println(Arrays.toString(cache));
	}

}
