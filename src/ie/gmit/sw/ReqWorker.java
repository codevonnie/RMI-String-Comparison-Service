package ie.gmit.sw;

/**
 * Thread class which polls inQueue for requests and makes requests to the RMI service
 * 
 * @author Yvonne Grealy
 */


import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Map;

public class ReqWorker implements Runnable
{
	private StringService ss;
	Resultator result;
	private Map<String, Resultator> outQueue;
	private LinkedList<Requester> inQueue; 
	//constructor which takes StringService instance, outQueue Map for return Resultator and LinkedList inQueue where requests have been placed
	public ReqWorker(StringService ss, Map<String, Resultator> outQueue, LinkedList<Requester> inQueue)
	{
		this.ss=ss;
		this.outQueue=outQueue;
		this.inQueue=inQueue;
		
	}
	//thread start
	public void run()
	{
		//new Requester object polls inQueue for request
		Requester request = inQueue.poll();
		
		try
		{
			System.out.println("Checking result for: " + request.getTaskNo());
			//Resultator returned by RMI gets saved to local result
			result = ss.compare(request.getString1(), request.getString2(), request.getAlgorithm());
			//add task number and object ID to outQueue
			outQueue.put(request.getTaskNo(), result);
						
		} catch (RemoteException e)
		{
			e.printStackTrace();
		}
	}
}
