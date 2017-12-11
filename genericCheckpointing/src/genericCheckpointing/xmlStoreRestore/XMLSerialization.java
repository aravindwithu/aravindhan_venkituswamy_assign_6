package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.Results;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

// create a new class to implement the XMLSerialization Strategy

public class XMLSerialization implements SerStrategy {
	private Results results;
	public XMLSerialization(){
		//System.out.println("In XMLSerialization - constructor");
	}

	public XMLSerialization(String fileName){
		//System.out.println("In XMLSerialization - constructor");
		results = new Results(fileName);
	}

    public void closeFile(){
    	results.closeWriter();
    }
    
    public SerializableObject processInput(SerializableObject sObject) {
    	try{
    		String XMLText = "<DPSerialization>\n";

			Class<?> cls = sObject.getClass();

			String className = cls.getName();

      		// all the code to create the output file with XML snippets for
     		// an object

    		XMLText += "  <complexType xsi:type=\""+cls.getName()+"\">\n";


            for(Field field : cls.getDeclaredFields()){
                String fieldName = field.getName();
                Type fieldType = field.getType();
                String methodName = "get" + fieldName;
                Method getterMethod = cls.getMethod(methodName);
                Object invokeRet = getterMethod.invoke(sObject);

                if(isValidValue(fieldType , invokeRet)){
                    if(fieldType == String.class){
                        XMLText += "    <"+fieldName + " xsi:type=\"xsd:string\">"+invokeRet+"</"+fieldName+">\n"; 
                    }else{
                        XMLText += "    <"+fieldName + " xsi:type=\"xsd:"+fieldType+"\">"+invokeRet+"</"+fieldName+">\n"; 
                    }
                }
            }

    		XMLText += "  </complexType>\n";
			XMLText += "</DPSerialization>";

        	results.writeSchedulesToFile(XMLText);
            return null;
    	}
    	catch(Exception ex){
    		System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
            return null;
    	}
   }

   private boolean isValidValue(Type fieldType , Object value){
        if(fieldType == int.class){
            if((int)value<10){
                return false;
            }
        }else if(fieldType == double.class){
            if((double)value<10){
                return false;
            }
        }else if(fieldType == long.class){
            if((long)value<10){
                return false;
            }
        }
        return true;
   }
}


