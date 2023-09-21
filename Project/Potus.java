import java.util.*;
import java.io.*;

public class Potus
{
	public static void main( String[] args )  throws Exception
	{
		BufferedReader state2PresidentsFile = new BufferedReader( new FileReader("state2Presidents.txt") );
		TreeMap<String,TreeSet<String>> state2Presidents= new TreeMap<String,TreeSet<String>>();

		BufferedReader allPresidentsFile = new BufferedReader( new FileReader("allPresidents.txt") );
		TreeSet<String> allPresidents = new TreeSet<String>();

		BufferedReader allStatesFile = new BufferedReader( new FileReader("allStates.txt") );
		TreeSet<String> allStates = new TreeSet<String>();

		System.out.println( "THESE STATES HAD THESE POTUS BORN IN THEM:\n");


		method1(state2PresidentsFile, state2Presidents);

		System.out.println( "\nLIST OF POTUS AND STATE THEY WERE BORN IN:\n");
	

		System.out.println( "\nTHESE POTUS BORN BEFORE STATES WERE FORMED:\n");


		System.out.println( "\nTHESE STATES HAD NO POTUS BORN IN THEM:\n");	
	} // END MAIN

	//       - - - - - - - - - - -  H E L P E R    M E T H O D S - - - - - - - -

	// read lines of allPresidentsFile into allPresidents
	// read lines of allStatesFile into allStates
	// You can write one method and reuse

	static void loadSet(BufferedReader allPresidentsFile, TreeSet<String> allPresidents,BufferedReader allStatesFile, TreeSet<String> allStates ) throws Exception{

		String str;
		String str2;

		List<String> list = new ArrayList<String>();
		
		while(allStatesFile.ready()){
			str = allStatesFile.readLine();
    		list.add(str);
		}
		for(String i : list){
			allStates.add(i);
		}



		List<String> list2 = new ArrayList<String>();

		while(allPresidentsFile.ready()){
			str2 = allPresidentsFile.readLine();
    		list2.add(str2);
		}

		for(String i : list2){
			allPresidents.add(i);
		}
	}

	// "THESE STATES HAD THESE POTUS BORN IN THEM:\n"
	// Print all states listed in state2Presidens.txt

	static void method1(BufferedReader state2PresidentsFile, TreeMap<String,TreeSet<String>> state2Presidents)throws Exception{
		String str2;
		 TreeSet<String> foo = new TreeSet<>();

		 List<String> list2 = new ArrayList<String>();

		while(state2PresidentsFile.ready()){
			
			String[] list3  = state2PresidentsFile.readLine().split(" ");
    		list2.add(list3[0]);
		}

		for(String i : list2){
			foo.add(i);
		}


		for(String key : foo){
			TreeSet<String> foo1 = new TreeSet<String>();

			for(String l : foo){
				
				
				if(l.contains(key)){
					foo1.add(l);
				}
			
				state2Presidents.put(key, foo1);
				}
		}

		for( String key : state2Presidents.keySet()){
			System.out.print( key+ " ");
			for(String value : state2Presidents.get(key)){
				System.out.print(value+ " ");
		}
		System.out.println();
	}
	


	// "\nLIST OF POTUS AND STATE THEY WERE BORN IN:\n"
	// For each potus, match it up with their state

	// "\nTHESE POTUS BORN BEFORE STATES WERE FORMED:\n"
	// Look at website step 3 and add all names to a list

	// "\nTHESE STATES HAD NO POTUS BORN IN THEM:\n"

}
}	// END CLASS