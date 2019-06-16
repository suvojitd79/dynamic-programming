//subset sum problem

/*
	Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
	Output:  True  //There is a subset (4, 5) with sum 9.

*/
import java.util.*;
public class subsetSum{

	
	public static void main(String[] args){

			ArrayList<Integer> list=new ArrayList<>(Arrays.asList(3, 34, 4, 12, 5, 2));
			System.out.println(hasSubsetSum(list,1));

	}

	private static boolean hasSubsetSum(ArrayList<Integer> list,int sum){

		Collections.sort(list);

		boolean[][] cache=new boolean[list.size()+1][sum+1];

		/*
			base cases: sum==0 -->true
						[]---> false
		*/

		for(int i=0;i<=list.size();i++){
			for(int j=0;j<=sum;j++){

				//sum=0
				if(j==0) cache[i][j] = true;

				else if(i==0) cache[i][j]=false;

				else if(list.get(i-1)>j) cache[i][j]=cache[i-1][j];

				else cache[i][j] = cache[i-1][j-list.get(i-1)] || cache[i-1][j];
			}

		}

		return cache[list.size()][sum];
	}

}
