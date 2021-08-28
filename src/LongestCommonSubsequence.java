package src;

public class LongestCommonSubsequence {

	public static int LCSLength(char X[], int i, int m, char Y[], int j, int n){
		if(i==m || j==n){
			return 0;
		}else if(X[i] == Y[j]){
			return (1+LCSLength(X, i+1, m, Y, j+1, n));
		}else{
			return Math.max( LCSLength(X, i+1, m, Y, j, n) , LCSLength(X, i, m, Y, j+1, n) );
		}
	}

	public static void main(String[] args) {

		String X = "ABCBDAB";
		String Y = "BDCABA";

		char[] a = X.toCharArray();
		char[] b = Y.toCharArray();

		System.out.println("a : " + a.toString() );
		System.out.println("b : " + b.toString() );

		System.out.println( LCSLength(a, 0, a.length-1, b, 0, b.length-1) );
	}

}
