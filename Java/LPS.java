//length of the longest pallindromic subsequence
import java.util.*;
public class LPS{
	
	public static void main(String[] args){

		System.out.println(lpsDP("PLEASE DO WRITE CLEAN CODE"));
		
	}

	//O(2^N)
	private static int lpsRecursive(String x){

		if(x.length()==1) return 1;

		if(x.charAt(0)==x.charAt(x.length()-1)) return 2 + lpsRecursive(x.substring(1,x.length()-1));

		return Math.max(lpsRecursive(x.substring(0,x.length()-1)),lpsRecursive(x.substring(1,x.length())));
	}

	//O(N^2)
	private static int lpsDP(String x){

		int[][] cache=new int[x.length()][x.length()];

		for(int i=0;i<x.length();i++) cache[i][i] = 1;

		for(int gap=1;gap<x.length();gap++){
			for(int i=0;i+gap<x.length();i++){

				if(x.charAt(i)==x.charAt(i+gap))
					cache[i][i+gap]= 2 + ((i+1<=i+gap-1)?cache[i+1][i+gap-1]:0);
				else
					cache[i][i+gap]= Math.max(cache[i][i+gap-1],cache[i+1][i+gap]);
			}

		}	
		return cache[0][x.length()-1];
	}



}
