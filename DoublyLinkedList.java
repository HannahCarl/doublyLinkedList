/*Hannah Posch
* HW 4, Summer 2018
* The code will utilize a double linked list to keep a collection of nodes. The nodes will be utilized in a variety 
* of functions that add, remove, and peek at various elements of the list.
* The textbook, Data Structures and Algorithm Analysis in Java, was consulted for this project.
*/
/**
 * DoublyLinkedList can contain any type of data, but all data must be of the same type.
 * Based on the model provided by Weiss (see pictures, page 76) "dummy" nodes are included.
 * 
 * Data is stored in a doubly-linked list with both head and tail pointers.
 * 
 * @ R McCauley built shell
 */
public class DoublyLinkedList<AnyType> extends HW4_AbstractClass<AnyType> {
    
    /******** an inner class  **********************
     * The node type for a doubly linked list 
     */
    private static class Node<AnyType> {
        
        public Node(AnyType x, Node p, Node n) {
            data = x; prev = p; next = n;           
        }
        
        public AnyType data;
        public Node<AnyType> next;
        public Node<AnyType> prev;
    }
    /**********************************************************/
    
    // The DoublyLinkedList contains a reference to the both the front and back nodes in the list.
    
    private DoublyLinkedList.Node<AnyType> head; // front marker
    private DoublyLinkedList.Node<AnyType> tail; // back marker
    private int length; // how many nodes in the list
    
    /**
     * Constructor allocates initializes front reference
     */
    public DoublyLinkedList () {
         
        head = new DoublyLinkedList.Node<AnyType>(null, null, null);  
        tail = new DoublyLinkedList.Node<AnyType>(null, head, null); 
        head.next = tail;
        length = 0;    // no nodes in list
	}
    
    /**
     * Reports number of nodes in the list
     * @return
     */
    public int length(){
    	  return length;
    }
    
    /**
     *  The following routine is used to mock-up a 
     *  doubly linked list that can be used to test your remove algorithm
     */
    /*
	 * insertAtFront : This method adds a node containing data x at the front of the list.
	 * The length is increased as well. 
	 * @param: a data node to be added
	 */
    public void insertAtFront(AnyType value){ 
    	// Each node stores a null reference, since AnyType could be any type
        DoublyLinkedList.Node<AnyType> temp = new DoublyLinkedList.Node<>(value, head, head.next); // will be the first node

        head.next = temp;
	    temp.next.prev = temp;
    	length++;
    } 
    /*
	 * printContents : This method prints the list from front to back, as well as,
	 * from back to front. The length of the list is also printed.
	 */
    public void printContents (){
    	
    	   System.out.println("Printing front to back, start of list:");
    	   DoublyLinkedList.Node<AnyType> walker = head.next; // don't print dummy
    	   while (walker != tail){
           // assumes AnyType is printable - has a toString
    		   System.out.println(walker.data);
    		   walker = walker.next;
    	   }
    	   
    	   System.out.println("Printing back to front, start of list:");
    	   walker = tail.prev; // don't print dummy
    	   while (walker != head){
    		   System.out.println(walker.data);
    		   walker = walker.prev;
    	   }
    	   
    	   System.out.println("List has "+ length +" nodes.\n===="); 
    } // end howLong
    /*
	 * insertAtPosition : This method adds a node containing data x at the position provided.
	 * The length is increased as well. 
	 * @param: a data node to be added and a position
	 */
    public void insertAtPosition(AnyType x, int pos) {
    	
	    	if (pos < 1 || pos > length + 1)
	    		return;
	    	// Find position - point to node before where this node
	    	// goes
	    	int count = 1;
	    	DoublyLinkedList.Node<AnyType> walker = head;
	    	while (count < pos) {
	    		walker = walker.next;
	    		count++;
	    	}
	    	// Create new node
	    	DoublyLinkedList.Node<AnyType> temp = new DoublyLinkedList.Node<>(x,walker, walker.next);
	    	temp.next.prev = temp;
	    	temp.prev.next = temp;
	    	length++;
    	
    }//end of insertAtPosition
    
    /*
	 * addToBack : This method adds a node containing data x at the end of the list.
	 * The length is increased as well. 
	 * @param: a data node to be added
	 */
	public void addToBack(AnyType x) {
		//new node created
		DoublyLinkedList.Node<AnyType> temp = new DoublyLinkedList.Node<>(x, tail.prev, tail); 
		
		//node added to back and connected
        tail.prev = temp;
	    temp.prev.next = temp;
	    
    		length++;//length increased
    		
	}//end of addToBack
	
	/*
	 * removeFromFront : This method removes the first data node in the list and decreases
	 * the length. If the list is empty, the method terminates.
	 * @precondition: The list must not be empty for function to do something.
	 */
    public void removeFromFront() {
    		//check if list is empty
    		if(length > 0) {
    			
	    		DoublyLinkedList.Node<AnyType> walker = head; //new node created to walk forward past node being removed
	    		//walker connects to head
	    		walker=walker.next.next;
	    		walker.prev = head;
	    		head.next = head.next.next;
	    		
	    		length--; //length decreased
    		}
    }//end of removeFromFront
    
    /*
	 * removeFromBack : This method removes the last data node in the list and decreases
	 * the length. If the list is empty, the method terminates.
	 * @precondition: The list must not be empty for function to do something.
	 */
    public void removeFromBack() {
    		//check if list is empty
    		if(length > 0) {
	    		DoublyLinkedList.Node<AnyType> walker = tail; //new node created at tail to walk in front of node being removed
	    		//walker connects to tail
	    		walker=walker.prev.prev;
	    		walker.next=tail;
	    		tail.prev = tail.prev.prev;
	    		
	    		length--; //length decreased
    		}
    }//end of removeFromBack
    
    /*
	 * peekFront : This method returns the data item in the first node. Null
	 * is returned in the list is empty.
	 * @precondition: The list must not be empty for function to actually check data at front.
	 * @return: Data item in the first node.
	 */
    public AnyType peekFront() {
    		//check if list is empty
    		if(length > 0 ) {
    			
    			return head.next.data; //returns data in first node
    		}
    		else {
    			return null;
    		}
    }//end of peekFront
    
    /*
	 * peekBack : This method returns the data item in the last node. Null
	 * is returned in the list is empty.
	 * @precondition: The list must not be empty for function to actually check data at back.
	 * @return: Data item in the last node.
	 */
    public AnyType peekBack() {
    		//check if list is empty
	    	if(length > 0 ) {
			
			return tail.prev.data; //returns data in last node
			}
		else {
			return null;
			}
    }//end of peekBack
    
    /*
	 * removeFromPosition : This method removes the node at position pos.
	 * The method also decreases the length.
	 * @param: The position
	 * @precondition: The position must be between 1 and the length of the list.
	 */
    public void removeFromPosition (int pos) {
    		//check if postion is valid
	    	if (pos < 1 || pos > length)
	    		return;
	    	
	    	
	    	// Find position - Walker points to node before node being removed
	    	// Follower points to node after node being removed
	    	int count = 1;
	    	DoublyLinkedList.Node<AnyType> follower = head;
	    	DoublyLinkedList.Node<AnyType> walker = head.next.next;
	    	while (count < pos) {
	    		walker = walker.next;
	    		follower = follower.next;
	    		count++;
	    	}
	    //Walker and follower are connected
	    walker.prev = follower;
	    	follower.next = walker;
	    	
	    	length--; //Length decreased
    	
    }//end of removeFromPosition
      
    // This is the main method used to test in class.
    // For HW4, you must create a main in a new HW4 class
    public static void main(String[] args){
    	   /*final int HOWMANY = 4;

    	   DoublyLinkedList<String> d = new DoublyLinkedList<>();
    	   String nodeLabel = "node";
    	   for (int i = 1; i <= HOWMANY; i++){
    		   d.insertAtFront(nodeLabel + (HOWMANY-i));
    	   }
    	   d.printContents();
    	   d.insertAtFront("newFront");
    	   
    	   d.addToBack("back");
    	   d.addToBack("back2");
    	   d.printContents();
    	   
    	   d.printContents();
    	   d.removeFromFront();
    	   d.removeFromBack();
    	   d.printContents();
    	   d.removeFromBack();
    	   d.printContents();
    	   System.out.println("Item in front is: " + d.peekFront() + "\n");
    	   System.out.println("Item in back is: " + d.peekBack() + "\n");
    	   d.removeFromPosition(3);
    	   d.removeFromPosition(3);
    	   d.removeFromPosition(2);
    	   d.removeFromPosition(1);
    	   d.removeFromPosition(1);
    	   d.printContents();
    	   
    	   d.insertAtPosition("at pos 1", 1);
    	   d.printContents();
    	   d.insertAtPosition("at pos 3", 3);
    	   d.printContents();
    	   d.insertAtPosition("at last pos ", d.length+1);
    	   d.printContents();
    	   d.insertAtPosition("nowhere", 25);
    	   d.printContents();
    	   d.insertAtPosition("nowhere", -4);
    	   d.printContents(); 	   */
    }

	
}
