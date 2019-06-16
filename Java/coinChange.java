//coin change problem
import java.util.*;
public class coinChange{

	
	public static void main(String[] args){

			ArrayList<Integer> list=new ArrayList<>(Arrays.asList(2, 5, 3, 6));
			System.out.println(minCoin(list,10));

	}

	private static int minCoin(ArrayList<Integer> list,int n){

		/*
			base-cases:  n=0  ->1
						 []   ->0	
		*/

  		Collections.sort(list);						 

		int[][] cache=new int[list.size()+1][n+1];

		for(int i=0;i<list.size()+1;i++){
			for(int j=0;j<n+1;j++){

				if(j==0) cache[i][j] = 1;

				else if(i==0) cache[i][j] = 0;

				else if(list.get(i-1)>j) cache[i][j] = cache[i-1][j];

				else cache[i][j] = cache[i][j-list.get(i-1)] + cache[i-1][j];

			}

		}

		return cache[list.size()][n];
	}

}
