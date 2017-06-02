package wntools;

import java.util.ArrayList;

/**
 * Class containing functions for testing the WNTools library.
 * 
 * @author themis
 */
public class WNToolsTest {

	/**
	 * Tests the functionality of the WNTools library.
	 * 
	 * @param args unused parameter.
	 */
	public static void main(String[] args) {
		// Stem verb modified
		String word = "modified";
		word = Stemmer.stem(word, "v");
		System.out.println(word);

		// Stem verb edited
		String word2 = "edited";
		word2 = Stemmer.stem(word2, "v");
		System.out.println(word2);

		// Find the synonyms and the hypernyms of the verb modify
		word = "modify";
		ArrayList<String> synonyms = SynonymFinder.getSynonyms(word, "v");
		System.out.println(synonyms);
		ArrayList<String> hypernyms = SynonymFinder.getHypernyms(word, "v");
		System.out.println(hypernyms);

		// Find the similarity index between words modify and edit
		double sim = Similarity.getLinSimilarityBetweenVerbs(word, word2);
		System.out.println(sim);

		// Check if the following words are verbs
		for (String string : new String[] { "funny", "go", "try", "stop" }) {
			System.out.println(string + "  " + TypeFinder.isVerb(string));
		}
	}

}
