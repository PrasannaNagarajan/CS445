public interface HS_Interface
{
/* 	
	D O  N O T  W R I T E   A N Y   C O D E  I N  H E R E 
	A L L   T H E S E   F U N C T I O N S   G O    I N S I D E  T H E  M Y H A S H S E T.J A V A   F I L E 	
*/	

	public boolean add( String key ); // dupes must be rejected and return false
   
	public boolean remove( String key ); // if not found return false else remove & return true
   
	public boolean contains( String key ); // true if foound false if not
   
	public boolean isEmpty(); // use the call to size
   
	public int size(); // number of keys currently stored in the container
   
   	public void clear();
} // END HS_INTERFACE
