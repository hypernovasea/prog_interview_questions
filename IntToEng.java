
public class IntToEng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    
    public String numberToWords(int num) {

        if(num < 10) 
            return ones[num];

        int temp = num;
        int level = 0;
        String w = "";
        
        while( temp > 0 ){ 
            
            String piece = "";
            
            int three = temp % 1000; //get the num broken into 3;
            
            piece = section(three).trim(); 
            
            //if piece has length 0, then a 0 was translated
            if(piece.length() != 0)
                w = piece + " " + thousands[level] + " " + w;

            level++; //going to a higher place value
            
            temp = (temp - three) / 1000; //remove last 3 nums in value
        }
        
        return w.trim(); //remove trailing white space
    }
    
    
    public String section(int num) {
        //System.out.println(num); 
        if(num == 0){
            return "";
        }else if(num < 10){
            return ones[num];
        }else if(num >= 10 && num < 20){
            return teens[num%10]; 
        }else if(num >= 20 && num <= 99){
            int x = num / 10;
            return tens[x] + " " + section(num%10);
        }else if(num >= 100){
            int x = num / 100; 
            return ones[x] + " Hundred " + section(num%100);
        }
        
        return " ";
       
    }
	
	

}
