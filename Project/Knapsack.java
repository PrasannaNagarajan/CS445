/*
	PrintSubSets.java
*/
import java.io.*;

public class Knapsack
{
	public static void main( String[] args )
	{	int[] set = new int[16]; // 5 elements produces 2^5 subsets ( 32 subsets )
		//0 to 15 and store the ints of the fist line of the file into the set
		try{
		BufferedReader content =  new BufferedReader(new FileReader(args[0]));
		
		String[] a = content.readLine().split(" ");
		

		for(int i = 0; i<16; i++){
			set[i] = Integer.parseInt(a[i]);
			 
			
		} 
		//Do 1 more hardocded nextint to read in the target Value

		int b = Integer.parseInt(content.readLine());

		//do not print any output except the subset each on its own line



		for ( int i=0 ; i<(Math.pow(2, 16)) ; ++i ){
			int total = 0;
			int[] subset = new int[16];
			String bitmap = toBitString( i, set.length );

			for ( int bindx=0 ; bindx<set.length ; ++bindx ){	
				
				if ( bitmap.charAt(bindx)=='1' ) {

					subset[bindx] = set[bindx] ;
					//add it to your local temp subset
				}
			}
			// after the Loop
			// if sett adds up to Target
		
			for(int number : subset){
				total = total +number;
			}
			if (total == b){
				for (int g : subset){
					if(g == 0){
						continue;
					}
					else{
					System.out.print(g+" ");
					}
				}
				System.out.println("");
			}

			}
	
 }
 catch( IOException ioe){
	System.out.println("not a valid file");
 }


 
 } // END MAIN


	// i.e number 31 converted to a width of 5 bits = "11111"
	//     nuumber 7 converted to a width of 5 bits = "00111"
	static String toBitString( int number, int width )
	{
		String bitstring = "";
		while (number > 0)
		{	if (number % 2 == 0)
				bitstring = "0" + bitstring;
			else
				bitstring = "1" + bitstring;
			number /= 2 ;
		}
		while ( bitstring.length() < width )
				bitstring = "0" + bitstring;
		return bitstring;
	}
} // END CLASS