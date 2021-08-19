import java.util.Random;


public class NumberSwapper{
	
	public static void main(String[] args){
		Random randomGen = new Random();
		int a = randomGen.nextInt(1000000);
		int b = randomGen.nextInt(1000000);
		numSwap(a,b);

	}

	public static void numSwap(int a, int b){

		if(a != b){
			System.out.println("before --> a : " + a + " and b : " + b);
			if(a < b){
				a = Math.abs(a-b);
				b = b-a;
				a = b+a;
			}else{
				b = Math.abs(b-a);
				a = a-b;
				b = a+b;
			}
			System.out.println("after --> a : " + a + " and b : " + b);
		}
	}
}