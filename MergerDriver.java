import java.util.Arrays;

public class MergerDriver implements Merger {

	public int[] merge(int[] a, int[] b){
		int[] answer = new int[ a.length + b.length ];
		
		int aIndex=0;
		int bIndex=0;
		int ansIndex=0;
		
		//iterates thru both arrays comparing their values
		while( (aIndex < a.length) && (bIndex < b.length) ){
			
			//if num in a is greater than num in b, add num in 
			// a to answer. else add num in b
			if( a[aIndex] < b[bIndex] ){
				answer[ansIndex] = a[aIndex];
				aIndex++;
			}else{
				
				answer[ansIndex] = b[bIndex];
				bIndex++;
			}
			
			ansIndex++;
		}
		
		//if anything if left in either array, copy it 
		// over to the answer array
		
		while(aIndex < a.length ){
			answer[ansIndex] = a[aIndex];
			ansIndex++;
			aIndex++;
		}
		
		while(bIndex < b.length ){
			answer[ansIndex] =b[bIndex];
			ansIndex++;
			bIndex++;
		}
		
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		//This merge function only works if the two sub arrays are already sorted
		
		MergerDriver md = new MergerDriver();
		
		//sub arrays of equal length
		int[] a = {1, 3, 5, 7};
		int[] b = {2, 4, 6, 8};
		int[] finalArray = md.merge(a, b);
		System.out.println( "sub arrays of equal length-->" + Arrays.toString( finalArray ) );
		
		
		//sub arrays of unequal length
		int[] c = {1, 3, 5, 7};
		int[] d = {2, 4, 6, 8, 10, 12, 14};
		int[] finalArray2 = md.merge(c, d);
		System.out.println( "sub arrays of unequal length-->" + Arrays.toString( finalArray2 ) );
		
		
		//one sub array is empty
		int[] e = {};
		int[] f = {2, 4, 6, 8, 10, 12, 14};
		int[] finalArray3 = md.merge(e, f);
		System.out.println( "one sub array is empty-->" + Arrays.toString( finalArray3 ) );
	
	}

}
