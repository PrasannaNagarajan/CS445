import java.io.*;
import java.util.*;
// DO NOT IMPORT ANYTHING ELSE
// NO PACKAGE STATMENTS 
// NO OVERRIDE STATMENTS 

import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

public class ComplexSwamp
{
	static int[][] swamp;  // NOW YOU DON'T HAVE PASS THE REF IN/OUT METHODS

 	public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2]; // row and col will be on the 2nd line of input file;
		swamp = loadSwamp( args[0], dropInPt );
		int row=dropInPt[0], col = dropInPt[1];
		String path = ""; // with each step grows to => "[2,3][3,4][3,5][4,6]" etc
		dfs( row, col, path );
	} // END MAIN


 	// JUST FOR YOUR DEBUGGING - DELETE THIS METHOD AND ITS CALL BEFORE HANDIN
	// ----------------------------------------------------------------
	private static void printSwamp(String label, int[][] swamp )
	{
		System.out.println( label );
		System.out.print("   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print( c + " " ) ;
		System.out.print( "\n   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");

		for(int r = 0; r < swamp.length; r++)
		{	System.out.print( r + "| ");
			for(int c = 0; c < swamp[r].length; c++)
				System.out.print( swamp[r][c] + " ");
			System.out.println("|");
		}
		System.out.print( "   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");
	}
	// --YOU-- WRITE THIS METHOD 
	// (you may copy from YOURSELF from YOUR lab7 not someone else's)
   	// ----------------------------------------------------------------
	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
	{
		int[][] theSwamp;
		// open infile with Scanner
		Scanner infile = new Scanner(new File(infileName));
		
		int dimension = infile.nextInt();
		theSwamp = new int[dimension][dimension];
		// read in the next two numbers with two calls to .nextInt()
		dropInPt[0] = infile.nextInt();
		dropInPt[1] = infile.nextInt();
		// store into origin[0] and origin[1]
		// now use a nested loop outer = row from 0 to dimension-1
		//	 inner loop = col from 0 to dimension-1
		for(int row=0; row <= dimension-1; row++){
			for(int col = 0; col <= dimension-1 ;col++){
				theSwamp[row][col] =  infile.nextInt();
			}
		}
		//		 store each .nextInt() into theSwamp[row][col]
		// return theSwamp
		return theSwamp;
	}

	static void dfs( int row, int col, String path ) // dfs = DEPTH FIRST SEARCH
	{
		// IMPLEMENT THE DFS ALGORITHM IN HERE
		// declare swamp array above main as static
		// append incoming "[r,c]" to incoming path
		path += "["+row+","+col+"]";
		
		if (onEdge( swamp, row, col )) {
			System.out.println(path);
		
		}
		else{
		// if north is a safe step 
		// 	mark current [r][c]
		// 	recurse: passing in cords of north and path 
		// 	unmark [r][c]

		if (swamp[row-1][col] == 1) {
			swamp[row][col] = -1;
		
			dfs(row-1, col, path);
			swamp[row][col] = 1;
		}

		// 	else if northeast is a safe step 
		// 	mark current [r][c]
		// 	recurse: passing in cords of north and path 
		// 	unmark [r][c]

		if (swamp[row-1][col+1] == 1) {
			swamp[row][col] = -1;
		
			dfs(row-1, col+1, path);
			swamp[row][col] = 1;
		}

		// 	else if east is a safe step 
		// 	mark current [r][c]
		// 	recurse: passing in cords of north and path 
		// 	unmark [r][c]

		if (swamp[row][col+1] == 1) {
			swamp[row][col] = -1;
		
			dfs(row, 1+col, path);
			swamp[row][col] = 1;
		}

		// 	else if southeast is a safe step 
		// 	mark current [r][c]
		// 	recurse: passing in cords of north and path 
		// 	unmark [r][c]

		if (swamp[row+1][col+1] == 1) {
			swamp[row][col] = -1;
		
			dfs(1+row, 1+col, path);
			swamp[row][col] = 1;
		}

		// 	else if south is a safe step 
		// 	mark current [r][c]
		// 	recurse: passing in cords of north and path 
		// 	unmark [r][c]

		if (swamp[row+1][col] == 1) {
			swamp[row][col] = -1;
		
			dfs(1+row, col, path);
			swamp[row][col] = 1;
		}

		// 	else if southwest is a safe step 
		// 	mark current [r][c]
		// 	recurse: passing in cords of north and path 
		// 	unmark [r][c]
		if (swamp[row+1][col-1] == 1) {
			swamp[row][col] = -1;
		
			dfs(1+row, col-1, path);
			swamp[row][col] = 1;
		}

		// 	else if west is a safe step 
		// 	mark current [r][c]
		// 	recurse: passing in cords of north and path 
		// 	unmark [r][c]

		if (swamp[row][col-1] == 1) {
			swamp[row][col] = -1;
		
			dfs(row, col-1, path);
			swamp[row][col] = 1;
		}

		// 	else if northwest is a safe step 
		// 	mark current [r][c]
		// 	recurse: passing in cords of north and path 
		// 	unmark [r][c]

		if (swamp[row-1][col-1] == 1) {
			swamp[row][col] = -1;
		
			dfs(row-1, col-1, path);
			swamp[row][col] = 1;
		}

		// 	if we make it to then there was no other valid step to take then return to the prev stack frame and resume where it left off.
		}

	}	

	static boolean onEdge( int[][] swamp, int r, int c ) // RET TRUE IF ON EDGE OF SWAMP
	{
		return r==0 || r==swamp.length-1 || c ==0 || c==swamp.length-1;
	}
}



