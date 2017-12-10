package genericCheckpointing.server;

public interface RestoreIextends StoreRestoreI {
      SerializableObject readObj(String wireFormat);
}
