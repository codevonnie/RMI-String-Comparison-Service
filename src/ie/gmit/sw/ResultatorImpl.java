package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;

public class ResultatorImpl extends UnicastRemoteObject implements Resultator
{
	private static final long serialVersionUID = 1L;
	private String result;
	private boolean process;
	private String s;
	private String t;
	
	public ResultatorImpl() throws RemoteException
	{
		super();
	}
	
	public ResultatorImpl(String s, String t) throws RemoteException
	{
		super();
		this.s= s;
		this.t=t;
	}

	
	public String getResult() throws RemoteException
	{
		return "stuff";
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
		this.process=true;
	}
	
}
