package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;

public class ResultatorImpl extends UnicastRemoteObject implements Resultator
{
	private static final long serialVersionUID = 1L;
	private String result;
	private boolean process;
	
	public ResultatorImpl() throws RemoteException
	{
		super();
	}

	
	public String getResult() throws RemoteException
	{
		return result;
	}

	public void setResult(String result) throws RemoteException
	{
		this.result = result;
		
	}

	public boolean isProcessed() throws RemoteException
	{

		return false;
	}

	public void setProcessed() throws RemoteException
	{
		// TODO Auto-generated method stub
		
	}
	
}
