package genericCheckpointing.util;

/**
* MyLogger class.
* Created for cs542 - Design patterns, Assignment 3.
*/

public class MyLogger{
    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Prints the prime length words]
      DEBUG_VALUE=2 [Print to stdout before writing to file]
      DEBUG_VALUE=1 [prints the palimdrome words]
      DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]
    */

    public static enum DebugLevel {RELEASE, PALINDROME_HIGHLIGHT, FILE_WRITE, PRIME_LENGTH, CONSTRUCTOR};

    private static DebugLevel debugLevel;

    public static void setDebugValue (int levelIn) {
		switch (levelIn) {
            case 0: debugLevel = DebugLevel.RELEASE; break;
            case 1: debugLevel = DebugLevel.PALINDROME_HIGHLIGHT; break;
            case 2: debugLevel = DebugLevel.FILE_WRITE; break;
	 		case 3: debugLevel = DebugLevel.PRIME_LENGTH; break;
            case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
		}
    }

    public static void setDebugValue (DebugLevel levelIn) {
		debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message, DebugLevel levelIn ) {
    	if (levelIn == debugLevel)
    	    System.out.println(message);
    }

    /**
	 * @return String
	 */
    public String toString() {
		return "Debug Level is " + debugLevel;
    }
}
