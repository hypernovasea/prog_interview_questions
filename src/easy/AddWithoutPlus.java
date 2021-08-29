package src.easy;

//Add two numbers without using the + operator. 

/**
 *  Add Without Plus
 * 
 *  level: easy
 *  ans: use binary addition
 */
public class AddWithoutPlus {

	public static void main(String[] args) {
		addWithoutPlus(8, 76); // should print out '84'
	}
	
	
	public static void addWithoutPlus(int a, int b) {
		while(b != 0) {
			int carry = a & b;	//calculate the carry bit
			a = a ^ b;			//calculate the sum
			b = carry << 1;		//shifts carry to 1 bit to calculate sum
		}
		
		System.out.println(a);
	}

}
