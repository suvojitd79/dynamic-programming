//Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

import java.util.*;
public class maxSquare{

	
	public static void main(String[] args){


         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
         list.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0)));
         list.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));
         list.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));             
          list.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));

		System.out.println(largestSquare1s(list));

	}


	private static int largestSquare1s(ArrayList<ArrayList<Integer>> list){


		int g=-1;	

		for(int i=0;i<list.size();i++){

			for(int j=0;j<list.get(i).size();j++){

				if(j==0 || i==0) g=Math.max(g,list.get(i).get(j));
				else {g=Math.max(g,list.get(i).get(j)+min(list.get(i-1).get(j-1),list.get(i-1).get(j),list.get(i).get(j-1)));
					list.get(i).set(j,g);
				}

			}

		}
		System.out.println(list);
		return g;
	}

	private static int min(int x1,int x2,int x3){
		return Math.min(Math.min(x1,x2),x3);
	}




}
