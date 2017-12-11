package genericCheckpointing.util;
/**
* StdoutDisplayInterface interface.
* StdoutDisplayInterface interface to write to stdout (print) in command line.
*/
public interface StdoutDisplayInterface{
	/**
	* writeToScreen method.
	* Implements StdoutDisplayInterface writeToScreen method.
	* gets String s as argument.
	* prints the given string to command line.
	* @param string to print the same to output command line.
	*/
	public void writeToScreen(String string);
}