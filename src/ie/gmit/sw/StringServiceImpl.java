package ie.gmit.sw;

/**
 * StringServiceImpl class which implements StringService interface and overrides the compare
 * method.  Incoming request is checked for which algorithm has been chosen, starts a thread to
 * start the processing of the request and immediately returns a Resultator to the requester.
 * 
 * @author Yvonne Grealy
 */

import java.rmi.*;
import java.rmi.server.*;

public class StringServiceImpl extends UnicastRemoteObject implements StringService
{
	private static final long serialVersionUID = 1L;


	public StringServiceImpl() throws RemoteException
	{
		super();
	}

	public Resultator compare(String s, String t, String algo)
			throws RemoteException
	{
		//create an instance of the Algos object
		Algos algos = null;
		//switch to determine which algorithm has been chosen in the GUI and sets the appropriate agorithm instance
		switch (algo) {
		case "Damerau-Levenshtein Distance":
			algos = new DamerauLevenshtein();
			break;

		case "Hamming Distance":
			algos = new HammingDistance();
			break;

		case "Levenshtein Distance":
			algos = new Levenshtein();
			break;

		default:
			algos = new Levenshtein();
			break;
		}
		
		//create new Resultator object
		Resultator rs = new ResultatorImpl();
		
		//new thread of type Worker which takes the resultator, the two strings for comparison and the chosen algorithm object
		Thread thread = new Thread(new StringWorker(rs, s, t, algos));
		//start thread
		thread.start();
		//return empty Resultator to requester
		return rs;
	}

}
