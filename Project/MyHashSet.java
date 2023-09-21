import java.io.*;
import java.util.*;

public class MyHashSet implements HS_Interface
{	private int numBuckets; // changes over life of the hashset due to resizing the array
	private Node[] bucketArray;
	private int size; // total # keys stored in set right now

	// THIS IS A TYPICAL AVERAGE BUCKET SIZE. IF YOU GET A LOT BIGGER THEN YOU ARE MOVING AWAY FROM (1)
	private final int MAX_ACCEPTABLE_AVE_BUCKET_SIZE = 20;  // **DO NOT CHANGE THIS NUMBER**

	public MyHashSet( int numBuckets )
	{	size=0;
		this.numBuckets = numBuckets;
		bucketArray = new Node[numBuckets]; // array of linked lists
		System.out.format("IN CONSTRUCTOR: INITIAL TABLE LENGTH=%d RESIZE WILL OCCUR EVERY TIME AVE BUCKET LENGTH EXCEEDS %d\n", numBuckets, MAX_ACCEPTABLE_AVE_BUCKET_SIZE );
	}

	public boolean add( String key )
	{
		int hashed_key = hashOf(key, numBuckets);

		Node new_node = new Node(key, null);
  
		Node curr = bucketArray[hashed_key];

		if (contains(key)){
			return false;
		}
else{

    if (curr == null)
    {
        curr = new Node(key, null);
        
    }
 
    new_node.next = null;
  
  
    Node last = curr; 
    while (last.next != null)
        last = last.next;
  
    last.next = new_node;
    
}
		// your code here to add the key to the table and ++ your size variable

		++size; // you just added a key to one of the lists
		if ( size > MAX_ACCEPTABLE_AVE_BUCKET_SIZE * this.numBuckets)
			upSize_ReHash_AllKeys(); // DOUBLE THE ARRAY .length THEN REHASH ALL KEYS
		return true;
	}
	public boolean contains( String key )
	{	
		int hashed_key = hashOf(key, numBuckets);

		Node curr = bucketArray[hashed_key];
		while (curr != null) {
			if (curr.data.equals(key) ) {
				return true;
			}
			
			curr = curr.next;
		}

		
		return false;  // just to make it compile.
		// You hash this key. goto that list. look for this key in that list
	}

	private void upSize_ReHash_AllKeys()
	{	System.out.format("KEYS HASHED=%10d UPSIZING TABLE FROM %8d to %8d REHASHING ALL KEYS\n",
						   size, bucketArray.length, bucketArray.length*2  );
		Node[] biggerArray = new Node[ bucketArray.length * 2 ];
		this.numBuckets = biggerArray.length;

/*		FOR EACH LIST IN THE ARRAY
			FOR EACH NODE IN THAT LIST
				HASH THAT KEY INTO THE BIGGER TABLE
				BE SURE TO USE THE BIGGER .LENGTH AS THE MODULUS
*/
for (int i = 0; i < biggerArray.length; i++) {
	
}

Node current;
for (int i = 0; i < bucketArray.length; i++) {
	// Iterate through each node in that list
	for (current = bucketArray[i]; current != null; current = current.next) {
		
		// Hash that key into the bigger table
		int hashCode = hashOf(current.data, numBuckets);
		int index = Math.abs(hashCode % numBuckets);
		biggerArray[index] = current;
	}
}
		bucketArray = biggerArray;
	} // END OF UPSIZE & REHASH

	public boolean remove( String key )
	{
		int hashed_key = hashOf(key, numBuckets);
		Node previous = null;
		Node curr = bucketArray[hashed_key];
		while (curr != null) {
			if (curr.data.equals(key) ) {
				if(curr == bucketArray[hashed_key]){
					bucketArray[hashed_key] = curr.next;
				}
				else{
					previous.next = curr.next;
				}

				return true;
			}

			previous = curr;
			curr = curr.next;
			
		}
		return false;
	}
	public boolean isEmpty()
	{
		if (size() == 0) {
			return true;
		}
		else{
		return false;
		}
	}
	public void clear()
	{
		Node[] newbucketArray = new Node[numBuckets];

		 bucketArray = newbucketArray;
	}
	public int size()
	{
		return size;
	}	
	

	private int hashOf( String key, int numBuckets ) // h MUST BE IN [0..numBuckets-1]
	{
		int total = 0;
		for( int i=0 ; i<key.length() ; ++i )
		{
			int	asciiValue = key.charAt(i) - '\0'; // '\0' is  null char its asciiValue is zero.
			// if(asciiValue>0){
			// 	asciiValue = ((asciiValue/3^asciiValue)-(3^asciiValue));
			// }else{
			// 	asciiValue = ((asciiValue/-3^asciiValue)-(3^asciiValue));
			// }
			asciiValue *= 17 + key.charAt(i);//(((Math.abs(asciiValue)/3^Math.abs(asciiValue))-(3^asciiValue) << 3));
			asciiValue-=17;
			int weightedValue = asciiValue * (int)Math.pow( 26, key.length()-(1+i) ); // base 26 assumes only always lower case a..z
			total = total + weightedValue;
			// //System.out.format( "   '%c' = %3d * (%d^%d) = %-12d  total = %d",
		}

		return Math.abs(total) % numBuckets;
	}
} //END MyHashSet CLASS

class Node
{	String data;
	Node next;
	public Node ( String data, Node next )
	{ 	this.data = data;
		this.next = next;
	}
}





