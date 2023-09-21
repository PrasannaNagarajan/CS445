import java.io.*;
import java.util.*;

public class TowerTester
{
	public static void main( String args[] ) throws Exception
	{
		Tower<Integer> myTower = new Tower<Integer>(); 
		Scanner infile = new Scanner( new FileReader( "tower1.txt" ) ); // CONTAINS 1 LINE SEQUENCE LIKE 10 9 8 7 6 5 4 3 2 1 
		while ( infile.hasNextInt() )
			myTower.push( infile.nextInt() );
		infile.close();
		
		System.out.format( "myTower loaded from %s: %s\n", "tower1.txt", myTower );
		
		while ( ! myTower.empty() )
		{	myTower.pop();
			System.out.format( "myTower after pop: %s\n", myTower );
		}
	} // END MAIN
} // END OF TOWERTESTER CLASS