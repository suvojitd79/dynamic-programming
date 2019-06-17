//longest increasing subsequences
import java.util.*;
public class LIS{

	public static void main(String[] args){

		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(3,4,-1,0,6,2,3));
		System.out.println(maxLIS(list));

	}

	private static int maxLIS(ArrayList<Integer> list){

		int[] cache=new int[list.size()];
		Arrays.fill(cache,1);

		for(int i=1;i<list.size();i++){
			for(int j=0;j<i;j++){
				if(list.get(i)>list.get(j))
					cache[i]=Math.max(cache[i],cache[j]+1);
			}
		}
		int max=cache[0];
		for(int x:cache) max=Math.max(max,x);
		return max;
	}


}
