package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.FileProcessor;
import java.lang.reflect.Method;

// create a new class to implement the XMLSerialization Strategy

public class XMLDeserialization implements SerStrategy {
    private FileProcessor file = null;

    public XMLDeserialization(){
		//System.out.println("In XMLSerialization - constructor");
	}

    public XMLDeserialization(String fileIn){
    	file = new FileProcessor(fileIn);
	}

	public void closeFile(){
    	file.closeFile();
    }
	
    public SerializableObject processInput(SerializableObject sObject) {
		try{
			System.out.println("deser");
	    	String line;
			while ((line = file.readLine(true)) != null)
		    {		    
	    		String[] words = line.split("=");
	    		if(words.length>=2){
	    			System.out.println(words[1]);
	    			String[] tagWord = words[1].split(">");
	    			if(tagWord.length>=2){
	    				System.out.println(tagWord[0]);
	    				String[] tagValue = tagWord[1].split("<");
	    				System.out.println("value -> " + tagValue[0]);
	    			}
	    		}
	    	}

	    	return null;
	    }
	    catch(Exception ex){
    		System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    	return null;
    	}
   }
}


