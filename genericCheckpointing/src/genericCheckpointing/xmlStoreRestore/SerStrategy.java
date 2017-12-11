package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;

// create a new interface
public interface SerStrategy {
   public SerializableObject processInput(SerializableObject sObject);
   public void closeFile();
}