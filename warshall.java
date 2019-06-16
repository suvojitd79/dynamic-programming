//all pairs sp
import java.util.*;
public class warshall{

	private static final int INF=999999; //infinite

	
	public static void main(String[] args){

		/* Let us create the following weighted graph 
           10 
        (0)------->(3) 
        |         /|\ 
        5 |          | 
        |          | 1 
        \|/         | 
        (1)------->(2) 
           3           */
        int graph[][] = { {0,   5,  INF, 10}, 
                          {INF, 0,   3, INF}, 
                          {INF, INF, 0,   1}, 
                          {INF, INF, INF, 0} 
                        }; 
        floydWarshall(graph);                
		
	}

	private static void floydWarshall(int[][] graph){

		int v=graph.length;

		for(int s=0;s<v;s++){
			for(int d=0;d<v;d++){
				
				for(int k=0;k<d;k++){

				if(graph[s][k]+graph[k][d]<graph[s][d]) graph[s][d] = graph[s][k]+graph[k][d];

				}
			}
		}
	
		for(int i=0;i<v;i++)
				System.out.println(Arrays.toString(graph[i]));
	}


}
