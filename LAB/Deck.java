/*
	Deck class
*/

import java.util.*;
import java.io.*;

public class Deck
{
	private int[] deck;
	private final int MAX_DECK_SIZE = 20;
	public Deck( int numCards )
	{	if ( numCards%2 != 0 || numCards > MAX_DECK_SIZE ) 
		{
			System.out.format("\nINVALID DECK SIZE: (" + numCards + "). Must be an small even number <= %d\n", MAX_DECK_SIZE);
			System.exit(0);
		}
		// YOU DO THIS => init deck to be exactly numCards long
        deck = new int[numCards];
		// YOU DO THIS => fill deck with with 0 1 2 3 ... numCards-1 in order
        for (int i = 0; i < numCards;i++){
            deck[i] = i;
        }
	}
	
	public String toString()
	{
		String deckStr = "";
		for ( int i=0 ; i < deck.length ; ++i )
			deckStr += deck[i] + " ";
		return deckStr;
	}

	// ONLY WORKS ON DECK WITH EVEN NUMBER OF CARDS
	// MODIFIES THE MEMBER ARRAY DECK
	public void inShuffle()
	{
		// YOUR CODE HERE DELETE LINE
        int mid = deck.length/2;
        int[] array;
        array = new int [deck.length];
        for (int i = 0;i < mid;i++){

            array[i*2+1]= deck[i];
        }
        for (int i = mid;i < deck.length; i++){

            array[2*(i-mid)] = deck[i];
        }
        deck = array;
	}

	// ONLY WORKS ON DECK WITH EVEN NUMBER OF CARDS
	// MODIFIES THE MEMBER ARRAY DECK
	public void outShuffle()
	{
		// YOUR CODE HERE DELETE LINE
        int mid = deck.length/2;
        int[] array;
        array = new int [deck.length];
        for (int i = 0;i < mid;i++){

            array[i*2]= deck[i];
        }
        for (int i = mid;i < deck.length; i++){

            array[2*(i-mid)+1] = deck[i];
        }
        deck = array;
	}
	
	// RETURNS TRUE IF DECK IN ORIGINAL SORTED:  0 1 2 3 ...
	public boolean inSortedOrder()
	{
		// YOUR CODE HERE DELETE LINE
        for (int i = 0; i < deck.length; i++){
            if (deck[i] != i){
                return false;
            }
        }

		return true; // JUST HERE TO COMPILE
	}
}	// END DECK CLASS
