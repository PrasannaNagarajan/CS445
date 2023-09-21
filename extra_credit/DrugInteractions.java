import java.util.*;
import java.io.*;

public class DrugInteractions
{
	public static void main( String[] args ) throws Exception
	{
		BufferedReader foodDrug2CategoryFile = new BufferedReader( new FileReader( "foodDrug2Category.txt" ) );
		BufferedReader patient2FoodDrugFile = new BufferedReader( new FileReader( "patient2FoodDrug.txt") );
		BufferedReader dontMixFile = new BufferedReader( new FileReader( "dontMix.txt" ) );
		

		TreeMap<String, TreeSet<String>> foodDrug2Category = new TreeMap<String, TreeSet<String>>();
		TreeMap<String, TreeSet<String>> patient2FoodDrug = new TreeMap<String, TreeSet<String>>();
		
		loadSet(foodDrug2CategoryFile, foodDrug2Category);
		loadSet(patient2FoodDrugFile, patient2FoodDrug);
		
	
		printSet(foodDrug2Category);
		System.out.println();
		printSet(patient2FoodDrug);
		System.out.println();
		dontmixset(foodDrug2Category, patient2FoodDrug,"dontMix.txt" );

	} // END MAIN


	static void loadSet( BufferedReader filename, TreeMap<String, TreeSet<String>> treeMap) throws Exception
	{

		String str2;
		TreeSet<String> foo = new TreeSet<>();
		

		while(filename.ready()){
			str2 = filename.readLine();

				String[] splited = str2.split(",");
			
			TreeSet<String> foo1 = new TreeSet<String>();

			for(int i = 1; i < splited.length; i++ ){
				foo1.add(splited[i]);
			}

				treeMap.put(splited[0],foo1);

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

	static void dontmixset(TreeMap<String, TreeSet<String>> f2c, TreeMap<String, TreeSet<String>> p2f, String filename)throws Exception{
		
		String str2;

		// for( String key : loadSet1.keySet()){
		// 	for(String value : loadSet1.get(key)){
				
		// 		for( String key2 : loadSet2.keySet()){
		// 			for(String value2 : loadSet2.get(key2)){
						
		// 				List<String> drugnamelist = new ArrayList<String>();
		// 				if (value.equals(value2)) {
		// 					drugnamelist.add(key2);

		// 					while(filename.ready()){
		// 						str2 = filename.readLine();

		// 						if(drugnamelist.contains(str2) == true){
		// 							System.out.println(key);
		// 						}
		// 					}
		// 				}
		// 			}
		// 		}
		// 	}
		// }

		for(String patient : p2f.keySet()){
			//looking at the patient
			List<String> catnamelist = new ArrayList<String>();


			for(String food_drug : p2f.get(patient)){
				for(String food_drug_cat : f2c.keySet()){ 
					for(String food_drug2 : f2c.get(food_drug_cat)){
						if(food_drug.equals(food_drug2)){
							catnamelist.add(food_drug_cat);
						}
					}
				}
					
			}

				BufferedReader dontMixFile = new BufferedReader( new FileReader( filename ) );
				while(dontMixFile.ready()){
					str2 = dontMixFile.readLine();
					String[] splited = str2.split(",");

				if(catnamelist.contains(splited[0]) && catnamelist.contains(splited[1])){
					System.out.println(patient);
					}
			}
		}
	}

		
} // END CLASS