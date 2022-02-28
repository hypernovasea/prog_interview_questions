package src.broken;

public class Combinations {

	private StringBuilder out = new StringBuilder();
	private final String in;
	
	public Combinations(final String str) {
		in = str;
	}
	
	public void combine() {
		combine( 0 );
	}
	
	
	private void combine(int start) {
		System.out.println( "start = " + start );
		for(int i = start; i < in.length(); i++) {
			System.out.println( "i = " + i );
			out.append(in.charAt(i));
			System.out.println( out );
			if(i < in.length() ){
				combine( i + 1 );
			}
			out.setLength(out.length() - 1);
		}
	}
	
	
	public static void main(String[] args) {
		Combinations combo = new Combinations("abcd");
		combo.combine();
	}

}
