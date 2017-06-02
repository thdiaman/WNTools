package wntools;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.morph.WordnetStemmer;
import edu.sussex.nlp.jws.JWS;
import edu.sussex.nlp.jws.Lin;

/**
 * Class connecting to the WordNet database.
 * 
 * @author themis
 */
public class WordNetController {

	/**
	 * The JWS object for using the similarity measures.
	 */
	private static JWS ws;

	/**
	 * The dictionary object that loads WordNet.
	 */
	static IDictionary dict;

	/**
	 * The Lin similarity measure object.
	 */
	static Lin lin;

	/**
	 * The WordNet stemmer.
	 */
	static WordnetStemmer stemmer;

	/**
	 * The default output stream of java.
	 */
	private static PrintStream outStream = System.out;

	/**
	 * Sets the output stream of java to a dummy one.
	 */
	static void setDummyOutStream() {
		System.setOut(new PrintStream(new OutputStream() {
			@Override
			public void write(int b) throws IOException {

			}
		}));
	}

	/**
	 * Sets the output stream of java to the default.
	 */
	static void unsetDummyOutStream() {
		System.setOut(outStream);
	}

	/**
	 * Static constructor used to initialize this controller. If no database can be found this class does not crash,
	 * however no stemming/synonym operations are performed.
	 */
	static {
		outStream = System.out;
		setDummyOutStream();
		String wordnetDirectory = System.getProperty("user.dir") + System.getProperty("file.separator") + "wordnet";
		ws = new JWS(wordnetDirectory, "3.0");
		dict = ws.getDictionary();
		stemmer = new WordnetStemmer(dict);
		lin = ws.getLin();
		unsetDummyOutStream();
	}

	/**
	 * Returns the type of a term as a POS object.
	 * 
	 * @param type the type of a term.
	 * @return the type of the given term as a POS object.
	 */
	static POS getPOSType(String type) {
		POS posType = null;
		if (type != null) {
			if (type.equals("n"))
				posType = POS.NOUN;
			else if (type.equals("v"))
				posType = POS.VERB;
		}
		return posType;
	}

}