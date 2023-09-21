/* This class was borrowed and modified as needed with permission from it's original author
   Mark Stelhik ( http:///www.cs.cmu.edu/~mjs ).  You can find Mark's original presentation of
   this material in the links to his S-01 15111,  and F-01 15113 courses on his home page.
*/

import java.io.*;
import java.util.*;

public class Graph 
{
	private final int NO_EDGE = -1; // all real edges are positive
	private int G[][];              // will point to a 2D array to hold our graph data

	private int numEdges;
	public Graph( String graphFileName ) throws Exception  // since readFild doesn't handle them either
	{
		loadGraphFile( graphFileName );
		
//		T E M P O R A R Y    C O D E    T O    V E R I F Y    P R I V A T E 
// 		M E T H O D S    W E    C A N T    C A L L    F R O M   T E S T E R 
//		      ........R E M O V E   A F T E R   T E S T I N G .......
/*
		for (int node = 0 ; node < G.length ; ++node )
		{
			System.out.format( "DEBUG:: in (%d)=%d  ",node,inDegree(node) );
			System.out.format( "out(%d)=%d  ",node,outDegree(node) );
			System.out.format( "deg(%d)=%d\n",node,degree(node) );
		}
*/
	}

	///////////////////////////////////// LOAD GRAPH FILE //////////////////////////////////////////
	//
	// FIRST NUMBER IN GRAPH FILE IS THE SQUARE DIMENSION OF OUR 2D ARRAY
	// THE REST OF THE LINES EACH CONTAIN A TRIPLET <ROW,COL,WEIGHT> REPRESENTING AN EDGE IN THE GRAPH

	private void loadGraphFile( String graphFileName ) throws Exception
	{
		Scanner graphFile = new Scanner( new File( graphFileName ) );

		int dimension = graphFile.nextInt();   	// THE OF OUR N x N GRAPH
		G = new int[dimension][dimension]; 		// N x N ARRAY OF ZEROS
		numEdges=0;

		// WRITE A LOOP THAT PUTS NO_EDGE VALUE EVERYWHERE EXCPT ON THE DIAGONAL

		for(int i = 0; i<G.length;i++){
			for(int j = 0; j<G[i].length;j++){
				if (i == j) {
					G[i][j] = 0;
				}
				else{
					G[i][j] = -1;
				}
			}
		}
	

		// NOW LOOP THRU THE FILE READING EACH TRIPLET row col weight FROM THE LINE
		// USE row & col AS WHERE TO STORE THE weight
		// i.e. g[row][col] = w;

		while ( graphFile.hasNextInt() )
		{
			int row = graphFile.nextInt();
			int col = graphFile.nextInt();

			int weight = graphFile.nextInt();
			// read in the row,col,weight // that eat us this line
			// call add edge
			addEdge(row, col, weight);
			
		}

	} // END readGraphFile

	private void addEdge( int r, int c, int w )
	{
		G[r][c] = w;
		++numEdges; // only this method adds edges so we do increment counter here only
	}
	
  private boolean hasEdge(int fromNode, int toNode)
  {
    if (G[fromNode][toNode] == -1) {
		return false;
	}
	else{
		return true;
	}
  }

	// IN DEGREE IS NUMBER OF ROADS INTO THIS CITY
	// NODE IS THE ROW COL#. IN DEGREE IS HOW MANY POSITIVE NUMBERS IN THAT COL
	private int inDegree(int node)
	{
		int count = 0;

		for(int i = 0; i < G.length;i++){
			if (G[i][node] > 0 ) {
				count++;
			}
			else{
				continue;
			}
		}
		return count;
	}

	// OUT DEGREE IS NUMBER OF ROADS OUT OF THIS CITY
	// NODE IS THE ROW #. IN DEGREE IS HOW MANY POSITIVE NUMBERS IN THAT ROW
	private int outDegree(int node)
	{
		int count = 0;

		for(int j = 0; j < G[node].length;j++){
			if (G[node][j] > 0 ) {
				count++;
			}
			else{
				continue;
			}
		}
		return count;
	}

	// DEGREE IS TOTAL NUMBER OF ROAD BOTH IN AND OUT OFR THE CITY 
	private int degree(int node)
	{
		int in = inDegree(node);
		int out = outDegree(node);

		return in+out;
	}

	// PUBLIC METHODS 
	
	public int maxOutDegree()
	{

		int max = 0;

		for(int j = 0; j < G.length;j++){
			if(max < outDegree(j)){
				max = outDegree(j);
			}
			else{
				continue;
			}
		}

		return max;
	}

	public int maxInDegree()
	{
		int max = 0;

		for(int j = 0; j < G.length;j++){
			if(max < inDegree(j)){
				max = inDegree(j);
			}
			else{
				continue;
			}
		}

		return max;
	}

	public int minOutDegree()
	{
		int min = Integer.MAX_VALUE;

		for(int j = 0; j < G.length;j++){
			if(min > outDegree(j)){
				min = outDegree(j);
			}
			else{
				continue;
			}
		}

		return min;
	}
	public int minInDegree()
	{
		int min = Integer.MAX_VALUE;

		for(int j = 0; j < G.length;j++){
			if(min > inDegree(j)){
				min = inDegree(j);
			}
			else{
				continue;
			}
		}

		return min;
	}	
	
	public int maxDegree()
	{
		int max = 0;

		for(int j = 0; j < G.length;j++){
			if(max < degree(j)){
				max = degree(j);
			}
			else{
				continue;
			}
		}

		return max;
	}

	public int minDegree()
	{
		int min = Integer.MAX_VALUE;

		for(int j = 0; j < G.length;j++){
			if(min > degree(j)){
				min = degree(j);
			}
			else{
				continue;
			}
		}

		return min;
	}
	
	public void removeEdge(int fromNode, int toNode) throws Exception
	{
		// try {
			if (hasEdge(fromNode, toNode) == false) {
				// throw new Exception("Non Existent Edge Exception: removeEdge("+fromNode+","+toNode+")");
				System.out.println("java.lang.Exception: Non Existent Edge Exception:removeEdge("+fromNode+","+toNode+")");
			}
			else{
				G[fromNode][toNode] = -1;
			}
		
			
			
		// catch (Exception e) {
		// 	System.out.println(e);
		// }
		
		
		
		/* if caller passes in a row col pair that 
		   out of bound or has no edge there, you must 
		   throw and catch an exception. See my output.
		
		   if the edge is there then remove it by writing 
		   in a NO_EDGE value at that coordinate in the grid	
		*/
	}
	
	// TOSTRING
	public String toString()
	{	String the2String = "";
		for (int r=0 ; r < G.length ;++r )
		{
			for ( int c=0 ; c < G[r].length ; ++c )
				the2String += String.format("%3s",G[r][c] + " ");
			the2String += "\n";
		}
		return the2String;
	} // END TOSTRING

} //EOF

