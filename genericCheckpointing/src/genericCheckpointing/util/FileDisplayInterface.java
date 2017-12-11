package genericCheckpointing.util;

/**
* FileDisplayInterface interface.
* Created for cs542 - Design patterns.
* FileDisplayInterface interface to write to output file.
*/
public interface FileDisplayInterface{

	/**
	* writeSchedulesToFile method.
	* Implements FileDisplayInterface writeSchedulesToFile method.
	* gets String s as argument.
	* writes the given string to output file.
	* @param string to be writtern to the writer object. 
	*/
	public void writeSchedulesToFile(String string);
}