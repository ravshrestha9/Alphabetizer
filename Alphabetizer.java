/**
* The Alphabetizer program reads a string and output the string 
* with the characters in alphabetical order ignoring Case and non-alphabetic
* characters
*
* @author  Ravi Shrestha
* @version 1.0
* @since   04/13/2019
*/

import java.util.Scanner; 
import java.util.Arrays; 
import java.util.Comparator; 

public class Alphabetizer
{ 
	/**
   * This method sorts out the input string in alphabetical order.
   * @param inpuString This is string passed by the user in the command line
   * @return String This returns the user's input in alphabetical order.
   */
	public static String sortString(String inputString) 
	{ 
	    /** Using regular expression to ignore non-alphabetical characters
	     * and creating a new String object since String is immutable
	    */
        String newInputString = inputString.replaceAll("[^a-zA-Z]","");
        
		// Creating a char array of the length equals to the newInput String 
		Character tempArray[] = new Character[newInputString.length()]; 
      	
      	//Looping through and storing the charcters in the character array
		for (int i = 0; i < newInputString.length(); i++) {  	
			tempArray[i] = newInputString.charAt(i); 
		} 
		
		/** Using sort method of Array to sort out the characters in 
		 * alphabetical order with the help of Comparator
		 */ 
		Arrays.sort(tempArray, new Comparator<Character>(){ 

            /**Overriding the method of Comparator class to compare the characters
             * for order. Returns a negative integer, zero, or positive integer as
             * the first argument is less than, equal to, or 
             * greater than the second.
             */
			@Override
			public int compare(Character c1, Character c2) 
			{ 
				// ignoring case 
				return Character.compare(Character.toLowerCase(c1), 
										Character.toLowerCase(c2)); 
			} 
		}); 
		
		// using StringBuilder to convert Character array to String 
		StringBuilder sb = new StringBuilder(tempArray.length); 
		for (Character c : tempArray) 
			sb.append(c.charValue()); 

		return sb.toString(); 
	} 
	
	// Driver method 
	public static void main(String[] args) 
	{ 
	    Scanner sc = new Scanner(System.in); 
  
		String inputString = sc.nextLine(); 
		String outputString = sortString(inputString); 
		
		System.out.println("Input String : " + inputString); 
		System.out.println("Output String : " + outputString); 
	} 

} 