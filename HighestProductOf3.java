import java.lang.Exception;

public class HighestProductOf3 {

	public static void main(String[] args) {
		int[] a = {-5, 3, 7, 9, -30, 10};
		int[] b = {1, 10, -5, 1, -100};
		int[] c = {1, 10, -5};
		int[] d = {1, 10};
		
		try {
			System.out.println("Array A --> " + highestProductof3(a) + "\n\n");
			System.out.println("Array B --> " + highestProductof3(b) + "\n\n");
			System.out.println("Array C --> " + highestProductof3(c) + "\n\n");
			System.out.println("Array D --> " + highestProductof3(d) + "\n\n");
			
		} catch(Exception e) {
			System.out.println("Array has length less than 3!!");
        }
	}

	
	
	public static int highestProductof3(int[] nums) throws IllegalArgumentException {
		
		if (nums.length <= 2) 
			throw new IllegalArgumentException();
		
		if (nums.length == 3)
			return (nums[0]*nums[1]*nums[2]);
		
		int highest = Math.max(nums[0], nums[1]);
		int lowest = Math.min(nums[0], nums[1]);
		
		int highest2 = nums[0] * nums[1];
		int lowest2 = nums[0] * nums[1];
		
		int highest3 = highest2 * nums[2];
		
		for (int i=2; i<nums.length; i++) {
			
			int N = nums[i];
			
			// do we have a new highest product of 3?
	        // it's either the current highest,
	        // or the current times the highest product of two
	        // or the current times the lowest product of two
			int prodHi3 = Math.max( (highest2 * N), highest3);
			highest3 = Math.max( prodHi3,  (lowest2 * N) );
			
			
			// do we have a new highest product of two?
			// it's either the current highest of 2,
			// or it's the current times the highest,
			// or it's the current times the lowest.
			int prodHi2 = Math.max( (highest * N ), highest2);
			highest2 = Math.max(prodHi2, (lowest * N) );
			
			
			// do we have a new lowest product of two?
			// it's either the current lowest of 2,
			// or it's the current times the highest,
			// or it's the current times the lowest.
			int prodLo2 = Math.min(lowest2, highest * N);
			lowest2 = Math.min(prodLo2, lowest * N );
			highest = Math.max(highest, N);
			lowest = Math.min(lowest, N);
		}
		
		return highest3;
		
	}
}
