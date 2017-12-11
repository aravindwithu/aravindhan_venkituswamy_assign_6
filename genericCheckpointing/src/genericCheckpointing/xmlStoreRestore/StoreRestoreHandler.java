package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;

public class StoreRestoreHandler implements InvocationHandler{

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
        //System.out.println(m.getName());
        SerStrategy strategy = new XMLSerialization();
        serializeData((SerializableObject)args[0] ,strategy);
      }
    }else{
      System.out.println(m.getName());
    }

    return null;

  }

   public void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
        sStrategy.processInput(sObject);
    }

    public void deSerializeData(SerializableObject sObject, SerStrategy sStrategy) {
        SerStrategy strategy = new XMLDeserialization();
        strategy.processInput(sObject);
    }

}


