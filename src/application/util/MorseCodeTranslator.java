package application.util;

import java.util.HashMap;

public class MorseCodeTranslator {
	// TODO Either ArrayList or Hashmap for translation
	private static HashMap<String, String> morseCodeDictionary = new HashMap<String, String>();

	/**
	 * Initializes the dictionary hashmap
	 */
	private static void init() {
		morseCodeDictionary.put(".", "e");
	}

	/**
	 * Translates the passed in message to Morse Code
	 * 
	 * @param english
	 *            - original message to be translated
	 * @return - the passed in message translated to Morse Code
	 */
	public static String translateToMorseCode(String english) {
		// Checks if the dictionary has been initialized
		if (morseCodeDictionary.isEmpty()) {
			// Calls a method to initialize the dictionary
			init();
		}
		return null;
	}

	/**
	 * Translates the passed in message to English
	 * 
	 * @param morseCode
	 *            - original message to be translated
	 * @return - the passed in message translated to English
	 */
	public static String translateToEnglish(String morseCode) {
		// Checks if the dictionary has been initialized
		if (morseCodeDictionary.isEmpty()) {
			// Calls a method to initialize the dictionary
			init();
		}

		String[] words = morseCode.split("\\s+");
		for(int i = 0; i < words.length; i++) {
			System.out.println(i);
			System.out.println(words[i]);
			
		}
		
		// char[] test = morseCode.toCharArray();
		//
		//
		// for(int i = 0; i < test.length; i++) {
		// if(morseCodeDictionary.containsKey(test[i])) {
		// //test[i] = morseCodeDictionary.get(test);
		// }
		// }
		String translatedText = new String();
		return translatedText;
	}

	/**
	 * Handles splitting up a morse code message into individual characters
	 * 
	 * @param morseCode
	 *            - message to be split up
	 * @return split up array of original message
	 */
	private static String[] splitUpMorseCode(String morseCode) {
		return null;

	}
}
