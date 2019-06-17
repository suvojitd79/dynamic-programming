//optimal binary search tree
import java.util.*;
public class optimalBST{

	
	public static void main(String[] args){

			
		ArrayList<Integer> k=new ArrayList<>(Arrays.asList(10,12,16,21));
		ArrayList<Integer> f=new ArrayList<>(Arrays.asList(4,2,6,3));
		optimal(k,f);

	}


	private static int optimal(ArrayList<Integer> k,ArrayList<Integer> f){

		int[][] cache=new int[k.size()][k.size()];

		for(int i=0;i<k.size();i++)
				cache[i][i] = f.get(i);

		for(int gap=1;gap<k.size();gap++){
			for(int i=0;i+gap<k.size();i++){

				int min=Integer.MAX_VALUE;
				int val=0;

				for(int j=i;j<=i+gap;j++){
					val+=cache[j][j];

					int tree=0;

					//left subtree exist
					if(j>i)
						tree+=cache[i][j-1];
					if(j<i+gap)
						tree+=cache[j+1][i+gap];

					min = Math.min(min,tree);
				}
				cache[i][i+gap]=val+min;

			}

		}	

		for(int[] x:cache) System.out.println(Arrays.toString(x));


		return cache[0][k.size()-1];
	}

}
