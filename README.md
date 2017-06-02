# WNTools
Natural Language Processing tools based on WordNet

## Libraries used:
The following libraries are used (added in folder lib):
- [MIT Java Wordnet Interface (JWI)](http://projects.csail.mit.edu/jwi/)  
  Developed by Mark Alan Finlayson, Princeton University.
- [Java WordNet::Similarity (JWS)](https://web.archive.org/web/20150328023411/http://www.sussex.ac.uk/Users/drh21/)  
  Developed by David Hope, University Of Sussex, Brighton, England, BN2.

Check the license file for all licenses.

## WordNet data used:
Ths WordNet data used are the following:
- [WordNet 3.0](http://wordnetcode.princeton.edu/3.0/WordNet-3.0.tar.gz)  
  Unzipped and put folder "dict" in path "./wordnet/3.0/"
- [WordNet 3.0 Info Content](http://www.d.umn.edu/~tpederse/Data/WordNet-InfoContent-3.0.tar.gz)  
  Unzipped and put folder "WordNet-InfoContent-3.0" in path "./wordnet/3.0/"

## Usage as a library:
Using WNTools requires adding a directory for the libraries and a directory for WordNet in your project.  
For the libraries directory, you have to create a folder "lib" and put inside WNTools.jar, edu.mit.jwi_2.3.3.jar, and edu.sussex.nlp.jws.beta.11.jar. After that, add the three libraries to classpath.  
For the wordnet directory, you have to create a folder "wordnet" and inside create a folder "3.0". Inside "3.0" copy folder "dict" from WordNet-3.0.tar.gz and folder "WordNet-InfoContent-3.0" from WordNet-InfoContent-3.0.tar.gz.  
Finally, you can copy WNToolsTest.java in your project and execute it to check that everything works correctly.  
