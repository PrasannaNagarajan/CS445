import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Pacs
{	public static void main( String args[] ) throws Exception
	{	BufferedReader memberToPacsFile = new BufferedReader(new FileReader( "member2Pacs.txt"));
		BufferedReader AllPacsFile= new BufferedReader(new FileReader("allPacs.txt"));
		TreeSet<String> allPacs= new TreeSet<String>();
		while( AllPacsFile.ready())
			allPacs.add(AllPacsFile.readLine());			
		
		TreeMap<String, TreeSet<String>> pacToMembers = new TreeMap<String, TreeSet<String>>(); // THE MAP THAT GETS PRINTED	
		


		//POPULATE THE TREE MAP ABOVE

		loadSet(allPacs, pacToMembers, memberToPacsFile);


		//NOw PRINT THAT MAP (see output)
		printSet(pacToMembers);
	} // END MAIN


	static void loadSet(TreeSet<String> allPacs, TreeMap<String, TreeSet<String>> pacToMembers, BufferedReader memberToPacsFile ) throws Exception
	{
		String str;
		String str2;
		 TreeSet<String> foo = new TreeSet<>();
		//  int count = 0;
		// while (infile.readLine() != " ") {
		// 	a[count] = infile.readLine();
		// 	count++;
		// }

		// // List<String> list = new ArrayList<String>();
		
		// // while(AllPacsFile.ready()){
		// // 	str = AllPacsFile.readLine();
    	// // 	list.add(str);
		// }

		List<String> list2 = new ArrayList<String>();

		while(memberToPacsFile.ready()){
			str2 = memberToPacsFile.readLine();
    		list2.add(str2);
		}

		for(String i : list2){
			foo.add(i);
		}



		for(String key : allPacs){
			TreeSet<String> foo1 = new TreeSet<String>();

			for(String l : foo){
				String[] splited = l.split(" ");
				
				if(l.contains(key)){
					foo1.add(splited[0]);
				}
			
				pacToMembers.put(key, foo1);
				}
		// pacToMembers.put(key, foo1);
			
		}
	
	}

	static void printSet(TreeMap<String, TreeSet<String>> loadSet) {



		for( String key : loadSet.keySet()){
			System.out.print( key+ " ");
			for(String value : loadSet.get(key)){
				System.out.print(value+ " ");
		}
		System.out.println();
		
	}

		
	}
} // CLASS
