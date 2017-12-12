package genericCheckpointing.driver;

import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
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
		FileProcessor file;
		// FIXME: read the value of checkpointFile from the command line
	   // FileProcessor file;
	    try{
	    	// command line validation for input file and output file respectively.
	    	String mode = "", outputFile = "";
	    	int N =0 , logger = 0;
		    if(3 == args.length){// validates given arguments array length to 3.
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
		    	throw new Exception("Please pass exactly 3 arguments 1.mode, 2.N, and 3.output-file.");
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
				// serialize, deserialize mode
				Vector<SerializableObject> serVector = new Vector<SerializableObject>();
				// set file
				((StoreI) cpointRef).setCheckPointFile(outputFile);
				for (int i=0; i<N; i++) {
					boolean aBool = ((i%2) == 0);
					MyAllTypesFirst myObjFirst = new MyAllTypesFirst(i+9, i*9999, ("index_"+i), aBool, i+7);
					serVector.add(myObjFirst);
					((StoreI) cpointRef).writeObj(myObjFirst, "XML");
					
					double aDouble = (i/2) * 9.9;
					double bDouble = (i/3) * 5.9;
					float aFloat = (float)i* 3.3f;
					short aShort = (short)i;
					MyAllTypesSecond myObjSecound = new MyAllTypesSecond(aDouble, aFloat, aShort, 'c', bDouble);
					serVector.add(myObjSecound);
				    ((StoreI) cpointRef).writeObj(myObjSecound, "XML");
				}
				// close file
				((StoreI) cpointRef).closeCheckPointFile();

				Vector<SerializableObject> deserVector = new Vector<SerializableObject>();
				((RestoreI) cpointRef).setReadFile(outputFile);
				for (int i=0; i<2*N; i++) {
					SerializableObject deSerObj= (SerializableObject)((RestoreI) cpointRef).readObj(outputFile);
					deserVector.add(deSerObj);
				}
				((RestoreI) cpointRef).closeReadFile();

				int missCount = 0;
				for (int i=0; i<2*N; i++) {
					SerializableObject ser = serVector.get(i);
					SerializableObject deser = deserVector.get(i);
					if(!ser.equals(deser)){
						missCount++;
					}
				}

				System.out.println("Number of mismatch obj is "+missCount);
			}
			else{
				// deserialize mode
				Vector<SerializableObject> deserVector = new Vector<SerializableObject>();
				// set file
				((RestoreI) cpointRef).setReadFile(outputFile);
				for (int j=0; j<2*N; j++) {
					SerializableObject deSerObj= (SerializableObject)((RestoreI) cpointRef).readObj(outputFile);
					deserVector.add(deSerObj);
					System.out.println(deSerObj.toString()+"\n");
				}
				// close file
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
	    	file = null;
	    }
	}
}