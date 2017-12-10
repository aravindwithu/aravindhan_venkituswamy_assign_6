package genericCheckpointing.server;

public interface StoreIextends StoreRestoreI {
      void writeObj(MyAllTypesFirst aRecord, int authID, String wireFormat);
      void writeObj(MyAllTypesSecond bRecord, int authID, String wireFormat);
}