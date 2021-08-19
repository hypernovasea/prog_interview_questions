
public class TrailingZeroesDriver implements Trail{
	public int f(int n){
        
        //first check if n is less than 0
        if(n < 0){
            return -1; 
        }
        
        //Since n has a trailing zero if 10 is one of the factors, we need to count how many times 10 appears as a factor.
        // However, since 10 has its factors, 5 and 2, we need to count how many times 5 is a factor. This is because the count is more
        // more accurate than using 10 and because 2 will appear as a factor multiple times for a number.
        int count = 0;
        
        while(n > 0){
        	count = count + (n/5);
        	n = n/5;
        }
        
        return count;
	}

	public static void main(String[] args){

		TrailingZeroesDriver zero = new TrailingZeroesDriver();
		System.out.println( zero.f(0) );	//should return 0
        System.out.println( zero.f(-1) );	//should return -1
        System.out.println( zero.f(-18) );	//should return -1
        System.out.println( zero.f(6) );	//should return 1
        System.out.println( zero.f(33) );	//should return 7
        System.out.println( zero.f(512) );	//should return 126
        
        //System.out.println( zero.f(2147483648) );   //should produce a problem because it's out of range for int
	}
}
