// 2022 FALL CS 445 PROJECT #8 
// GRAPHLLTESTER.JAVA
// TESTS ALL THE METHODS OF THE GRAPHLL CLASS
// THIS IS THE TESTER USED BY THE GRADING SCRIPT FOR PROJECT #8
// ** NOTE WE USE THE SAME CODE AS THE GRAPH2D TESTER FROM AN EARLIER ASSIGNMENT

import java.io.*;
import java.util.*;
class GraphLLTester
{   
	public static void main( String args[] ) throws Exception
	{
	if (args.length < 1) 
	{
		System.out.println("usage: must enter filename on command line.");
		System.exit(0);
	}
     
	GraphLL myGraph = new GraphLL( args[0] );
	System.out.print( myGraph ); //		
	System.out.println();
	System.out.println("maxOutDegree: " + myGraph.maxOutDegree() );
	System.out.println("minOutDegree: " + myGraph.minOutDegree() );
	System.out.println("maxInDegree: " + myGraph.maxInDegree() );
	System.out.println("minInDegree: " + myGraph.minInDegree() );
	System.out.println("maxDegree: " + myGraph.maxDegree() );
	System.out.println("minDegree: " + myGraph.minDegree() );

	System.out.println("\nremoving edge 3 -> 5");
	myGraph.removeEdge( 3, 5 );	// SHOULD NOT THROW EXCEPTION 
	System.out.println("Graph after removing edge 3 -> 5");
	System.out.print( myGraph );

	System.out.println("\nremoving edge 6 -> 1");
	myGraph.removeEdge( 6, 1 ); // SHOULD NOT THROW EXCEPTION 
	System.out.println("Graph after removing edge 6 -> 1");
	System.out.print( myGraph );

	System.out.println("\nremoving edge 17 -> 6");
	myGraph.removeEdge( 17, 6 );// THIS -DOES- THROW AN EXCEPTION
	
} // END main

} // END GRAPHTESTER CLASS

