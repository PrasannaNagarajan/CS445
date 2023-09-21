import java.io.*;
import java.util.*;

public class LinkedListTester
{
	public static void main( String args[] ) throws Exception
	{
		// if ( args.length < 2 )
		// 	die( "FATAL ERROR: must enter two filenames on command line.\n   java LinkedListTester set1.txt  set2.txt\n" );
		LinkedList<String> myList = new LinkedList<String>();
		// READ IN THE FILE NAMED BY args[0]
		BufferedReader infile0 = new BufferedReader( new FileReader( "set1.txt" ) );
		while ( infile0.ready() )
				myList.insertAtTail( infile0.readLine() );
		infile0.close();

		System.out.println( "myList loaded from " + "set1.txt" );
		System.out.println("myList: (contains " + myList.size() + " elements) " +  myList ); // invokes toString

		// NOW READ IN THE FILE NAMED BY args[1]
		BufferedReader infile1 = new BufferedReader( new FileReader( "set2.txt" ) );
		System.out.println( "Searching myList for the following words from " + "set2.txt" );
		while (infile1.ready() )
		{
			String word = infile1.readLine();
			if ( myList.contains( word ) )
				System.out.println( word + "\tfound" );
			else
				System.out.println( word + "\tNOT found" );
		}
		infile1.close();
	} // END MAIN

	static void die( String errMsg )
	{
		System.out.println( errMsg );
		System.exit(0); // kills program
	}
} // EOF