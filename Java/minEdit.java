//min edit to convert str1-> str2
import java.util.*;
public class minEdit{

	
	public static void main(String[] args){

		System.out.println(min("sunday","saturday"));
	}

	private static int min(String x,String y){

		int[][] cache=new int[x.length()+1][y.length()+1];

		for(int i=0;i<x.length()+1;i++){
			for(int j=0;j<y.length()+1;j++){

				if(i==0) cache[i][j]=j;

				else if(j==0) cache[i][j]=i;

				else if(x.charAt(i-1)==y.charAt(j-1)) cache[i][j] = cache[i-1][j-1];

				else cache[i][j]=1+Math.min(Math.min(cache[i-1][j-1],cache[i-1][j]),cache[i][j-1]);
			}
		}
		return cache[x.length()][y.length()];
	}


}
