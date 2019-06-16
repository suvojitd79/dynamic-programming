//min path
import java.util.*;
public class minPath{
	
	public static void main(String[] args){
		
		int cost[][] = 
		 			 { 
		 			  {1, 2, 3}, 
                      {4, 8, 2}, 
                      {1, 5, 3}}; 
        
        minPath(cost,2,2);                
		
	}

	private static void minPath(int[][] cost,int m,int n){

		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){

				if(i==0 && j==0) continue;

				else if(i==0) cost[i][j]+=cost[i][j-1];

				else if(j==0) cost[i][j]+=cost[i-1][j]; 

				else cost[i][j] += Math.min(Math.min(cost[i-1][j-1],cost[i-1][j]),cost[i][j-1]);
				
			}
		}

		for(int[] x:cost)
			System.out.println(Arrays.toString(x));

	}


}
