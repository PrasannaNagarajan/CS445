import java.io.*;
import java.util.*;

import javax.xml.crypto.Data;

public class TreeSetOps
{
	public static void main( String args[] ) throws Exception
	{
		BufferedReader infile1 = new BufferedReader( new FileReader( args[0]) );
		BufferedReader infile2 = new BufferedReader( new FileReader( args[1] ) );

		TreeSet<String> set1 = loadSet( infile1 );
		TreeSet<String> set2 = loadSet( infile2 );
		printSet( "set1: ",set1 );
		printSet( "set2: ",set2 );

		TreeSet<String> union = union( set1, set2 );
		printSet( "\nunion: ", union );

		TreeSet<String> intersection = intersection( set1, set2 );
		printSet( "\nintersection: ",intersection );

		TreeSet<String> difference = difference( set1, set2 );
		printSet( "\ndifference: ",difference );

		TreeSet<String> xor = xor( set1, set2 );
		printSet("\nxor: ", xor );

		System.out.println( "\nSets Echoed after operations.");

		printSet( "set1: ", set1 );
		printSet( "set2: ", set2 );

	}// END MAIN

	// Y O U    W R I T E   T H I S     M E T H O D

	static TreeSet<String> loadSet( BufferedReader infile ) throws Exception
	{
		String str;
		 TreeSet<String> foo = new TreeSet<>();
		//  int count = 0;
		// while (infile.readLine() != " ") {
		// 	a[count] = infile.readLine();
		// 	count++;
		// }
		List<String> list = new ArrayList<String>();
		while((str = infile.readLine()) != null){
    	list.add(str);
		}

		for(String i : list){
			foo.add(i);
		}


		return foo;
	}

	// Y O U    W R I T E   T H I S     M E T H O D
	static void printSet( String caption, TreeSet<String> set )
	{
		System.out.print(caption);
// 		for(String number : set){
//             System.out.print(number+ " ");
// 	}

String[] array =set.toArray( new String[set.size()] );
 
//display array
for (int i = 0; i < array.length; i++) {
	System.out.print(array[i] + " ");
}
System.out.println();
	}
	


	// Y O U    W R I T E   T H I S     M E T H O D
	static TreeSet<String> union( TreeSet<String> set1, TreeSet<String> set2 )
	{
		// YOU ARE NOT ALLOWED TO MODIFY this set. MAKE A COPY OF this set
		// NO LOOPS ALLOWED

		// create a deep copy of this TreeSet
		// apply the built in method(s) to modify it to be the union or intersect or diff or xor
		// return the modified version of the this set that has been transformed into a union or diff etc
		// NO LOOP ALLOWED. should really be only about 3 lines or so of code
		TreeSet<String> union = new TreeSet<>();
		union.addAll(set1);
        union.addAll(set2);


		return union;  // JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE

	}

	static TreeSet<String> intersection( TreeSet<String> set1, TreeSet<String> set2 )
	{
		// YOU ARE NOT ALLOWED TO MODIFY this set. MAKE A COPY OF this set
		// NO LOOPS ALLOWED

		// create a deep copy of this TreeSet
		// apply the built in method(s) to modify it to be the union or intersect or diff or xor
		// return the modified version of the this set that has been transformed into a union or diff etc
		// NO LOOP ALLOWED. should really be only about 3 lines or so of code
		TreeSet<String> intersection = new TreeSet<>();
        intersection.addAll(set1);
        intersection.retainAll(set2);

		return intersection;  // JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE
	}

	static TreeSet<String> difference( TreeSet<String> set1, TreeSet<String> set2 )
	{
		// YOU ARE NOT ALLOWED TO MODIFY this set. MAKE A COPY OF this set
		// NO LOOPS ALLOWED

		// create a deep copy of this TreeSet
		// apply the built in method(s) to modify it to be the union or intersect or diff or xor
		// return the modified version of the this set that has been transformed into a union or diff etc
		// NO LOOP ALLOWED. should really be only about 3 lines or so of code

		TreeSet<String> difference = new TreeSet<>();

		difference.addAll(set1);
		difference.addAll(set2);
        difference.retainAll(set1);


		return difference ;  // JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE
	}

	static TreeSet<String> xor( TreeSet<String> set1, TreeSet<String> set2 )
	{
		TreeSet<String> xor = new TreeSet<>();

		TreeSet<String> a = union(set1, set2);
		TreeSet<String> b = intersection(set1, set2);

		xor = difference(a, b);

		return xor;  // JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE
	}


} // END CLASS