package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;

// RestoreI interface
public interface RestoreI extends StoreRestoreI {
     public Object readObj(String wireFormat);
     public void setReadFile(String fileName);
     public void closeReadFile();
}
