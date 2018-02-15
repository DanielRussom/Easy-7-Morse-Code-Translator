package application.util;

import java.util.HashMap;

public class MorseCodeTranslator {
	// TODO Either ArrayList or Hashmap for translation
	private static HashMap<String, String> morseCodeDictionary = new HashMap<String, String>();

	/**
	 * Initializes the dictionary hashmap
	 */
	private static void init() {
		morseCodeDictionary.put(".-", "a");
		morseCodeDictionary.put("-...", "b");
		morseCodeDictionary.put("-.-.", "c");
		morseCodeDictionary.put("-..", "d");
		morseCodeDictionary.put(".", "e");
		morseCodeDictionary.put("..-.", "f");
		morseCodeDictionary.put("--.", "g");
		morseCodeDictionary.put("....", "h");
		morseCodeDictionary.put("..", "i");
		morseCodeDictionary.put(".---", "j");
		morseCodeDictionary.put("-.-", "k");
		morseCodeDictionary.put(".-..", "l");
		morseCodeDictionary.put("--", "m");
		morseCodeDictionary.put("-.", "n");
		morseCodeDictionary.put("---", "o");
		morseCodeDictionary.put(".--.", "p");
		morseCodeDictionary.put("--.-", "q");
		morseCodeDictionary.put(".-.", "r");
		morseCodeDictionary.put("...", "s");
		morseCodeDictionary.put("-", "t");
		morseCodeDictionary.put("..-", "u");
		morseCodeDictionary.put("...-", "v");
		morseCodeDictionary.put(".--", "w");
		morseCodeDictionary.put("-..-", "x");
		morseCodeDictionary.put("-.--", "y");
		morseCodeDictionary.put("--..", "z");
		morseCodeDictionary.put("-----", "0");
		morseCodeDictionary.put(".----", "1");
		morseCodeDictionary.put("..---", "2");
		morseCodeDictionary.put("...--", "3");
		morseCodeDictionary.put("....-", "4");
		morseCodeDictionary.put(".....", "5");
		morseCodeDictionary.put("-....", "6");
		morseCodeDictionary.put("--...", "7");
		morseCodeDictionary.put("---..", "8");
		morseCodeDictionary.put("----.", "9");
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
			if(words[i].equals("/")) {
				words[i] = " ";
			}
			if(morseCodeDictionary.containsKey(words[i])) {
				words[i] = morseCodeDictionary.get(words[i]);
			}
			System.out.print(words[i]);
		}
		String translatedText = convertToString(words);
		return translatedText;
	}
	
	/**
	 * Converts array of strings to a single string
	 * 
	 * @param array
	 *            - array of strings to be converted
	 * @return - generated string
	 */
	private static String convertToString(String[] array) {
		String output = array[0];
		// Appends each word onto the end of the current sentence
		for (int i = 1; i < array.length; i++) {
			output = output + array[i];
		}
		return output;

	}
}
