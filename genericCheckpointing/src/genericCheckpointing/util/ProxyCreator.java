package genericCheckpointing.util;

public class ProxyCreator{
	public void	createProxy(){
		StoreRestoreI  serDeserObj = (StoreRestoreI)Proxy.newProxyInstance(
                                   getClass().getClassLoader(), interfaceArray, handler);
	}
}