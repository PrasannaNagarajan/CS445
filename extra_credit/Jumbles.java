import java.util.*;
import java.io.*;

public class Jumbles {
    // [scrambled word  --> unscrambled words]
    // assign unscrambled words based on the cannonical scrambling of the word to the key

    public static void main( String[] args ) throws Exception{


        BufferedReader scrambled_words = new BufferedReader( new FileReader( args[1]) );
        BufferedReader unscrambled_words = new BufferedReader( new FileReader( args[0]) );


        TreeMap<String, TreeSet<String>> jumbledTreeMap = new TreeMap<String, TreeSet<String>>();

        loadSet(scrambled_words, unscrambled_words, jumbledTreeMap,args[0]);

        printSet(jumbledTreeMap);
    }

    static void loadSet( BufferedReader scramblefile ,BufferedReader unscramblefile , TreeMap<String, TreeSet<String>> treeMap, String filename) throws Exception{

        String jumbled_words;
        String unjumbled_words;
        


        while(scramblefile.ready()){
            TreeSet<String> unjumbleset = new TreeSet<>();
			jumbled_words = scramblefile.readLine();
            BufferedReader unscrambled_words = new BufferedReader( new FileReader( filename) );
            while (unscrambled_words.ready()) {
                unjumbled_words = unscrambled_words.readLine();
                if (toCanonical(unjumbled_words).equals(toCanonical(jumbled_words))){
                    unjumbleset.add(unjumbled_words);
                }

                
            }
            treeMap.put(jumbled_words, unjumbleset);

        }
    }

    static String toCanonical( String s ) // assume s = "zebra"
    {
	char[] letters = s.toCharArray(); // letters -> [z][e][b][r][a]
	Arrays.sort( letters ); // now letters -gt; [a][b][e][r][z]
	return new String( letters ); // read String API it has a constructor that accepts a char array and does the obvious with it
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
}
