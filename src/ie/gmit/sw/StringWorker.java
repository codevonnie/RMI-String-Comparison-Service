package ie.gmit.sw;

/**
 * RMI side thread class which calls the distance method of the chosen algorithm and 
 * passes the result to the setResult method of the Resultator. The thread sleeps and
 * then the result method isProcessed is set to true
 * 
 * @author Yvonne Grealy
 * 
 */

import java.rmi.RemoteException;

public class StringWorker extends Thread
{
	private Resultator result;
	private String s;
	private String t;
	private Algos algo;

	public StringWorker(Resultator result, String s, String t, Algos algo)
	{
		this.result=result;
		this.s=s;
		this.t=t;
		this.algo=algo;
		
	}
	//thread run method
	public void run()
	{
		
		try
		{
			//get distance result and use to set result of Resultator
			result.setResult(algo.distance(s, t));
			Thread.sleep(1000);
			//set isProcessed to true so that the servlet will know the task is complete
			result.setProcessed();

		} catch (RemoteException | InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
