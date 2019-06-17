//word break
import java.util.*;
public class wordBreak{

	
	public static void main(String[] args){

		
		HashMap<String,Integer> dict=new HashMap<>();
		dict.put("i",0);
		dict.put("love",0);
		dict.put("coding",0);
		dict.put("movie",0);

		System.out.println(canBeBroken("codingilove",dict)); 	//true
		System.out.println(canBeBroken("codingii",dict));		//true
		System.out.println(canBeBroken("codinglove",dict));		//true
		System.out.println(canBeBroken("lovi",dict));			//false
		System.out.println(canBeBroken("movielove",dict));		//true

	}

	private static boolean canBeBroken(String s,HashMap<String,Integer> dict){

		boolean[][] cache=new boolean[s.length()][s.length()];

		//check for substrings of length=1
		for(int i=0;i<s.length();i++) cache[i][i]=dict.containsKey(s.charAt(i)+"");
									

		for(int gap=1;gap<s.length();gap++){
			for(int j=0;j+gap<s.length();j++){

					//substring check
				boolean result = dict.containsKey(s.substring(j,j+gap+1));
				for(int k=j;k<=j+gap;k++){

					result = result || (cache[j][k] && cache[k+1][j+gap]);

				}

				cache[j][j+gap] = result;
			}
		}	

		// for(boolean[] x:cache) System.out.println(Arrays.toString(x));

		return cache[0][s.length()-1];
	}


}
