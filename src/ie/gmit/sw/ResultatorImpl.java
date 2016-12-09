package ie.gmit.sw;

/**
 * Implementation of Resultator which has getter setter methods to get and set the result
 * of the algorithm distance computation.  It also has methods to get/set whether the 
 * task is processed.
 * 
 * @author Yvonne Grealy
 */

import java.rmi.*;
import java.rmi.server.*;

public class ResultatorImpl extends UnicastRemoteObject implements Resultator
{
	private static final long serialVersionUID = 1L;
	private String result;
	private boolean process;
	
	public ResultatorImpl() throws RemoteException{}
	
	//returns result when called
	public String getResult() throws RemoteException
	{
		return result;
	}
	//sets result 
	public void setResult(String result) throws RemoteException
	{
		this.result = result;
		
	}
	//called by servlet to check if job is processed
	public boolean isProcessed() throws RemoteException
	{
		return process;
	}
	//called when job is processed
	public void setProcessed() throws RemoteException
	{
		this.process=true;
	}
	
}
