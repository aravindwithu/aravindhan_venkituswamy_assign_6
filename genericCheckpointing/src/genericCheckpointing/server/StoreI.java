package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;

public interface StoreI extends StoreRestoreI {
      public void writeObj(SerializableObject aRecord, String wireFormat);
      public void setCheckPointFile(String fileName);
      public void closeCheckPointFile();
}