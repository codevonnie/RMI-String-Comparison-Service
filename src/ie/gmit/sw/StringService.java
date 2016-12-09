package ie.gmit.sw;

/**
 * Remote interface exposes the public service method compare that may be invoked by
 * a remote object and throws a RemoteException
 * 
 * @author Yvonne Grealy
 */

import java.rmi.*;

public interface StringService extends Remote
{
	public Resultator compare(String s, String t, String algo) throws RemoteException;
}
