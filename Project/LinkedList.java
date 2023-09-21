import java.io.*;
import java.util.*;

// NOTICE THE "<T extends Comparable<T>>"
// using <T extends Comparable<T>> in here means compiler wont let the code in main send in any T type
// that does not implement Comparable.  Now we do not have to cast the incoming key to a Comparable
// in our insertInOrder() method. Compiler now lets us call .compareTo off the dot on the incoming key
// without throwing an error.

public class LinkedList<T extends Comparable<T>> 
{
	private Node<T> head;  // pointer to the front (first) element of the list

	public LinkedList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// LOAD LINKED LIST FROM INCOMING FILE
	@SuppressWarnings("unchecked")
	public LinkedList( String fileName, boolean orderedFlag )
	{	head = null;
		try
		{
			BufferedReader infile = new BufferedReader( new FileReader( fileName ) );
			while ( infile.ready() )
			{
				if (orderedFlag)
					insertInOrder( (T)infile.readLine() );  // WILL INSERT EACH ELEM INTO IT'S SORTED POSITION
				else
					insertAtTail( (T)infile.readLine() );  // TACK EVERY NEWELEM ONTO END OF LIST. ORIGINAL ORDER PRESERVED
			}
			infile.close();
		}
		catch( Exception e )
		{
			System.out.println( "FATAL ERROR CAUGHT IN C'TOR: " + e );
			System.exit(0);
		}
	}

	//-------------------------------------------------------------

	// inserts new elem at front of list - pushing old elements back one place

	public void insertAtFront(T data)
	{
		head = new Node<T>(data,head);
	}

	// we use toString as our print

	public String toString()
	{
		String toString = "";

		for (Node<T> curr = head; curr != null; curr = curr.next )
		{
			toString += curr.data;		// WE ASSUME OUR T TYPE HAS toString() DEFINED
			if (curr.next != null)
				toString += " ";
		}

		return toString;
	}

	// ########################## Y O U   W R I T E    T H E S E    M E T H O D S ########################



	public int size() // OF COURSE MORE EFFICIENT to KEEP COUNTER BUT YOU  MUST WRITE LOOP
	{
		Node<T> tempNode = head;
		int count = 0;
		while(tempNode!=null){
			count = count+1;
			tempNode=tempNode.next;
		}
		return count; // YOUR CODE HERE
	}

	public boolean empty()
	{
		if(size() == 0){
			return true;
		}
		else{
			return false;
		}  // YOUR CODE HERE
	}

	public boolean contains( T key )
	{
		if(this.search(key) != null){
			return true;
		}
		else{
			return false;
		}  // YOUR CODE HERE
	}

	public Node<T> search( T key )
	{
		Node<T> tempNode = head;
		while(tempNode!=null){
			if(tempNode.data.equals(key)){
				return tempNode;
			}
			tempNode=tempNode.next;
		 //JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE
	}
		return null;  // YOUR CODE HERE
	}

	// TACK A NEW NODE (CABOOSE) ONTO THE END OF THE LIST
	public void insertAtTail(T data)
	{
		Node<T> curr = head;
		Node<T> newNode = new Node<T>(data);
		if(head == null){
			insertAtFront(data);
		}

		while(curr!=null){
			if(curr.next == null){
				curr.next = newNode;
				break;
			}

			curr = curr.next;
		// YOUR CODE HERE
	}
}

	// IF YOU DEFINE <T> at the top of this class as <T implements Comparable>
	// YOU DO NOT HAVE TO CAST TO COMPARABLE AND YOU DO NOT NEED TO SUPPRESS 
	public void insertInOrder(T  data)
	{
		Node<T> newNode = new Node<T>(data);

// 		if(head != null){
// 		if(curr.data.compareTo(data) == -1){
// 			insertAtFront(data);
// 		}

// 	}
// 	else{
// 		head = newNode;
// 	}

// 		while(curr!=null){
// 			if(curr.next == null){
// 				curr.next = (newNode);
// 				break;
// 			}
// 			else{
// 				if(curr.data.compareTo(data) == 1){
// 					newNode.next = (curr.next);
// 					curr.next = (newNode);
// 					break;
					
// 				}
// 				else{
// 					curr = curr.next;

// 				}
	
// 			}
// 		// YOUR CODE HERE
// 	}
// }

// if head is null 
	//head = newNode;
// head.next is null
	// check against head
//check rest of list
	//get prev and head to then go through the loop


if(head == null){
	head = newNode;
	return;
}

if(head.next == null || head.data.compareTo(data) == 1){
		insertAtFront(data);
		return;
}

Node<T> prev = head;
Node<T> curr = head.next;


	while(curr!=null){

		if(curr.data.compareTo(data) == 1){
			prev.next = newNode;
			newNode.next = curr;
			return;
		}

		else{
			prev = prev.next;
			curr = curr.next;
		}
	}

	prev.next = newNode;
	


	}

	public boolean remove(T key)
	{


		if(this.contains(key) == true){
			return true;
			
		}
		else{
			return false;
		} //  REPLACE WITH YOUR CODE 

		//check about head
		//check is key is head
		//
	}

	public boolean removeAtTail()	// RETURNS TRUE IF THERE WAS NODE TO REMOVE
	{

		Node<T> curr = head;

		while(curr!=null){
			if(curr.next == null){
				curr = null;
				break;
			}

			curr = curr.next;
		 // YOUR CODE HERE
	}
		return false;
}

	public boolean removeAtFront() // RETURNS TRUE IF THERE WAS NODE TO REMOVE
	{
		
		return false; // YOUR CODE HERE
	}

	public LinkedList<T> union( LinkedList<T> other )
	{
		LinkedList<T> union = new LinkedList<T>();

		
	
	
			// for(int i = 0;i<this.size();i++){
			// 	union.insertInOrder();
			// }
	
			// for(int i = 0;i<other.size();i++){
			// 	if(union.contains(other.theArray[i])){
			// 		continue;
			// 	}
			// 	else{
			// 		union.add(other.theArray[i]);
			// 	}
						
			// }
			// YOUR CODE HERE TO LOOP ACROSS THIS & OTHER SET - AND PUT THE UNION OF THE
			// 2 SETS INTO THE RESULT SET TO BE RETURNED

		return union;
	}
	public LinkedList<T> inter( LinkedList<T> other )
	{
		LinkedList<T> inter = new LinkedList<T>();

	// 	// YOUR LOOPS HERE
	// 	for(int i = 0; i<this.size();i++){
	// 		if(other.contains(this.theArray[i])){
	// 			inter.add(this.theArray[i]);
	// 		}
	// }

		return inter;
	}
	public LinkedList<T> diff( LinkedList<T> other )
	{
		LinkedList<T> diff = new LinkedList<T>();
		
	// 	for(int i = 0; i<this.size();i++){
	// 		if(other.contains(this.theArray[i])){
	// 			continue;
	// 		}
	// 		else{
	// 			diff.add(this.theArray[i]);
	// 		}
		
	// }



		// YOUR CODE HERE

		return diff;
	}
	public LinkedList<T> xor( LinkedList<T> other )
	{
		return union(other).diff(inter(other)); // REPLACE WITH YOUR CODE 

	}

} //END LINKEDLIST CLASS 

// A D D   N O D E   C L A S S  D O W N   H E R E 
// R E M O V E  A L L  P U B L I C  &  P R I V A T E (except toString)
// R E M O V E  S E T T E R S  &  G E T T E R S 
// M A K E  T O  S T R I N G  P U B L I C

class Node<T extends Comparable<T>> // tells compiler our incoming T type implements Comparable

{
   T data;
   Node<T> next;

   Node()
  {
    this( null, null );
  }

   Node(T data)
  {
    this( data, null );
  }

  Node(T data, Node<T> next)
  {
	this.data = data;
	this.next = next;
  }

 
  public String toString()
  {
	  return ""+ data;
  } 
	 
} //EOF