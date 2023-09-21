/*
	Deck class (for TopCardPlacer class of project #1
*/

import java.util.*;
import java.io.*;

public class Deck
{
	private int[] deck;
	private final int MAX_DECK_SIZE = 30;
	public Deck( int numCards )
	{	if ( numCards%2 != 0 || numCards > MAX_DECK_SIZE ) 
		{
			System.out.format("\nINVALID DECK SIZE: (" + numCards + "). Must be an small even number <= %d\n", MAX_DECK_SIZE);
			System.exit(0);
		}
		deck = new int[numCards];
		for ( int i=0 ; i<numCards ; i++ ) deck[i] = i;
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
	
	
	public String toBitString( int n ) 
	{
		if (n == 0){
			return " ";
		}
		else{
			char[] bitarray = new char [(int)(Math.log(n)/Math.log(2)+1)];

			for(int i = 0;i<bitarray.length;i++){
				bitarray[i] = '0';
			}

			int p = (int)(Math.log(n)/Math.log(2));

			for(int i = 0; i<bitarray.length;i++){
				int exp = (int)Math.pow(2,(p-i));
				if(exp <= n){
					bitarray[i] = '1';
				
				n = n - exp;
				}
				
			}

			// while (n !=0){
			// 	int p = (int)(Math.log(n)/Math.log(2));

			// 	bitarray[p+1] = 1;

			// 	n = n - 2^p;
			// }
			String a = "";
			for(char i : bitarray){
				a +=  Character.toString(i);
			}
			return a;

			

		}
		
	}
	
}	// END DECK CLASS