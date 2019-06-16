// max sum rectangle in 2d grid

import java.util.*;
public class maxGrid{

	static class Max{

		int s,e,max;
		Max(int s,int e,int max){
			this.s=s;this.e=e;this.max=max;
		}
		public String print(){
			return "{" + "data" +":"+this.s+","+this.e+","+this.max + "}";
		}

	}

	
	public static void main(String[] args){


         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
         list.add(new ArrayList<>(Arrays.asList(1,2,-1,-4,-20)));
         list.add(new ArrayList<>(Arrays.asList(
         	-8,-3,4,2,1)));
         list.add(new ArrayList<>(Arrays.asList(
         	3,8,10,1,3)));
         list.add(new ArrayList<>(Arrays.asList(
         	-4,-1,1,7,-6)));
          maxGrid(list);
                    

	}

	private static void maxGrid(ArrayList<ArrayList<Integer>> list){

		int h1=0,h2=0,w1=-1,w2=-1,max,global_max=Integer.MIN_VALUE;
		ArrayList<Integer> cache;

		for(int i=0;i<list.size();i++){

				cache=new ArrayList<>();

			for(int j=i;j<list.size();j++){


			if(j==i){for(int k=0;k<list.get(j).size();k++) cache.add(list.get(j).get(k));}
			else {for(int k=0;k<list.get(j).size();k++) cache.set(k,cache.get(k)+list.get(j).get(k));}

				Max m = kadane(cache);
				System.out.println(m.print());
				max=m.max;
				if(max>global_max){

					global_max=max;
					h1=i; //outer
					h2=j; //inner
					w1=m.s;
					w2=m.e;

					// System.out.println(h1+  ":"+h2+"   "  + w1+" "+w2+" max:"+global_max);
				}

			}


		}

		System.out.println(h1+" "+h2+" "+w1+" "+w2+" max:"+global_max);

	}


	private static Max kadane(ArrayList<Integer> list){

		int start=0,end=0,max=list.get(0),global_max=list.get(0);

		for(int i=1;i<list.size();i++){


			if(list.get(i)>0 && max+list.get(i)<list.get(i))
			{
				max=list.get(i);
				start=i;

			}else
				max+=list.get(i);


			//global value
			if(max>global_max){
				global_max=max;
				end=i;
			}



		}

		return new Max(start,end,global_max);

	}




}
