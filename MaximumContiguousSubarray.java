//see maximumSubArray
public class MaximumContiguousSubarray {

	public static void main(String[] args) {
		int[] A = { -2,1, -3,4,-1,2,1,-5,4};
		System.out.println(maxContiguous(A));
	}

	public static int maxContiguous(int[] A){

		int[] sum = new int[A.length];
		int max = A[0];
		sum[0] = max;

		for(int i=1; i<A.length; i++ ){
			sum[i] = Math.max(A[i], sum[i-1]+A[i]);
			max = Math.max(max, sum[i]);
		}

		return max;

	}

}
