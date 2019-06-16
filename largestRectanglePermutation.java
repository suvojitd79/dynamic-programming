
/*

/*
Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the area of the largest rectangle inside the grid 
such that all the cells inside the chosen rectangle should have 1 in them. You are allowed to permutate the columns matrix i.e.
you can arrange each of the column in any order in the final grid. Please follow the below example for more clarity.

 Lets say we are given a binary grid of 3 * 3 size.
1 0 1
0 1 0
1 0 0 

At present we can see that max rectangle satisfying the criteria mentioned in the problem is of 1 * 1 = 1 area i.e either of 
the 4 cells which contain 1 in it. Now since we are allowed to permutate the columns of the given matrix, we can take column 1 
and column 3 and make them neighbours. One of the possible configuration of the grid can be:
1 1 0
0 0 1
1 0 0 

Now In this grid, first column is column 1, second column is column 3 and third column is column 2 from the original given grid.
Now, we can see that if we calculate the max area rectangle, we get max area as 1 * 2 = 2 which is bigger than the earlier case.
Hence 2 will be the answer in this case. 
*/


import java.util.*;
public class largestRectanglePermutation{

	
	public static void main(String[] args){


         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
         list.add(new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0)));
         list.add(new ArrayList<>(Arrays.asList(0, 1, 0, 1, 1)));
         list.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1, 0)));             

		System.out.println(maxRectangleColSwip(list));

	}



	private static int maxRectangleColSwip(ArrayList<ArrayList<Integer>> list){


		for(int i=1;i<list.size();i++){

			for(int j=0;j<list.get(i).size();j++){


				int x = list.get(i).get(j)==0?0:list.get(i).get(j)+list.get(i-1).get(j);

				list.get(i).set(j,x);

			}

		}


		for(ArrayList<Integer> x:list)
				Collections.sort(x,Collections.reverseOrder());

		int g=-1;	
		for(int i=0;i<list.size();i++){
		
			for(int j=0;j<list.get(i).size();j++){

					int c = (j+1)*list.get(i).get(j);
					g=Math.max(g,c);
			}

		}	

		return g;
	}

	private static int maxRectangle(ArrayList<ArrayList<Integer>> list){

		if(list.size()==0) return -1;

		int max_global=maxHistogram(list.get(0));

		for(int i=1;i<list.size();i++){

			for(int j=0;j<list.get(i).size();j++)
				list.get(i).set(j,list.get(i).get(j)==0?0:list.get(i).get(j)+list.get(i-1).get(j));
			max_global=Math.max(max_global,maxHistogram(list.get(i)));
			
		}
		return max_global;
	}


	//max rectangular area under a histogram as a subroutine
	private static int maxHistogram(ArrayList<Integer> cache){

		//store the indecies
		Stack<Integer> stack = new Stack<>();

		int i=0,max_area=-1,max_global=-1;

		while(i<cache.size()){

			if(stack.isEmpty() || cache.get(stack.peek())<=cache.get(i))
				{stack.push(i);i++;}
			else{
				//calculate the area
				while(!stack.isEmpty() && cache.get(stack.peek())>cache.get(i))
				{
					max_area=(i-stack.peek())*cache.get(stack.pop());
					max_global=Math.max(max_global,max_area);
				}

			}

		}

		//bars are placed in increasing order of their height
		while(!stack.isEmpty()){
			max_area=(i-stack.peek())*cache.get(stack.pop());
			max_global=Math.max(max_global,max_area);
		}
		return max_global;
	}


}
