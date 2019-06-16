//knapsack
import java.util.*;
public class knapsack{
	
	public static void main(String[] args){

		int[] w={7,10,10,24},v={10,18,18,24};
		int W=25;
		System.out.println(max01(w,v,W));
	}

	public static int max01(int[] w,int[] v,int W){

		int[][] cache=new int[w.length+1][W+1];

		for(int i=0;i<w.length+1;i++){
			for(int j=0;j<W+1;j++){

				if(i==0 || j==0) cache[i][j]=0;

				else if(w[i-1]>j) cache[i][j]=cache[i-1][j];

				else cache[i][j]=Math.max(cache[i-1][j],v[i-1]+cache[i-1][j-w[i-1]]);
			}
		}

		return cache[w.length][W];
	}


}
