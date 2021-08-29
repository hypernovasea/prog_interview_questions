package src.misc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxRectangle {


	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(6);
		ll.add(2);
		ll.add(5);
		ll.add(4);
		ll.add(4);
		ll.add(1);
		ll.add(6);

		int maxArea = getMaxRectangle(ll);

		System.out.println("the max area is : " + maxArea);
	}

	public static int getMaxRectangle(List<Integer> A){

		Deque<Integer> s = new LinkedList<Integer>();
		int maxArea = 0;

		for(int i = 0; i<= A.size(); i++){
			while(!s.isEmpty() && (i == A.size() || A.get(i) < A.get(s.peekFirst()))){
				int height = A.get(s.peekFirst());
				System.out.println("height is : " + height);
				s.removeFirst();
				System.out.println("contending for max area is : " + (height * (s.isEmpty() ? i : i-s.peekFirst()-1)) );
				maxArea = Math.max(maxArea, height * (s.isEmpty() ? i : i-s.peekFirst()-1));
				System.out.println("so max area will be : " + maxArea);
			}
			s.addFirst(i);
		}

		return maxArea;
	}



}
