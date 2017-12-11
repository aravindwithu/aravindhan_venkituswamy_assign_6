package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;	

public class FileProcessor{
	private BufferedReader file; // BufferedReader object to read from file.
	private boolean isFileOpen = false;//  to maintain whether the file is open or not state.
	/**
	* FileProcessor constructor to intialize FileProcessor class.
	* Requires input file course to intialize the BufferedReader object.
	* Exception is thrown if given file does not exits.
	* @param filename to open the file reader object.
	*/
	public FileProcessor(String filename){
		File fileCheck;
		try{
			// Check if file doesn't exist
			fileCheck = new File(filename);
			if(!fileCheck.exists() || fileCheck.isDirectory()) {
			    System.err.println("The " + filename + " file does not exist.Please include it");
			    System.exit(1);
			}
			file = new BufferedReader(new FileReader(filename));
			isFileOpen = true;
		}
		catch (Exception ex)
	  	{
	    	System.err.println(ex.getMessage());
	    	ex.printStackTrace();
	    	System.exit(0);
	  	}
	  	finally{
	  		fileCheck = null;
	  	}
	}
	/**
	* readLine method.
	* Reads the line from file.
	* If read is true then readLine() is returned else file object is closed.
	* The readLine method called by the threads to read line from file is synchronized.
	* @param read - If read is true then readLine() is returned else file object is closed. 
	* @return String - read file line string or message related to file activity.
	*/
	public String readLine(boolean read){
		try{
			if(isFileOpen){
				if(read){
					return file.readLine();
				}
				else{
					closeFile();
					return "file closed sucessfully";
				}
			}else{
				return "file is in closed state";
			}
		}
		catch (Exception ex)
	  	{
	    	System.err.println(ex.getMessage());
	    	ex.printStackTrace();
	    	System.exit(0);
	    	return null;
	  	}
	}
	/**
	* closeFile method.
	* closes the file object.
	*/
	public void closeFile(){
		try{
			file.close();
			isFileOpen = false;
		}
		catch (Exception ex)
	  	{
	    	System.err.println(ex.getMessage());
	    	ex.printStackTrace();
	    	System.exit(0);
	  	}
	  	finally{
	  		file = null;
	  	}
	}
}