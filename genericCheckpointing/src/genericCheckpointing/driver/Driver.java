package genericCheckpointing.driver;

import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.MyLogger;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import java.util.Vector;

public class Driver 
{
	public static void main(String[] args) 
	{
		MyLogger myLogger; 
		FileProcessor file;
		// FIXME: read the value of checkpointFile from the command line
	   // FileProcessor file;
	    try{
	    	// command line validation for input file and output file respectively.
	    	String mode = "", outputFile = "";
	    	myLogger = new MyLogger();
	    	int N =0 , logger = 0;
		    if(4 == args.length){// validates given arguments array length to 3.
		    	if(!args[0].equals("${arg0}") && !args[0].equals("")){// validates 1st input file argument value.
		    		mode = args[0];
		    	}
		    	else{
		    		throw new Exception("Please provide mode.");
		    	}

		    	if(!args[1].equals("${arg0}") && !args[1].equals("")){// validates 2nd input file argument value.
		    		try{
		    			N = Integer.parseInt(args[1]);
		    		}
		    		catch(Exception e){
						e.printStackTrace();
						System.exit(0);
					}
		    	}
		    	else{
		    		throw new Exception("Please provide N.");
		    	}

		    	if(!args[2].equals("${arg1}") && !args[2].equals("")){// validates 3rd output file argument value.
					outputFile = args[2];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}
		    }
		    else{
		    	throw new Exception("Please pass atleast 3 arguments 1.mode, 2.N, and 3.output-file.");
		    }
		    
		    if(!args[3].equals("${arg4}") && !args[3].equals("")){
			    String arg2 = "01234";// validates logger value is between 0 and 4.
				if(args[3].length() != 1 || (!arg2.contains(args[3]))){
					throw new Exception("Logger value is incorrect");
				}
				else{
					try{
						logger = Integer.parseInt(args[3]);
						myLogger.setDebugValue(logger);
					}
					catch(Exception e){
						e.printStackTrace();
						System.exit(0);
					}					
				}
			}else{
				// by default logger value is 0;
			}
	
			ProxyCreator pc = new ProxyCreator();
			StoreRestoreHandler storeRestoreHandler = new StoreRestoreHandler();
			// create a proxy
			StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
										 new Class[] {
										     StoreI.class, RestoreI.class
										 }, 
										 storeRestoreHandler
										 );
			// FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file

			// Use an if/switch to proceed according to the command line argument
			// For deser, just deserliaze the input file into the data structure and then print the objects
			
			if(mode.equals("serdeser")){
				Vector<SerializableObject> serVectorOld = new Vector<SerializableObject>();
				((StoreI) cpointRef).setCheckPointFile(outputFile);
				for (int i=0; i<N; i++) {
					float a = 3.3f;
					short b = 1;
					MyAllTypesFirst myObjFirst = new MyAllTypesFirst(i+10, i*9999, "random", true, i+2);
					serVectorOld.add(myObjFirst);
					((StoreI) cpointRef).writeObj(myObjFirst, "XML");
					
					MyAllTypesSecond myObjSecound = new MyAllTypesSecond(i*9.9, a, b,'c', i*4.);
					serVectorOld.add(myObjSecound);
				    ((StoreI) cpointRef).writeObj(myObjSecound, "XML");
				}
				((StoreI) cpointRef).closeCheckPointFile();
			}
			else{
				Vector<SerializableObject> serVectorNew = new Vector<SerializableObject>();
				((RestoreI) cpointRef).setReadFile(outputFile);
				for (int j=0; j<2*N; j++) {
					SerializableObject deSerObj= (SerializableObject)((RestoreI) cpointRef).readObj(outputFile);
					serVectorNew.add(deSerObj);
				}
				((RestoreI) cpointRef).closeReadFile();
			}

			// FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)

			// FIXME: compare and confirm that the serialized and deserialzed objects are equal. 
			// The comparison should use the equals and hashCode methods. Note that hashCode 
			// is used for key-value based data structures
		}
	    catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.

	    }
	}
}