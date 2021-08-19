/**
 * This class chooses the max number of intervals or
 * activities a person can do by scheduling intervals 
 * with the earliest finish time.
 * 
 */


public class MaxScheduling {

	public static void main(String[] args){
		
		int[] start = {1, 3, 0, 5, 8, 5};
		int[] finish = {2, 4, 6, 7, 9, 9};
		
		printMaxScheduling(start, finish);
		
	}
	
	public static void printMaxScheduling(int[] s, int[]f){
		int n = s.length;
		
		System.out.print("the following intervals has been selected : ");
		int i = 0;
		System.out.print(i + " ");
		
		for(int j=1; j<n; j++){
			if(s[j] >= f[i]){
				System.out.print(j + " ");
				i=j;
			}
		}
	}
	
	
}	//end MaxScheduling class
