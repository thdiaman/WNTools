package wntools;

/**
 * Class containing functions for computing the semantic similarity between words.
 * 
 * @author themis
 */
public class Similarity {

	/**
	 * Calculates the Lin similarity measure betweeen two nouns. See paper:
	 * Lin, D. (1998, July). An information-theoretic definition of similarity. In ICML (Vol. 98, pp. 296-304).
	 * 
	 * @param word1 the first noun.
	 * @param word2 the second noun.
	 * @return the Link similarity between the two given nouns.
	 */
	public static double getLinSimilarityBetweenNouns(String word1, String word2) {
		WordNetController.setDummyOutStream();
		double ret = WordNetController.lin.max(word1, word2, "n");
		WordNetController.unsetDummyOutStream();
		return ret;
	}

	/**
	 * Calculates the Lin similarity measure betweeen two verbs. See paper:
	 * Lin, D. (1998, July). An information-theoretic definition of similarity. In ICML (Vol. 98, pp. 296-304).
	 * 
	 * @param word1 the first verb.
	 * @param word2 the second verb.
	 * @return the Link similarity between the two given verbs.
	 */
	public static double getLinSimilarityBetweenVerbs(String word1, String word2) {
		WordNetController.setDummyOutStream();
		double ret = WordNetController.lin.max(word1, word2, "v");
		WordNetController.unsetDummyOutStream();
		return ret;
	}

}
