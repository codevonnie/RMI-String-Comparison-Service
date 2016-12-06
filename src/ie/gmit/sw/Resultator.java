package ie.gmit.sw;

import java.rmi.*;

public interface Resultator extends Remote
{
	public String getResult() throws RemoteException;
	public void setResult(String result) throws RemoteException;
	public boolean isProcessed() throws RemoteException;
	public void setProcessed() throws RemoteException;
}
