package src;
import java.util.Arrays;


/**
 *  Move Zeroes
 *  https://leetcode.com/problems/move-zeroes/
 * 
 *  level: easy
 *  ans: array manipulations
 * 
 */
public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,0,0,12};
		moveZeroes(nums);
	}

	
	public static void moveZeroes(int[] nums) {
        
        int count = 0;
        int lastIndex = 0;
        int N = nums.length;
        
        for (int i=0; i<N; i++) {
            if (nums[i] == 0) {
                count++;
            }
            else {
                nums[lastIndex] = nums[i];
                lastIndex++;
            }
        }
        
        for (int j=N-count; j<N; j++) {
            nums[j] = 0;
        }
        
        System.out.println(Arrays.toString(nums));
    }

}
