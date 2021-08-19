
public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println( maxSubArray(nums) );
	}

	public static int maxSubArray(int[] nums) {
        
        int N = nums.length;
        
        if(N == 0)  return 0;
        if(N == 1)  return nums[0];
        
        int[] memo = new int[N];
        int max = nums[0];
        memo[0] = max;
        
        for(int i=1; i<N; i++){
            int total = memo[i-1] + nums[i];
            
            if(total > nums[i]){    //extend window
                memo[i] = total;
            }else{                  //start new window
                memo[i] = nums[i];
            }
            
            max = Math.max(max, memo[i]);
        }
        
        return max;
        
    }
	
	
}
