package wntools;

import java.util.ArrayList;
import java.util.List;

import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.ISynsetID;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.Pointer;

/**
 * Class containing functions for synonyms and hypernyms.
 * 
 * @author themis
 */
public class SynonymFinder {

	/**
	 * Returns a list of synonyms for a word given the word. This function does not require a type as
	 * function {@link #getSynonyms(String,String)} does, however it may not be equally effective.
	 * 
	 * @param word the word of which the synonyms are returned.
	 * @return an {@link ArrayList} of synonyms.
	 */
	public static ArrayList<String> getSynonyms(String word) {
		return getSynonyms(word, null);
	}

	/**
	 * Returns a list of synonyms for a word given the word and its type.
	 * 
	 * @param word the word of which the synonyms are returned.
	 * @param type the type of the word, which can be "n" for noun or "v" for verb.
	 * @return an {@link ArrayList} of synonyms.
	 */
	public static ArrayList<String> getSynonyms(String word, String type) {
		ArrayList<String> synonyms = new ArrayList<String>();
		if (WordNetController.dict != null) {
			IIndexWord idxWord = WordNetController.dict.getIndexWord(word, WordNetController.getPOSType(type));
			if (idxWord != null && !idxWord.getWordIDs().isEmpty()) {
				IWordID wordID = idxWord.getWordIDs().get(0);
				IWord wword = WordNetController.dict.getWord(wordID);
				ISynset synset = wword.getSynset();
				for (IWord w : synset.getWords())
					synonyms.add(w.getLemma());
			}
		}
		return synonyms;
	}

	/**
	 * Returns a list of hypernyms for a word given the word. This function does not require a type as
	 * function {@link #getHypernyms(String,String)} does, however it may not be equally effective.
	 * 
	 * @param word the word of which the hypernyms are returned.
	 * @return an {@link ArrayList} of hypernyms.
	 */
	public static ArrayList<String> getHypernyms(String word) {
		return getSynonyms(word, null);
	}

	/**
	 * Returns a list of hypernyms for a word given the word and its type.
	 * 
	 * @param word the word of which the hypernyms are returned.
	 * @param type the type of the word, which can be "n" for noun or "v" for verb.
	 * @return an {@link ArrayList} of hypernyms.
	 */
	public static ArrayList<String> getHypernyms(String word, String type) {
		ArrayList<String> hypernyms = new ArrayList<String>();
		if (WordNetController.dict != null) {
			IIndexWord idxWord = WordNetController.dict.getIndexWord(word, WordNetController.getPOSType(type));
			if (idxWord != null && !idxWord.getWordIDs().isEmpty()) {
				IWordID wordID = idxWord.getWordIDs().get(0);
				IWord wword = WordNetController.dict.getWord(wordID);
				ISynset synset = wword.getSynset();
				List<ISynsetID> hypsetlist = synset.getRelatedSynsets(Pointer.HYPERNYM);
				for (ISynsetID hypset : hypsetlist) {
					for (IWord w : WordNetController.dict.getSynset(hypset).getWords())
						hypernyms.add(w.getLemma());
				}
			}
		}
		return hypernyms;
	}

}
