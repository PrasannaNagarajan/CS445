// 2021 FALL CS 445 LAB #3  STUDENT STARTER FILE

import java.io.*;
import java.util.*;

public class LinkedList<T extends Comparable<T>>
{
	private Node<T> head;  // pointer to the front (first) element of the list
	private Node<T> tail;  // pointer to the last elem of the list ( caboose or tail node)

	public LinkedList()
	{
		head = null; // compiler does this anyway. just for emphasis
		tail = head;
	}

	// USE THE TOSTRING AS OUR PRINT
	public String toString()
	{
		String toString = "";

		for (Node<T> curr = head; curr != null; curr = curr.next)
		{
			toString += curr.data;		// WE ASSUME OUR T TYPE HAS toString() DEFINED
			if (curr.next != null)
				toString += " -> ";
		}

		return (String) (toString + " ");
	}
	
	// ########################## Y O U   W R I T E   T H E S E    M E T H O D S  
	// . . .AND ANY SUPPORTING METHODS YOU NEED FOR THEM 

	// THIS VERSION JUST LOADS THE LISTS FROM THE FILE BEFORE THEY ARE MERGED
	public void insertAtTail( T data )
	{
		Node<T> newNode = new Node<T>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
		// THIS INSERT AT TAIL HAD BETTER BE O(1)  USE THE GLOBAL TAIL POINTER	
	}
	public LinkedList<T> merge( LinkedList<T> other )  // think 'sorted intersection' but only 1 pass allowed
	{
		LinkedList<T> mergedList = new LinkedList<>();
        Node<T> curr1 = this.head;
        Node<T> curr2 = other.head;

        while (curr1 != null && curr2 != null) {
            int cmp = curr1.getData().compareTo(curr2.getData());

            if (cmp == 0) {
                mergedList.insertAtTail(curr1.getData());
                curr1 = curr1.getNext();
                curr2 = curr2.getNext();
            } else if (cmp < 0) {
                curr1 = curr1.getNext();
            } else {
                curr2 = curr2.getNext();
            }
        }

        return mergedList;
    }
	
	private void insert(T data, Node<T> prev) {
        Node<T> newNode = new Node<T>(data);
        if (prev == null) {
            newNode.setNext(head);
            head = newNode;
        } else {
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        }
    }

} //END OF LINKEDLIST CLASS DEFINITION

// NODE CLASS
 class Node<T>
{
  T data;
  Node<T> next;

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
	  return "" + data; // stringify the data
  } 
  public void setNext(Node<T> next) {
	this.next = next;
}
public T getData() {
	return  data;
}
public Node<T> getNext() {
	return next;
}


	 
} //EOF