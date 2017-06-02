package wntools;

import java.util.List;

/**
 * Class containing functions used to stem words.
 * 
 * @author themis
 */
public class Stemmer {

	/**
	 * Stems a word. This function does not require a type as function {@link #stem(String,String)} does,
	 * however it may not be equally effective.
	 * 
	 * @param word the word to be stemmed.
	 * @return the stemmed word.
	 */
	public static String stem(String word) {
		return stem(word, null);
	}

	/**
	 * Stems a word given its type.
	 * 
	 * @param word the word to be stemmed.
	 * @param type the type of the word, which can be "n" for noun or "v" for verb.
	 * @return the stemmed word.
	 */
	public static String stem(String word, String type) {
		String fword = word.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		if (WordNetController.stemmer != null) {
			List<String> stems = WordNetController.stemmer.findStems(fword, WordNetController.getPOSType(type));
			return stems.isEmpty() ? fword : stems.get(0);
		} else
			return fword;
	}

}
