package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.Results;
import java.lang.reflect.Method;

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

    		if(className.equals("genericCheckpointing.util.MyAllTypesFirst")){
    			String fieldName = "myInt";
	  			String methodName = "get" + fieldName;
        		Method getterMethod = cls.getMethod(methodName);
        		Object invokeRet = getterMethod.invoke(sObject);
        		XMLText += "    <myInt xsi:type=\"xsd:int\">"+invokeRet+"</myInt>\n";

        		fieldName = "myLong";
	  			methodName = "get" + fieldName;
        		getterMethod = cls.getMethod(methodName);
        		invokeRet = getterMethod.invoke(sObject);
        		XMLText += "    <myLong xsi:type=\"xsd:long\">"+invokeRet+"</myLong>\n";

    			fieldName = "myString";
	  			methodName = "get" + fieldName;
        		getterMethod = cls.getMethod(methodName);
        		invokeRet = getterMethod.invoke(sObject);
        		XMLText += "    <myString xsi:type=\"xsd:string\">"+invokeRet+"</myString>\n";

        		fieldName = "myBool";
	  			methodName = "get" + fieldName;
        		getterMethod = cls.getMethod(methodName);
        		invokeRet = getterMethod.invoke(sObject);
        		XMLText += "    <myBool xsi:type=\"xsd:boolean\">"+invokeRet+"</myBool>\n";

        		fieldName = "myOtherInt";
	  			methodName = "get" + fieldName;
        		getterMethod = cls.getMethod(methodName);
        		invokeRet = getterMethod.invoke(sObject);
        		XMLText += "    <myOtherInt xsi:type=\"xsd:int\">"+invokeRet+"</myOtherInt>\n";

    		}else{
    			String fieldName = "myDoubleT";
	  			String methodName = "get" + fieldName;
        		Method getterMethod = cls.getMethod(methodName);
        		Object invokeRet = getterMethod.invoke(sObject);
        		XMLText += "    <myDoubleT xsi:type=\"xsd:double\">"+invokeRet+"</myDoubleT>\n";

        		fieldName = "myFloatT";
	  			methodName = "get" + fieldName;
        		getterMethod = cls.getMethod(methodName);
        		invokeRet = getterMethod.invoke(sObject);
        		XMLText += "    <myFloatT xsi:type=\"xsd:float\">"+invokeRet+"</myFloatT>\n";

    			fieldName = "myShortT";
	  			methodName = "get" + fieldName;
        		getterMethod = cls.getMethod(methodName);
        		invokeRet = getterMethod.invoke(sObject);
        		XMLText += "    <myShortT xsi:type=\"xsd:short\">"+invokeRet+"</myShortT>\n";

        		fieldName = "myCharT";
	  			methodName = "get" + fieldName;
        		getterMethod = cls.getMethod(methodName);
        		invokeRet = getterMethod.invoke(sObject);
        		XMLText += "    <myCharT xsi:type=\"xsd:char\">"+invokeRet+"</myCharT>\n";

                fieldName = "myOtherDoubleT";
                methodName = "get" + fieldName;
                getterMethod = cls.getMethod(methodName);
                invokeRet = getterMethod.invoke(sObject);
                XMLText += "    <myOtherDoubleT xsi:type=\"xsd:double\">"+invokeRet+"</myOtherDoubleT>\n";
    		}

    		XMLText += "  </complexType>\n";
			XMLText += "</DPSerialization>";

        	System.out.println(XMLText);
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
}


