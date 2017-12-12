package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.FileProcessor;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

// create a new class to implement the XMLSerialization Strategy

public class XMLDeserialization implements SerStrategy {
  private FileProcessor file = null;

  // constructor
  public XMLDeserialization(){
	}

  // constructor to set file name for file processor
  public XMLDeserialization(String fileIn){
    	file = new FileProcessor(fileIn);
	}

  // close file to close file processor
	public void closeFile(){
    	file.closeFile();
    }
	
  // processInput where deserializaion for given file is done
  public SerializableObject processInput(SerializableObject sObject) {
		try{
	    	String line;
	    	Object objInst = null;
	    	Class<?> cls;
	    	Constructor<?> cons;

			while ((line = file.readLine(true)) != null)
		    {		    
	    		String[] words = line.split("=");
	    		if(words.length>=2){

	    			String className = getClassName(words[1]);
	    			if(!className.equals("")){
	    				cls = Class.forName(className);
	    				cons = cls.getConstructor();
	    				objInst = cons.newInstance();
	    				return (SerializableObject)setObj(objInst, cls);
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

   // set the respective object
   private Object setObj(Object objInst, Class<?> cls){
   	try{
   		String lineIn = "";
		while ((lineIn = file.readLine(true)) != null)
		{ 
			if(lineIn.replace(" ","").equals("</complexType>")){
				return objInst;
			}else{
				String[] words = lineIn.split("=");
				String methodName = "set" + getFieldName(words[0].trim());
				String fieldType = getFieldType(words[1].trim());
				String fieldValue = getFieldValue(words[1].trim());
				Method setterMethod = processSetterMethod(cls, methodName, fieldType);
				Object setObjVal = processSetObjVal(fieldType, fieldValue);
       	setterMethod.invoke(objInst, setObjVal);
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

   // process the setter method
   private Method processSetterMethod(Class<?> cls, String methodName, String fieldType){
   	try{
   		Method rtnMethod = null;
   		if(fieldType.equals("int")){
   			rtnMethod = cls.getMethod(methodName, int.class);
   		}
   		else if(fieldType.equals("short")){
   			rtnMethod = cls.getMethod(methodName, short.class);
   		}
   		else if(fieldType.equals("double")){
   			rtnMethod = cls.getMethod(methodName, double.class);
   		}
   		else if(fieldType.equals("float")){
   			rtnMethod = cls.getMethod(methodName, float.class);
   		}
   		else if(fieldType.equals("long")){
   			rtnMethod = cls.getMethod(methodName, long.class);
   		}
   		else if(fieldType.equals("string")){
   			rtnMethod = cls.getMethod(methodName, String.class);
   		}
   		if(fieldType.equals("char")){
   			rtnMethod = cls.getMethod(methodName, char.class);
   		}
   		if(fieldType.equals("boolean")){
   			rtnMethod = cls.getMethod(methodName, boolean.class);
   		}
   		return rtnMethod;
   	}
	catch(Exception ex){
    		System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    	return null;
    	}
   }

   // process the set object value
   private Object processSetObjVal(String fieldType, String fieldValue){
   	try{
   		Object rtnObjVal = null;
   		if(fieldType.equals("int")){
   			rtnObjVal = Integer.parseInt(fieldValue);
   		}
   		else if(fieldType.equals("short")){
   			rtnObjVal = Short.parseShort(fieldValue);
   		}
   		else if(fieldType.equals("double")){
   			rtnObjVal = Double.parseDouble(fieldValue);
   		}
   		else if(fieldType.equals("float")){
   			rtnObjVal = Float.parseFloat(fieldValue);
   		}
   		else if(fieldType.equals("long")){
   			rtnObjVal = Long.parseLong(fieldValue);
   		}
   		else if(fieldType.equals("string")){
   			rtnObjVal = fieldValue;
   		}
   		if(fieldType.equals("char")){
   			rtnObjVal = fieldValue.charAt(0);
   		}
   		if(fieldType.equals("boolean")){
   			rtnObjVal = Boolean.parseBoolean(fieldValue);
   		}
   		return rtnObjVal;
   	}
	catch(Exception ex){
    		System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    	return null;
    	}
   }

   // gets the field name
   private String getFieldName(String str){
   		String[] strSplit = str.split(" ");
   		String rtnStr = strSplit[0].replace("<","");
   		return rtnStr;
   }

   // gets field types
   private String getFieldType(String str){
   		String[] strSplit = str.split(">");
   		String rtnStr = strSplit[0].replace("\"", "").replace("xsd:","");
   		return rtnStr;
   }

   // gets the field value
   private String getFieldValue(String str){
   		String[] strSplit = str.split(">");
   		String[] strVal = strSplit[1].split("<");
   		String rtnStr = strVal[0];
   		return rtnStr;
   }

   // gets class Name
   private String getClassName(String str){
   	str = str.replace("\"", "");
		str = str.replace(">", "");
    return str;
   }
}