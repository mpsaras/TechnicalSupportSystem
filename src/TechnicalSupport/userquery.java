/*
 * Automated Technical Support System
 * Author: Michelle Psaras
 * This problem processes the input by the user, and looks for a problem description in a 
 * HashMap using the key value to retrieve the solution and display it on the screen.
 */
package TechnicalSupport;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class userquery {
	//Convert all hashmap key values to lower case
	
	public static HashMap<String, String>transformLowerCase(HashMap<String, String> orgmap){
	HashMap<String, String>resultMap = new HashMap<>();
	if (orgmap == null || orgmap.isEmpty()) {
		return resultMap;
	}
	Set<String> keySet = orgmap.keySet();
	for (String key: keySet) {
		String newKey = key.toLowerCase();
		resultMap.put(newKey, orgmap.get(key));
	}
	
	return resultMap;
	}

public static void main(String[] args) {
		HashMap<String,String> map =new HashMap <>();
		
		//Loading the HashTable with keys and values
		map.put("crashed", "Are the device drivers up to date?");
		map.put("Blue", "Ah, the blue screen!  And then what happened?");		
		map.put("Hacked", "You should consider installing anti-virus software.");
		map.put("Bluetooth", "The solution is as simple as enabling it.");
		map.put("Windows", "Ah, I think I see your problem.  What version?");
		map.put("Apple", "You do mean the computer kind of apple don't you?");
		map.put("spam", "You should see if your mail cinet can filter messages");
		map.put("connection", "Contact your internet provider");
		
		/*
		 * Displaying the values in the HashTable
		 */
		//System.out.println("Initial HashTable:" + map);
		
		//Transform the HashTable to lowercase
		
		map = transformLowerCase(map);
		
		/*
		 * Displaying the values in the HashTable converted to LowerCase
		 */
		
		//System.out.println("Converted HashTable:" + transformLowerCase(map));
		
		
		boolean input = true;
		boolean keyFound = false;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the automated technical support system.  "
				+ "Please describe your problem:");
		
		while (input) {
			keyFound = false;
			String problem = sc.nextLine();
			//convert input string to an array of lowercase
			String[] words = problem.toLowerCase().split(" ");
		
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals("quit")) {
					//Close the scanner if user inputs "quit"
					sc.close();
					input = false;
					keyFound=true;
					break;
				}
				else
					//When keyFound value is true it indicates that there has been a Key matched
					//in the keySet of the Hash Table
					if (keyFound) {
						break;
				}
					else {
						//Search for the key value in the keySet with an iterator
						Iterator<String> itr = map.keySet().iterator();
						while (itr.hasNext()) {				
							String key = itr.next();
							if (key.equals(words[i])) {
//								System.out.printf("The recommendation for %S is:  %s",words[i], map.get(words[i]));
								System.out.println(map.get(words[i]));
								keyFound = true;
								break;
							}		
				
						}
			
					}
			}
			//If no key values are found in the keySet and ask the user for more input
			if (!keyFound)	
				System.out.println("Curious, tell me more");
		}
	}
}	

			



	