import java.io.*;
import java.util.*;

public class GraphLL
{
	private final int NO_EDGE = -1; // all real edges are positive
	private  Edge[] G;              // every G[i] is the head of a linked list, i.e ref to an Edge 

	private int numEdges;
	public GraphLL( String graphFileName ) throws Exception  // since readFild doesn't handle them either
	{
		loadGraphFile( graphFileName );
	}

	///////////////////////////////////// LOAD GRAPH FILE //////////////////////////////////////////

	private void loadGraphFile( String graphFileName ) throws Exception
	{
		Scanner graphFile = new Scanner( new File( graphFileName ) );
		int numNodes = graphFile.nextInt();   
		G = new Edge[numNodes];
		numEdges=0;

		// NOW LOOP THRU THE FILE READING EACH TRIPLET row col weight FROM THE LINE
		// DO an insertAtFront using g[SRC] as the head 

		while ( graphFile.hasNextInt() )
		{	
			int src = graphFile.nextInt();
        	int dest = graphFile.nextInt();
        	int weight = graphFile.nextInt();
        	addEdge(src, dest, weight);
		}
	} // END readGraphFile

	// GO TO G[src] AND DO INSERTATFRONT ON THAT 'head' POINTER I.E. G[src]
	private void addEdge( int src, int dest, int weight )
	{
		Edge newEdge = new Edge(dest, weight);
    	newEdge.next = G[src];
    	G[src] = newEdge;
    	numEdges++;
	}
	
	private boolean hasEdge(int src, int dest)
	{
		Edge current = G[src];
    	while (current != null) 
		{
        	if (current.dest == dest) {
            	return true;
        	}
        	current = current.next;
   		}
    return false;
	}

	private int inDegree(int dest) // # of roads(edges) entering this city (node)
	{	// THE HARDER ONE
		int inDeg = 0;
		
		for (int i = 0; i < G.length; i++) 
		{
			Edge current = G[i];
			while (current != null) 
			{
				if (current.dest == dest) 
				{
					inDeg++;
				}
				current = current.next;
			}
		}
	
		return inDeg;
	}

	private int outDegree(int src) // # of roads(edges) leaving this city (src node #)
	{	// THE EASIER ONE
		int outDeg=0;
		Edge current = G[src];
    	while (current != null) 
		{
        	outDeg++;
        	current = current.next;
    	}
		return outDeg;	
	}

	private int degree(int node) // indegree + outdegree of this node #
	{
		return inDegree(node)+outDegree(node);
	}

	// PUBLIC METHODS. THIS CODE COPIED FROM THE GRAPH2D LAB AND USED AS IS. SINCE IT IS NOT
	// DEPENDENT ON UNDERLYING DATA STRUCTURE AND RELIES ONLY ON CALLING THE 3 DEGREE FUNCTIONS
	
	public int maxOutDegree()
	{
		int maxOutDegree = outDegree(0); 

		for(int j = 0; j < G.length;j++){
			if(maxOutDegree < outDegree(j)){
				maxOutDegree = outDegree(j);
			}
		}
		return maxOutDegree;
	}

	public int maxInDegree()
	{
		int maxInDegree = inDegree(0); 

		for(int j = 0; j < G.length;j++){
			if(maxInDegree < inDegree(j)){
				maxInDegree = inDegree(j);
			}
		}
		return maxInDegree;
	}

	public int minOutDegree()
	{
		int minOutDegree = outDegree(0); 

		for(int j = 0; j < G.length;j++){
			if(minOutDegree > outDegree(j)){
				minOutDegree = outDegree(j);
			}
		}
		return minOutDegree;
	}

	public int minInDegree()
	{
		int minInDegree = inDegree(0); // ASSUM 1STNODE HAS LARGEST OUTDEG

		for(int j = 0; j < G.length;j++){
			if(minInDegree > inDegree(j)){
				minInDegree = inDegree(j);
			}
		}
		return minInDegree;
	}	
	
	public int maxDegree()
	{
		int maxDegree = degree(0);

		for(int j = 0; j < G.length;j++){
			if(maxDegree < degree(j)){
				maxDegree = degree(j);
			}
		}
		return maxDegree;
	}

	public int minDegree()
	{
		int minDegree = degree(0);

		for(int j = 0; j < G.length;j++){
			if(minDegree > degree(j)){
				minDegree = degree(j);
			}
		}
		return minDegree;
	}
	
	public void removeEdge(int src, int dest) {
		// Check if src and dest are in bounds
		if (src < 0 || src >= G.length || dest < 0 || dest >= G.length) {
			System.out.println("java.lang.Exception: Non Existent Edge Exception: removeEdge(" + src + ", " + dest + ")");
			return;
		}
	
		// Check if the list at G[src] is null
		if (G[src] == null) {
			System.out.println("Error: no edges from source node.");
			return;
		}
	
		// Special case for removing the first node in the list
		if (G[src].dest == dest) {
			G[src] = G[src].next;
			numEdges--;
			return;
		}
	
		// General case for removing a node from the list
		Edge pred = G[src];
		Edge curr = G[src].next;
	
		while (curr != null) {
			if (curr.dest == dest) {
				pred.next = curr.next;
				numEdges--;
				return;
			}
			pred = curr;
			curr = curr.next;
		}
	
		// If we get here, the edge was not found
		System.out.println("Error: edge not found.");
	}
	

		// TOSTRING
	public String toString()
	{
		String the2String = "";	
		for (int i = 0; i < G.length; i++) {
			the2String += i + ": ";
			if (G[i] != null) {
				Edge curr = G[i];
				while (curr != null) {
					the2String += "-> [" + curr.dest + "," + curr.weight + "] ";
					curr = curr.next;
				}
			}
			the2String += "\n";
		}
	
		return the2String;
	} // END TOSTRING
} // E N D    G R A P H L L    C L A S S

// - - - - Y O U   M U S T   F I L L   I N   T H E   E D G E  (think 'Node')  C L A S S  - - - -
// NOTHING PUBLIC. LET IF DEFAULT TO PACKAGE/PRIVATE LIKE WE DID IN OTHER LL ASSIGNMENTS
// SO THAT YOU DONT HAVE TO CALL SETTERS AND GETTERS IN YOUR GRAPHLL CODE.

class Edge 
{
	int dest, weight;
	Edge next;
	Edge( int dest, int weight )
	{
		this.dest = dest;
		this.weight = weight;
		//this.next = next;
	}
}


