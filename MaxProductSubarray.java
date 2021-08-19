
public class MaxProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println( maxProduct(nums) );
	}

	
	
	
	public static int maxProduct(int[] nums) {
        
        int N = nums.length;
        
        if(N == 0)  return 0;
        if(N == 1)  return nums[0];
        
        int max = nums[0];
        int min = max;
        int finalMax = max;

        
        for(int i=1; i<N; i++){
            
            int temp = max; //hold current value of max
            
            /*
             * Since 2 neg nums can make a pos num, we need to keep track of max and min values.
             * First we see which is greater --> the current number * the previous max OR the current number * the previous min.
             * This check account for when max goes neg because ith num if neg.
             * */
            max = Math.max( nums[i]*max, nums[i]*min ); 
            max = Math.max( nums[i], max );
            
            min = Math.min( nums[i]*temp, nums[i]*min );
            min = Math.min( nums[i], min);
            
            finalMax = Math.max(finalMax, max);
        }
        
        return finalMax;
        
    }
}
