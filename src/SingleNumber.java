package src;

import java.util.HashSet;
import java.util.Iterator;
// Given an array of integers, every element appears twice except for one. Find that single one.

public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = {4, 6, 7, 8, 4, 8, 6};
		System.out.print( singleNumber(nums) );
	}

	
	public static int singleNumber(int[] nums) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove( nums[i] );
            }
            else {
                set.add(nums[i]);
            }
        }
        
        Iterator<Integer> iter = set.iterator();     //the remaining element in the hashset is the one we want
        int y = (int)iter.next();
        return y;
    }
}
