// ADD THIS CODE INTO YOUR Graph.java FILE JUST LIKE YOU DID IN THE BSTs
// ** of course you need to convert those comments to working code 

class Edge
{
	int dest, weight;
	Edge next;
	Edge( int dest, int weight, Edge next )
	{
		this.dest = dest;
		this.weight = weight;
		this.next = next;
	}
}
