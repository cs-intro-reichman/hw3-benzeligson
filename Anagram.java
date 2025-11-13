/** Functions for checking if a given string is an anagram. */
public class Anagram {
		public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  


	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		while (str1.length() > 0) {
			char letterChecked = str1.charAt(0);
				if ((int) letterChecked != 32) { 
				int indexInStr2 = str2.indexOf(letterChecked);
				if (indexInStr2 == -1) {
					return false;
				}
				str1 = str1.substring(1);
				str2 = str2.substring(0, indexInStr2) + str2.substring(indexInStr2 + 1);
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String fixedStr = "";
		for (int i = 0 ; i < str.length() ; i++) {
			char letterChecked = str.charAt(i);
			int valueInASCII = (int) letterChecked;
			if (valueInASCII >= 97 && valueInASCII <=122) {
				fixedStr = fixedStr + letterChecked;
			}
			if (valueInASCII >= 65 && valueInASCII <=90) {
				letterChecked = (char) (letterChecked + 32);
				fixedStr = fixedStr + letterChecked;
			}
		}
		return fixedStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newAnagram = "";
		while (str.length() > 0) { 
			int index = (int)(Math.random() * (str.length()-1));
			char chosenLetter = str.charAt(index);
			newAnagram = newAnagram + chosenLetter;
			str = str.substring(0, index) + str.substring(index + 1);
		}
		return newAnagram;
	}
}
