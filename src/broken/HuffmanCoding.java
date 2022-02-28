package src.broken;

import java.util.*;

public class HuffmanCoding {

	//char[] alphabet = new char[26];
	//HashMap freq = new HashMap();
	//LinkedList sortedFreq = new LinkedList<String>();
	//int bitPer = 4;
	
	PriorityQueue<BinaryTree> minheap;
	
	public HuffmanCoding(double[] freq){
		
		char[] alphabet = new char[26];
		alphabet = fillArrayWithAlphabet(alphabet);
		
		//create heap
		//PriorityQueue<BinaryTree> 
		minheap = new PriorityQueue<>();
		for(int i=1; i<freq.length; i++){
			//create a symbol
			System.out.println("creating symbol " + alphabet[i-1] + " with frequency of " + freq[i] );
			Symbol s = new Symbol( alphabet[i-1], freq[i], "" );
			minheap.add( new BinaryTree(s.prob, s, null, null) );
		}
		
		//create the tree
		while(minheap.size() > 1){
			BinaryTree l = minheap.remove();
			BinaryTree r = minheap.remove();
			minheap.add( new BinaryTree(l.prob+r.prob, null, l, r) );
		}
		
		//traverse the binary tree, assigning codes to nodes
		assignHuffmanCode(minheap.peek(), "");
		printHeap();
	}

	public void assignHuffmanCode(BinaryTree r, String code){
		if(r != null){
			if(r.s != null){
				r.s.code = code;
			}else{
				assignHuffmanCode(r.left, code +"0");
				assignHuffmanCode(r.right, code +"1");
			}
			//System.out.println("symbol : " + r.s.toString() + "\t prob : " +  r.prob);
		}
	}
	
	
	
	public static char[] fillArrayWithAlphabet(char[] alphabet){
	     
		for(char ch = 'a'; ch <= 'z'; ++ch){
			alphabet[ch-'a']=ch;
		} 
		return alphabet;
	}
	   
	
	public void printHeap(){
		System.out.println( "size : " + minheap.size() + ", peek : " + minheap.peek().prob );
		
		StringBuffer in = new StringBuffer("");
		if( minheap.peek() == null ){
			in.append("empty tree!");
		}else{
			in = printHeap(minheap.peek(), in);
		}
		System.out.println(in.toString());

	}
	
	
	
	private StringBuffer printHeap(BinaryTree x, StringBuffer in){
		
		if( x == null ){
			return in;
		}else{
			
			printHeap(x.left, in);
			if(x.s == null){	//append the prob
				//in.append("a node with prob : " + x.prob + "\n");
			}else{
				in.append(x.s.element + " with prob : " + x.s.prob + " and code : " + x.s.code + "\n");
			}
			printHeap(x.right, in);
			return in;
		}
		
		
	}
	
	
	
	public class Symbol{
		char element;
		double prob; 
		String code = "";
		
		public Symbol(){}
		
		
		public Symbol(char element, double prob, String code){
			this.element = element;
			this.prob = prob;
			this.code = code;
		}
		
		
		public String stringify(){
			return ("symbol : " + element + ", prob : " + prob + ", code : " + code);
		}
		
	}
	
	
	
	public class BinaryTree implements Comparable<BinaryTree>{
		
		public double prob; 
		public Symbol s; 
		public BinaryTree left, right;
		
		public BinaryTree(double prob, Symbol s, BinaryTree left, BinaryTree right){
			this.prob = prob;
			this.s = s;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public int compareTo(BinaryTree o){
			return Double.compare(prob, o.prob);
		}
		
		
		@Override
		public boolean equals(Object obj){
			if(obj == null || !(obj instanceof BinaryTree)){
				return false;
			}
			return this == obj ? true : prob == ((BinaryTree)obj).prob;
		}
		
		
	}
	
	
	
	public static HashMap<String, Integer> alphaHashMap(HashMap<String, Integer> hm) {
		
		hm.put("a", 1);
		hm.put("b", 2);
		hm.put("c", 3);
		hm.put("d", 4);
		hm.put("e", 5);
		hm.put("f", 6);
		hm.put("g", 7);
		hm.put("h", 8);
		hm.put("i", 9);
		hm.put("j", 10);
		hm.put("k", 11);
		hm.put("l", 12);
		hm.put("m", 13);
		hm.put("n", 14);
		hm.put("o", 15);
		hm.put("p", 16);
		hm.put("q", 17);
		hm.put("r", 18);
		hm.put("s", 19);
		hm.put("t", 20);
		hm.put("u", 21);
		hm.put("v", 22);
		hm.put("w", 23);
		hm.put("x", 24);
		hm.put("y", 25);
		hm.put("z", 26);

		return hm;
	}
	

	public static void main(String[] args) {

		int[] frequencies = new int[27];	// 26 chars
		// double[] freqs = {0.0, 8.47,1.49,2.78,4.25,12.70,2.23,2.02,
		// 				6.09,6.97,0.15,0.77,4.03,2.41,6.75,
		// 				7.51,1.93,0.10,5.99,6.33,9.06,2.76,
		// 				0.98,2.36,0.15,1.97,0.07};
		
		HashMap<String, Integer> alpha = new HashMap<String, Integer>();
		alpha = alphaHashMap(alpha);
		String text = "azxcvbnmnbvcvbvfyukopolkjuhgtgfderewertyuikjhgfgfdvbnhjuytrewqa";
		
		// get the frequencies for each char
		for(int i = 0; i < text.length(); i++) {
			String c = "" + text.charAt(i);
			//System.out.print(c + " | ");
			frequencies[(Integer)alpha.get(c)]++; 
		}
		
		
		for(int j=0; j<frequencies.length; j++){
			
			//System.out.println( frequencies[j] );
		}
		
		//HuffmanCoding cd = new HuffmanCoding(frequencies);
		
		// HuffmanCoding cd2 = new HuffmanCoding(freqs);
		
	}

}
