package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;

public class StoreRestoreHandler implements InvocationHandler{

  private SerStrategy strategy = null;
  private SerStrategy strategy2 = null;

  // constructor
  public StoreRestoreHandler(){

  }

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable{

    // if the method is write
    // if the wireFormat is XML
    //  call serializeData(args[0], new XMLSerializationStrategy());
   
    // if statements to check if it is the read method so that
    // deserialization can be done ... }
    if(m.getName().equals("writeObj")){
      if(args[1].toString().equals("XML")){
        return (Object)serializeData((SerializableObject)args[0] ,strategy);
      }
    }
    else if(m.getName().equals("readObj")){
      return (Object)deSerializeData(args[0].toString() ,strategy);
    }
    else if(m.getName().equals("setCheckPointFile")){
      if(strategy == null){
          strategy = new XMLSerialization(args[0].toString());
      }
    }
    else if(m.getName().equals("closeCheckPointFile")){
      if(strategy != null){
        strategy.closeFile();
        strategy = null;
      }
    }
    else if(m.getName().equals("setReadFile")){
      if(strategy == null){
        strategy = new XMLDeserialization(args[0].toString());
      }
    }
    else if(m.getName().equals("closeReadFile")){
      if(strategy == null){
        strategy.closeFile();
        strategy = null;
      }
    }
    return null;
  }

  // serialize data
  public SerializableObject serializeData(SerializableObject sObject, SerStrategy sStrategy) {
        sObject = sStrategy.processInput(sObject);
        return sObject;
  }

  // deserialize data
  public SerializableObject deSerializeData(String wireFormat, SerStrategy sStrategy) {
      SerializableObject sObject = new SerializableObject();
      sObject = sStrategy.processInput(sObject);
      return sObject;
  }

}


