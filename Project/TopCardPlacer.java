/*
	TopCardPlacer class. 
	Takes two command line args.
	args[0] the number of cards in the deck (just like lab #1)
	args[1] the index position relative to top of deck (i.e. array index] to put the top card
		    by using a sequence of in/out shuffles

	The solution is based in fact that this placement can be achieved by converting the desired
	placement index to a binary number. Then from left to right for every 1 do in inShuffle
	and every 0 do an outShuffle
*/

import java.util.*;
import java.io.*;

public class TopCardPlacer
{
	public static void main(String[] args) 
	{	
		// if ( args.length < 2 ) 
		// {
		// 	System.out.println("Must enter two cmd args: deck size (even number) and postion to place top card.\n");
		// 	System.exit(0);
		// }
		Deck deck = new Deck( 10 ); // starts out in sorted order 1 2 3 4 5 . . .
		int placementIndex = 7;
		
		String bitString = deck.toBitString( placementIndex ); 
		System.out.format( "placement index %d is %s in binary\n", placementIndex, bitString );
		
		for ( int i=0 ; i<bitString.length() ; ++i )
		{
			if (bitString.charAt(i) == '1')
			{	deck.inShuffle();
				System.out.println( "1: " + deck );
			}
			else
			{	deck.outShuffle();
				System.out.println( "0: " + deck );
			}
		} 		
	} // END MAIN
}
