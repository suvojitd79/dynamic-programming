
/**
 * Length of Longest common Subsequence
 */
import java.util.*;
public class lcs{

	
	public static void main(String[] args){

		System.out.println(lcs("FUKREY","KYERUF"));

	}

	private static int lcs(String x,String y){

		
		/*
		O(2^N)

		if(x.length()==0 || y.length()==0)
			return 0;
		if(x.charAt(0)==y.charAt(0))
			return 1 + lcs(x.substring(1),y.substring(1));
		return Math.max(lcs(x,y.substring(1)),lcs(x.substring(1),y));
		*/

		//O(mn)

		int[][] cache = new int[x.length()+1][y.length()+1];
		Arrays.fill(cache[0],0);

		for(int i=1;i<=x.length();i++){

			for(int j=0;j<=y.length();j++){

				if(j==0) cache[i][j]=0;

				else if(x.charAt(i-1)==y.charAt(j-1))
					cache[i][j] = 1 + cache[i-1][j-1];
				else
					cache[i][j] = Math.max(cache[i-1][j],cache[i][j-1]);
			}

		}

		return cache[x.length()][y.length()];
	}



}
