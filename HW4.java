/*Hannah Posch
* HW 4, Summer 2018
* The code will use a main method to test the DoublyLinkedList class.
* The code will call the added functions several times with different cases and print the results.
* The textbook, Data Structures and Algorithm Analysis in Java, was consulted for this project.
*/

public class HW4 {
	
	/*
	 * main : This method will call the newly added functions to test them with various values. The
	 * results will be printed to the user to ensure the functions work correctly.
	 * @precondition: The method must instantiate a double linked list to continue.
	 */
	public static void main(String[] args) {
		final int HOWMANY = 4;

 	   DoublyLinkedList<String> d = new DoublyLinkedList<>(); //linkedList built
 	   String nodeLabel = "node";
 	   for (int i = 1; i <= HOWMANY; i++){
 		   d.insertAtFront(nodeLabel + (HOWMANY-i));
 	   }
 	   d.printContents();
 	   
 	   //add two nodes to front and back
 	   d.insertAtFront("newFront");
 	   d.insertAtFront("newFront2");
 	   d.addToBack("newBack");
 	   d.addToBack("newBack2");
 	   d.printContents();
 	   
 	   //remove node from front and back
 	   d.removeFromFront();
 	   d.removeFromBack();
 	   d.printContents();
 	   
 	   //remove two nodes from back
 	   d.removeFromBack();
 	   d.removeFromBack();
 	   d.printContents();
 	   
 	   //check items in front and back
 	   System.out.println("Item in front is: " + d.peekFront() + "\n");
 	   System.out.println("Item in back is: " + d.peekBack() + "\n");
 	   
 	   //remove from a variety of positions
 	   d.removeFromPosition(3);
 	   d.printContents();
 	   d.removeFromPosition(2);
 	   d.printContents();
 	   d.removeFromPosition(0);
 	   d.printContents();
 	   d.removeFromPosition(-5);
 	   d.printContents();
 	   d.removeFromPosition(20);
 	   d.printContents();
 	   
 	   //Empty list and try methods
 	   d.removeFromPosition(1);
 	   d.removeFromBack();
 	   d.printContents();
 	   System.out.println("Item in front is: " + d.peekFront() + "\n");
	   System.out.println("Item in back is: " + d.peekBack() + "\n");
	   d.removeFromPosition(1);
 	   d.removeFromBack();
 	   d.removeFromFront();
 	   d.printContents();
 	   
 	   //Then re-add to list and print
 	   d.insertAtFront("newFront3");
 	   d.insertAtPosition("at pos 1", 1);
	   d.addToBack("newBack");
	   d.printContents();
 	   	   
		
		
		
	}

}
