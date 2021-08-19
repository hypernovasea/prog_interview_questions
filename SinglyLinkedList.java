
public class SinglyLinkedList {

	Node head;
	int size = 0;
	
	public SinglyLinkedList(){
		head = null;
	}
	
	
	public SinglyLinkedList(int data){
		Node newNode = new Node(data, null);
		head = newNode;
		size++;
	}
	
	
	//add to end of the list
	public boolean add(int data){
		
		//adding to empty list
		if(head == null){
			Node newNode = new Node(data, null);
			head = newNode;
			size++;
			return true;
		}
		
		
		//adding to non-empty list
		Node temp = head;
		while(temp != null){
			
			//found end of list, add data to it
			if(temp.next == null){
				Node newNode = new Node(data, null);
				temp.next = newNode;
				size++;
				return true;
			}else{
				temp = temp.next;
			}
		}
		
		return false;
		
	}
	
	
	//add particular index
	public boolean addAtIndex(int data, int index){
		
		//check if index is positive and within bounds
		if(index < 0 || index > (size-1)){
			System.out.println("Index not valid!");
			return false;
		}
		
		
		//check if list is empty
		if(head == null && index != 0){
			System.out.println("List is empty!");
			return false;
		}
		
		Node temp = head;
		Node prev = null;
		for(int i=0; i<size; i++){
			
			//found the place to insert after
			if(i == index){
				Node newNode = new Node(data);
				newNode.next = temp;
				prev.next = newNode;
				size++;
				
			}else{
				prev = temp;
				temp = temp.next;
			}
		}
		return true;
	
		
	}
	
	
	//deletes first occurrence of data
	public int delete(int data){
		
		//check if list is empty
		if(head == null){
			System.out.println("List is already empty!");
			return -99; 
		}
		
		//if head is only one in list
		if(size == 1 || head.data == data){
			int deleted = head.data;
			head = head.next;
			size--;
			return deleted;
		}
		
		
		Node temp = head;
		Node prev = null;
		for(int i=0; i<size; i++){
			
			if(temp.data == data){
				prev.next = temp.next;
				size--;
				break;
			}else{
				prev = temp;
				temp = temp.next;
			}
		}
		
		return data;
	}
	
	
	//delete a particular index
	public int deleteAtIndex(int index){
		//check if list is empty
		if(head == null){
			System.out.println("List is empty!");
			return -99; 
		}
		
		//check if index is valid
		if(index < 0 || index > size-1){
			System.out.println("Index is invalid!");
			return -99;
		}
				
		//if head is only one in list or head is being deleted
		if(size == 1 || index == 0){
			int deleted = head.data;
			head = head.next;
			size--;
			return deleted;
		}
		
		Node temp = head;
		Node prev = null;
		int deleted=0;
		for(int i=0; i<size && temp != null; i++){
			
			if( i == index ){
				deleted = temp.data;
				prev.next = temp.next;
				size--;
			}else{
				prev = temp;
				temp = temp.next;
			}
		}
		
		return deleted;
	}
	
	
	//retrieve data at a specified index
	public int get(int index){
		
		if(index < 0 || index > size-1){
			System.out.println("Invalid index!!");
			return -99;
		}
		
		
		if(head == null){
			System.out.print("List is empty!");
			return -99;
		}
		
		Node temp = head;
		int data=0;
		for(int i=0; i<size; i++){
			
			if(i==index){
				data = temp.data;
				break;
			}else{
				temp = temp.next;
			}
		}
		
		return data;
	}
	
	
	

	public void print(){
		
		
		if(head != null){
			System.out.println("+++++++++++++++++++++++++");
			Node temp = head;
			for(int i=0; i<size; i++){
				System.out.print(temp.data + "  ");
				temp = temp.next;
			}
			System.out.println("\n+++++++++++++++++++++++++\n\n");
		}else{
			System.out.println("List is empty!");
		}
		
	}
	
	
	
	private void print( Node start ){
		
		Node temp = start;
		while(temp != null){
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
	}
	
	
	
	
	public void reverse(){
		Node reversed = reverse( head );
		print( reversed );	
	}
	

	private Node reverse(Node head){

		if(head == null || head.next == null )	return head;

		Node second = head.next;
		head.next = null;

		Node rest = reverse( second );
		second.next = head;

		return rest;

	}
	
	
	
	public int getSize(){
		return size;
	}
	
	
	public int getHead(){
		if(head != null){
			return head.data;
		}
		return -99;
	}
	
	
	
	
	
	private static class Node{
		
		private int data;
		private Node next;
		
		public Node(int data){
			this.data = data;
			next = null;
		}
		
		
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
		
		
		
	}	//end static class Node

}


	
	
	
	
