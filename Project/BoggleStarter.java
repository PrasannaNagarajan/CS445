import java.io.*;
import java.util.*;


// just generates all the strings & prints them as they are generated

public class Boggle
{
	static BufferedReader br;

	static String[][] board;
	static long startTime,endTime; // for timing
	static final long MILLISEC_PER_SEC = 1000;

	// define a TreeSet of String named dictionary
	static TreeSet<String> dictionary = new TreeSet<>();

	// define a TreeSet of String named hits (or matches or wordsFoundInGrid ) only real dictionary words go in here
	static TreeSet<String> hits = new TreeSet<>();

	public static void main( String args[] ) throws Exception
	{
		startTime= System.currentTimeMillis();
		board = loadBoard(args[1] );

		// INITIALIZE DICT AND HITS HERE
		try {
            br = new BufferedReader(new FileReader(args[0]));
            String line = null;
            while ((line = br.readLine()) != null) {
                dictionary.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

		hits.clear();

		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[row].length; col++)
				dfs( row, col, ""  ); // FOR EACH [R][C] THE WORD STARTS EMPTY

		// EVENTUALLY YOU ADD AN ENANCED FOR LOOP HERE
		for (String string : hits) {
			System.out.println(string);
		}
		// PRINT OUT YOUR HITS ONE WORD PER LINE

		endTime =  System.currentTimeMillis(); // for timing
		// System.out.println("GENERATION COMPLETED: runtime=" + (endTime-startTime)/MILLISEC_PER_SEC );

	} // END MAIN ----------------------------------------------------------------------------

	static void dfs( int r, int c, String word  )
	{
		word += board[r][c];

		if (dictionary.contains(word) == true && word.length() >= 3 ) {
			hits.add(word);
		}

		// System.out.println( word ); // EVENTUALLY REPLACE WITH: IF FOUND IN DICT ADD TO HITS CONTAINER



		// THE HUERISTIC GOES HERE:  After you search for the word just formed
		// if the dictionary comes back with false (i.e. not found) then "ask" the dictionary
		// "are there any words in you that even start with this failed word?"
		// HOW DO I ASK THE DICTIONARY THIS QUESTION?
		// (same way you wrote union,intersect,diff with no loops)  READ THE TreeSet API methods!
		// If the dictionary comes back and says "NO there are no words in me that ever start with that failed word
		// then you ask yourself " What value is that information?  What should I do if the word I just formed
		// is not in the dictaionary AND there is not even a word in the dictionary that even starts with this word?
		// YOU CONNECT THE DOTS AND DECIDE WHAT TO DO IF YOUR FAILED WORD IS NOT A PREFIX OF THE DICTIONARY..


		// N O W    Y O U    D O    A    S W E E P    O F   Y O U R   8   N E I G H B O R   C E L L S
		// L O O K I N G  T O   G R O W   Y O U R   W O R D    W I T H   A    R E C U R S I V E  C A L L

		// IM GIVING you THE NORTH AND NORTHEAST TESTS - YOU MUST WRITE 6 MORE BELOW IT
		// DO NOT ELSE THEM OFF GIVE EVERY BLOCK AN INDEPENDENT IF TEST
		// YOU WANT TO RESUME YOUR CLOCKWISE SWEEP OF NEIGHBORS

		// NORTH IS [r-1][c]

		if ( r-1 >= 0   &&   board[r-1][c] != null )   // THE r +/- and c+/- WILL CHANGE FOR EVEY BLOCK BELOW
		{	String unMarked = board[r][c]; // SAVE TO RESTORE AFTER RET FROM RECURSION
			board[r][c] = null; // // null IS THE MARKER OF A VALUE AS IN USE ALREADY
			dfs( r-1, c, word ); // THE r-1,c WILL CHANGE WITH EVERY OTHER BLOCK BELOW
			board[r][c] = unMarked; // BACK. UNMARK IT
		}

		// NE IS [r-1][c+1]  YOU WILL NEED TO TEST BOTH r-1 AND c+1 FOR OUT OF BOUNDS
		if (r-1 >= 0 && c+1 < board[r].length   &&   board[r-1][c+1] != null )
		{	String unMarked = board[r][c]; // SAVE TO RESTORE AFTER RET FROM RECURSION
			board[r][c] = null; // // null IS THE MARKER OF A VALUE AS IN USE ALREADY
			dfs( r-1, c+1, word ); // THE r-1,c+1 etc WILL CHANGE WITH EVERY OTHER BLOCK BELOW
			board[r][c] = unMarked; // BACK. UNMARK IT
		}
		// E IS [r][c+1]
		if ( c+1 < board[r].length   &&   board[r][c+1] != null )
		{	String unMarked = board[r][c];
			board[r][c] = null; 
			dfs( r, c+1, word ); 
			board[r][c] = unMarked; 
		}
		// SE IS ...
		if (r+1 < board[r].length && c+1 < board[r].length   &&   board[r+1][c+1] != null )
		{	String unMarked = board[r][c]; 
			board[r][c] = null; 
			dfs( r+1, c+1, word ); 
			board[r][c] = unMarked;
		}	

		// S IS ...
		if (r+1 < board[r].length  &&   board[r+1][c] != null )
		{	String unMarked = board[r][c];
			board[r][c] = null; 
			dfs( r+1, c, word ); 
			board[r][c] = unMarked; 
		}	
		// SW IS ...
		if (r+1 < board[r].length &&   c-1 >= 0 &&   board[r+1][c-1] != null )
		{	String unMarked = board[r][c]; 
			board[r][c] = null; 
			dfs( r+1, c-1, word ); 
			board[r][c] = unMarked; 
		}	
		// W IS ...
		if ( c-1 >= 0 &&   board[r][c-1] != null )
		{	String unMarked = board[r][c]; 
			board[r][c] = null; 
			dfs( r, c-1, word ); 
			board[r][c] = unMarked; 
		}	

		// NW IS ...
		if ( r-1 >= 0 &&   c-1 >= 0 &&   board[r-1][c-1] != null )
		{	String unMarked = board[r][c]; 
			board[r][c] = null;
			dfs( r-1, c-1, word ); 
			board[r][c] = unMarked; 
		}	

	} // END DFS ----------------------------------------------------------------------------

	//=======================================================================================
	static String[][] loadBoard( String fileName ) throws Exception
	{	Scanner infile = new Scanner( new File(fileName) );
		int rows = infile.nextInt();
		int cols = rows;
		String[][] board = new String[rows][cols];
		for (int r=0; r<rows; r++)
			for (int c=0; c<cols; c++)
				board[r][c] = infile.next();
		infile.close();
		return board;
	} //END LOADBOARD

} // END BOGGLE CLASS
