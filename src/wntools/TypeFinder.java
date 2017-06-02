package wntools;

import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.POS;

/**
 * Class containing functions for determining the type of a word.
 * 
 * @author themis
 */
public class TypeFinder {

	/**
	 * Checks if the given word is a verb.
	 * 
	 * @param word the word to be checked if it is a verb.
	 * @return {@code true} if the word is a verb, {@code false} otherwise.
	 */
	public static boolean isVerb(String word) {
		if (WordNetController.dict != null) {
			IIndexWord idxWord = WordNetController.dict.getIndexWord(word, POS.VERB);
			if (idxWord != null && !idxWord.getWordIDs().isEmpty())
				return idxWord.getPOS().equals(POS.VERB);
			else
				return false;
		} else
			return false;
	}

	/**
	 * Checks if the given word is a noun.
	 * 
	 * @param word the word to be checked if it is a noun.
	 * @return {@code true} if the word is a noun, {@code false} otherwise.
	 */
	public static boolean isNoun(String word) {
		if (WordNetController.dict != null) {
			IIndexWord idxWord = WordNetController.dict.getIndexWord(word, POS.NOUN);
			if (idxWord != null && !idxWord.getWordIDs().isEmpty())
				return idxWord.getPOS().equals(POS.NOUN);
			else
				return false;
		} else
			return false;
	}

}
