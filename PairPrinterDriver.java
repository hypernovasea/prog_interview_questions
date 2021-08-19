import java.util.*;

public class PairPrinterDriver implements PairPrinter{

	public void printPairs(List<Integer> inputList){
		
		//check if list has anything in it
		if( inputList == null || inputList.size() < 1) {
			System.out.println("List is empty or null!");
			return;
		}
			
		//check if there's only 1 element in list
		if( inputList.size() == 1) {
			System.out.println("List only has 1 element!");
			return;
		}
		
		//list with elements in it
		for( int i=0; i<inputList.size(); i++ ){
			
			for( int j=i+1; j<inputList.size(); j++ ){
				Integer x = inputList.get(i);
				Integer y = inputList.get(j);
				System.out.println( "(" + x.toString() + ", " + y.toString() + ")" );
			}
		}
		
	}
	
	
	public static void main(String[] args){
		
		PairPrinterDriver p = new PairPrinterDriver();
		
		//list with elements in it
		List<Integer> l = new ArrayList<Integer>();		
		l.add(1);
		l.add(8);
		l.add(12);
		l.add(5);
		l.add(7);
		
		p.printPairs(l);
		
		//list with zero elements in it
		List<Integer> l2 = new ArrayList<Integer>();
		p.printPairs(l2);
		
		
		//list with zero elements in it
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(4);
		p.printPairs(l3);
		
		
	}


}
