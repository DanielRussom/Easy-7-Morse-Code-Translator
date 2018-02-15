package application.util;

import java.util.HashMap;

public class MorseCodeTranslator {
	// TODO Either ArrayList or Hashmap for translation
	private static HashMap<String, String> morseCodeDictionary = new HashMap<String, String>();
	private static HashMap<String, String> englishDictionary = new HashMap<String, String>();

	/**
	 * Initializes both dictionaries
	 */
	private static void init() {
		// Initializes the morse code dictionary
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

		// Initializes the englishdictionary
		englishDictionary.put("a", ".-");
		englishDictionary.put("b", "-...");
		englishDictionary.put("c", "-.-.");
		englishDictionary.put("d", "-..");
		englishDictionary.put("e", ".");
		englishDictionary.put("f", "..-.");
		englishDictionary.put("g", "--.");
		englishDictionary.put("h", "....");
		englishDictionary.put("i", "..");
		englishDictionary.put("j", ".---");
		englishDictionary.put("k", "-.-");
		englishDictionary.put("l", ".-..");
		englishDictionary.put("m", "--");
		englishDictionary.put("n", "-.");
		englishDictionary.put("o", "---");
		englishDictionary.put("p", ".--.");
		englishDictionary.put("q", "--.-");
		englishDictionary.put("r", ".-.");
		englishDictionary.put("s", "...");
		englishDictionary.put("t", "-");
		englishDictionary.put("u", "..-");
		englishDictionary.put("v", "...-");
		englishDictionary.put("w", ".--");
		englishDictionary.put("x", "-..-");
		englishDictionary.put("y", "-.--");
		englishDictionary.put("z", "--..");
		englishDictionary.put("0", "-----");
		englishDictionary.put("1", ".----");
		englishDictionary.put("2", "..---");
		englishDictionary.put("3", "...--");
		englishDictionary.put("4", "....-");
		englishDictionary.put("5", ".....");
		englishDictionary.put("6", "-....");
		englishDictionary.put("7", "--...");
		englishDictionary.put("8", "---..");
		englishDictionary.put("9", "----.");
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
		if (englishDictionary.isEmpty()) {
			// Calls a method to initialize the dictionary
			init();
		}
		// Splits the morse code up by spaces
		String[] characters = new String[english.length()];
		for (int i = 0; i < english.length(); i++) {
			characters[i] = String.valueOf(english.charAt(i));
		}
		for(int i = 0; i < characters.length; i++) {
			// Replaces spaces with a slash
			if (characters[i].equals(" ")) {
				characters[i] = "/";
			}
			// Checks for the current english character in the dictionary
			if (englishDictionary.containsKey(characters[i])) {
				// Translates the current character
				characters[i] = englishDictionary.get(characters[i]);
				System.out.println(characters[i]);
			}
		}
		// Calls a method to convert the characters array to a single string
		String translatedText = convertToMorseString(characters);
		return translatedText;
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
		// Splits the morse code up by spaces
		String[] characters = morseCode.split("\\s+");
		for (int i = 0; i < characters.length; i++) {
			// Replaces slashes with a space
			if (characters[i].equals("/")) {
				characters[i] = " ";
			}
			// Checks for the current morse character in the dictionary
			if (morseCodeDictionary.containsKey(characters[i])) {
				// Translates the current character
				characters[i] = morseCodeDictionary.get(characters[i]);
			}
		}
		// Calls a method to convert the characters array to a single string
		String translatedText = convertToEnglishString(characters);
		return translatedText;
	}

	/**
	 * Converts array of strings to a single english string
	 * 
	 * @param array
	 *            - array of strings to be converted
	 * @return - generated string
	 */
	private static String convertToEnglishString(String[] array) {
		String output = array[0];
		// Appends each word onto the end of the current sentence
		for (int i = 1; i < array.length; i++) {
			output = output + array[i];
		}
		return output;

	}

	/**
	 * Converts array of strings to a single morse code string
	 * 
	 * @param array
	 *            - array of strings to be converted
	 * @return - generated string
	 */
	private static String convertToMorseString(String[] array) {
		String output = array[0];
		// Appends each word onto the end of the current sentence
		for (int i = 1; i < array.length; i++) {
			output = output + " " + array[i];
		}
		return output;

	}
}
