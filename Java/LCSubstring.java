//length of the longest common substring
import java.util.*;
public class LCSubstring{

	
	public static void main(String[] args){

		System.out.println(lcSubstringDP("zxabcdezy","yzabcdezx"));
		
	}
	/*
		abcef
		abcf  //3(abc)

	*/




	private static int lcSubstring(String x,String y){

		if(x.length()==0 || y.length()==0) return 0;

		if(x.charAt(0)==y.charAt(0)){
			if(x.length()>1 && y.length()>1 && x.charAt(1)==y.charAt(1))
				return 1 + lcSubstring(x.substring(1),y.substring(1));
			else return Math.max(Math.max(lcSubstring(x.substring(0),y.substring(1)),lcSubstring(x.substring(1),y.substring(0))),1);
		}

	return Math.max(lcSubstring(x.substring(0),y.substring(1)),lcSubstring(x.substring(1),y.substring(0)));

	}


	private static int lcSubstringDP(String x,String y){

		int[][] cache=new int[x.length()+1][y.length()+1];

		for(int i=0;i<=x.length();i++){
			for(int j=0;j<=y.length();j++){

				if(i==0 || j==0) cache[i][j]=0;

				else if(x.charAt(i-1)==y.charAt(j-1)){

					if((i-1==0 && j-1==0) || (i-2 >=0 && j-2 >=0 && x.charAt(i-2)==y.charAt(j-2)))
							cache[i][j]=cache[i-1][j-1]+1;	
					else 
						cache[i][j]=Math.max(Math.max(cache[i][j-1],cache[i-1][j]),1);	
				}
				else
					cache[i][j]=Math.max(cache[i][j-1],cache[i-1][j]);

			}

		}

		for(int[] x1:cache) System.out.println(Arrays.toString(x1));
		return cache[x.length()][y.length()];
	}

}
