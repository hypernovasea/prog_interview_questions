
public class SinglyLinkedListDriver{

	public static void main(String[] args){
		
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.add(3);
		sll.add(6);
		sll.add(8);
		sll.add(10);		
		sll.add(18);
		
		System.out.println(sll.toString());
		
		sll.addAtIndex(3, 7);
		
		System.out.println(sll.toString());
		
		sll.add(22);
		
		System.out.println(sll.toString());
	
		sll.addAtIndex(0, 22);
		
		System.out.println(sll.toString());
		
		sll.addAtIndex(0, 44);
		
		System.out.println(sll.toString());
		
		System.out.println(sll.getSize());
		
		System.out.println(sll.get(3));
		
		
		
		
		SinglyLinkedList sll1 = new SinglyLinkedList();
		sll1.add(3);
		System.out.println(sll1.getSize());
		System.out.println(sll1.toString());
		
		sll1.reverse();
	}

}