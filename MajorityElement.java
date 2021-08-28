import java.util.Arrays;

//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//You may assume that the array is non-empty and the majority element always exist in the array.

/**
 *  Majority Element
 *  https://leetcode.com/problems/majority-element/
 * 
 *  level: easy
 *  ans: 
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = {9, 7, 3, 7, 7, 7};
		majorityElement(nums);
	}
	

	public static void majorityElement(int[] nums) {

        int major = nums[0];
        
        Arrays.sort(nums);
        int N = nums.length;
        
        if (nums[0] == nums[N/2]) {
            major = nums[0];
        }
        else if (nums[N/2] == nums[(N/2) + 1]) {
            major = nums[N/2];
        }
        else if (nums[(N/2) + 1] == nums[N-1]) {
            major = nums[N-1];
        }
        System.out.println(major);
    }

}
