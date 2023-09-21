// 2021 FALL CS 445 LAB #3  STUDENT STARTER FILE

import java.io.*;
import java.util.*;

public class LinkedList<T>
{
	private Node<T> head;  // pointer to the front (first) element of the list

	public LinkedList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// INSERTS NEW NODE AT FRONT PUSHING EXISTING NODES BACK ONE PLACE
	public void insertAtFront(T data)
	{
		head = new Node<T>(data,head);
	}

	// USE THE TOSTRING AS OUR PRINT
	public String toString()
	{
		String toString = "";

		for (Node<T> curr = head; curr != null; curr = curr.getNext())
		{
			toString += curr.getData();		// WE ASSUME OUR T TYPE HAS toString() DEFINED
			if (curr.getNext() != null)
				toString += " -> ";
		}

		return toString + "\n";
	}

	// ########################## Y O U   W R I T E    T H E S E    M E T H O D S ########################

	// TACK A NEW NODE ONTO THE END (CABOOSE) OF THE LIST
	public void insertAtTail(T data)
	{
		Node<T> curr = head;
		Node<T> newNode = new Node<T>(data);
		if(head == null){
			insertAtFront(data);
		}

		while(curr!=null){
			if(curr.getNext() == null){
				curr.setNext(newNode);
				break;
			}

			curr = curr.getNext();
			// if(curr.getNext()== null){
			// 	curr = newNode;
			// 	curr.setNext(null);
			// }
			// else{
			// 	curr = curr.getNext();
			// }

			}
		}
		// YOUR CODE HERE. MUST USE insertAtFront() IN BASE CASE
	

	// OF COURSE MORE EFFICIENT TO KEEP INTERNAL COUNTER BUT WE MAKE YOU 
	// COMPUTE IT DYNAMICALLY WITH A TRAVERSAL LOOP
	public int size()
	{
		Node<T> tempNode = head;
		int count = 0;
		while(tempNode!=null){
			count = count+1;
			tempNode=tempNode.getNext();
		}
		return count; // replace with your loop to count nodes
	}
	

	// MUST USE search() METHOD IN THIS CODE TO DETERMINE THE RETURN VALUE
	// NO LOOPS ALLOWED 
	public boolean contains( T key )
	{
		if(this.search(key) != null){
			return true;
		}
		else{
			return false;
		}
		 //JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE
	}

	// TRAVERSE LIST FRONT TO BACK LOOKING FOR THIS DATA VALUE.
	// RETURN REF TO THE FIRST NODE THAT CONTAINS THIS KEY. 
	// DO NOT- RETURN REF TO KEY ISIDE NODE
	// RETURN NULL IF NOT FOUND
	public Node<T> search( T key )
	{
		Node<T> tempNode = head;
		while(tempNode!=null){
			if(tempNode.getData()== key){
				return tempNode;
			}
			tempNode=tempNode.getNext();
		 //JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE
	}
		return tempNode;
	
}
} //END OF LINKEDLIST CLASS DEFINITION