package src.misc;
import java.util.*;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution.

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
        int[] ans = twoSum(nums, target);
        for (int i=0; i<ans.length; i++) {
            System.out.printf("%d | ", ans[i]);
        }
		
	}
	
	public static int[] twoSum(int[] nums, int target) {
        
        int[] indices = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int N = nums.length;
        
        for (int i=0; i<N; i++){
            int recip = target-nums[i];
            if (map.containsKey(recip)) {
                indices[0] = map.get(recip);
                indices[1] = i;
                break;
            } 
            else {
                map.put( nums[i], i );
            }
        }
        return indices;
    }

}
