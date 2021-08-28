package src;

public class StringCompress {
	public static void main(String[] args){
		String a = "aaaaaaabbcddddaabcdeeeee";
		String b = "abcccccccccddddaaaaaaabbaabbaaaaa";
		String c = "";

		strCompress(a);
		strCompress(b);
		strCompress(c);
	}


	public static void strCompress(String c){

		StringBuilder strb = new StringBuilder();
		int count = 0;
		for(int i=0; i<c.length(); i++){

			if((i+1) != c.length() ){
				int c1 = c.charAt(i);
				int c2 = c.charAt(i+1);

				count++;
				if(c1 != c2){
					strb.append(""+ c.charAt(i) +count);
					count = 0;
				}
			}
		}

		System.out.println("String '"+ c + "' compressed to : " + strb.toString());

	}
}
