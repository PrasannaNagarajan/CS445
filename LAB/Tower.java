import java.io.*;
import java.util.*;

public class Tower<T>
{
	private Disk<T> base;  // pointer to first disk at BASE of the tower (i.e. the old head pointer)
	private Disk<T> top;   // pointer to last disk at TOP of the tower   (i.e. the old tail pointer)

	public Tower()
	{	base = null; // compiler does this anyway. just for emphasis
	}

	public boolean empty()
	{
		return (base==null);
	}

	// i.e. the old insertAtTail or now insertAtTop we call it a PUSH
	public void push(T label)
	{
		// YOU WRITE THIS METHOD
		Disk<T> newDisk = new Disk<T>(label);

		if(base == null){
			base = newDisk;
			top = newDisk;
		}

		else{
			top.next =newDisk;
			top = newDisk;
		}
	}

	// i.e. the old removeAtTail or now removeAtTop we call it a POP
	public Disk<T> pop() throws Exception
	{
		if(base == null) {  
            System.out.println("List is empty");
			return null; 
        }  
        else {  
            //Checks whether the list contains only one element  
            if(base != top ) {  
                Disk<T> current = base;  
                //Loop through the list till the second last element such that current.next is pointing to tail  
                while(current.next != top) {  
                    current = current.next;  
                }  
                //Second last element will become new tail of the list  
                top = current;  
                top.next = null; 
				return top;
            }  
            //If the list contains only one element  
            //Then it will remove it and both head and tail will point to null  
            else {  
                base = top = null;
				return base;  
            }  
        }  
	}

	// prints the tower base to top, left to right,  respectively //
	public String toString()
	{	if (base == null ) 	return "EMPTY\t";
		String toString = "";
		for ( Disk<T> curr = base; curr != null ; curr=curr.next )
			toString += curr.label + " ";

		return toString;
	}
} // END TOWER CLASS

/*###############################################################################*/

class Disk<T>
{
	T label;
	Disk<T> next;

	Disk(T data)
	{	this( data, null );
	}

	Disk(T label, Disk<T> next)
	{	this.label = label;
		this.next = next;
	}

} // END DISK CLASS