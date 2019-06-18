//weighted job scheduling

import java.util.*;
public class jobSchedule{

	
	public static void main(String[] args){

		ArrayList<Integer> start=new ArrayList<>(Arrays.asList(1,3,6,2));
		ArrayList<Integer> end=new ArrayList<>(Arrays.asList(2,5,19,100));
		ArrayList<Integer> profit=new ArrayList<>(Arrays.asList(50,20,100,200));
		System.out.println(maxProfit(start,end,profit));
			
	}

	private static int maxProfit(ArrayList<Integer> s,ArrayList<Integer> e,ArrayList<Integer> p){

		ArrayList<Integer> cache=new ArrayList<>();
		for(int i=0;i<p.size();i++) cache.add(p.get(i));

		for(int i=1;i<s.size();i++){
			for(int j=0;j<i;j++){

				if(s.get(i)>=e.get(j)){
					int max=Math.max(cache.get(i),p.get(i)+cache.get(j));
					cache.set(i,max);
				}

			}

		}	
		return Collections.max(cache);
	}


}
