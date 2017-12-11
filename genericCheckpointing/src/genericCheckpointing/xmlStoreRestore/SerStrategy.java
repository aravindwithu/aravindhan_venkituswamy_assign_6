package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;

// create a new interface
public interface SerStrategy {
   public void processInput(SerializableObject sObject);
}