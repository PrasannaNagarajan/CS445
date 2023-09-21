import java.io.*;
import java.util.*;

public class LinkedListTester
{
	public static void main( String args[] ) throws Exception
	{
		
		
		LinkedList<String> list_1 = new LinkedList<String>();
		Scanner infile_1 = new Scanner( new File( "set1.txt" ) );
		while ( infile_1.hasNext() )
				list_1.insertAtTail( infile_1.next() );
		infile_1.close();
		LinkedList<String> list_2 = new LinkedList<String>();
		Scanner infile_2 = new Scanner( new File( "set2.txt" ) );
		while ( infile_2.hasNext() )
				list_2.insertAtTail( infile_2.next() );
		infile_2.close();

	//  ECHO OUT BOTH LISTS - EACH LIST ON ITS OWN LINE 
	
	System.out.println( "list_1: " + list_1 ); // INVOKE THE LINKEDLIST CLASS's .toString
	System.out.println( "list_2: " + list_2 ); // INVOKE THE LINKEDLIST CLASS's .toString
	
	// THE 'MERGE' is REALLY INTERSECTION DONE IN O(N)

	// CREATE AND PRINT A THIRD LIST: THE "MERGE" this time is the SORTED INTERSECTION OF FIRST TWO LISTS
	LinkedList<String> theMerge = list_1.merge( list_2 );
	System.out.println( "merged: " + theMerge ); // PRINT THE SORTED INTERSECTION OF THE TWO LISTS
	
	//  ECHO OUT BOTH LISTS AGAIN JUST TO PROVE YOU DID NOT CORRUPT THEM IN THE MERGE CODE
	
	System.out.println( "list_1: " + list_1 ); // INVOKE THE LINKEDLIST CLASS's .toString
	System.out.println( "list_2: " + list_2 ); // INVOKE THE LINKEDLIST CLASS's .toString	
	
	} // END MAIN

	static void die( String errMsg )
	{
		System.out.println( errMsg );
		System.exit(0); // kills program
	}
} // EOF