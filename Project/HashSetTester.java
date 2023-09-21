import java.io.*;
import java.util.*;

public class HashSetTester
{
	public static void main(String[] args) throws Exception 
	{	
		double mainStartTime = System.currentTimeMillis();

		
		String infileName = "50MillionWords.txt";
		int  numOfBuckets = Integer.parseInt("10000");
		MyHashSet hset = new MyHashSet( numOfBuckets ); // 
		BufferedReader infile = new BufferedReader(new FileReader(infileName));

		double startTime = System.currentTimeMillis();
		boolean AllAddsSucceed = true; // they SHOULD all succeed
		while (infile.ready()) 
		{
			if ( !hset.add(infile.readLine()) )  
				AllAddsSucceed = false; // THIS IS BAD!			
		}
		infile.close();

		infile = new BufferedReader(new FileReader(infileName));
		boolean AllAddsFail = true;  // they SHOULD all fail
		while (infile.ready()) 
			if ( hset.add(infile.readLine()) ) 
					AllAddsFail = false;  // THIS IS BAD!
		infile.close();

		double stopTime = System.currentTimeMillis();
		System.out.println("AllAddsSucceed: " + AllAddsSucceed); // SHOULD PRINT TRUE
		System.out.println("AllAddsFail:    " + AllAddsFail);   // SHOULD PRINT TRUE
		System.out.format( "Runtime: %1.5f sec.\n", (stopTime-startTime) / 1000.0D );
		
		// NOW DO REMOVES
		
		// ALL THESE SHOULD SUCCEED
		startTime = System.currentTimeMillis();
		boolean AllRemovesSucceed = true; // they SHOULD all succeed
		infile = new BufferedReader(new FileReader(infileName));
		while (infile.ready()) 
		{
			if ( !hset.remove(infile.readLine()) )  
				AllRemovesSucceed = false; // THIS IS BAD!			
		}
		infile.close();

		// RUN IT AGAIN BUT NOW THESE SHOULD ALL FAIL (WE JUST REMOVED THEM ALL)
		infile = new BufferedReader(new FileReader(infileName));
		boolean AllRemovesFail = true;
		while (infile.ready()) 
			if ( hset.remove(infile.readLine()) ) 
					AllRemovesFail = false;  // THIS IS BAD!
		infile.close();
		stopTime = System.currentTimeMillis();
		
		System.out.println("AllRemovesSucceed: " + AllRemovesSucceed); // SHOULD PRINT TRUE
		System.out.println("AllRemovesFail:    " + AllRemovesFail);   // SHOULD PRINT TRU
		System.out.format( "Runtime: %1.5f sec.\n", (stopTime-startTime) / 1000.0D );
		
		double mainStopTime = System.currentTimeMillis();
		System.out.format( "OVERALL Runtime: %1.5f sec.\n", (mainStopTime-mainStartTime) / 1000.0D );
	}
	static void die(String errMsg)
	{
		System.out.println(errMsg);
		System.exit(0);
	}
}