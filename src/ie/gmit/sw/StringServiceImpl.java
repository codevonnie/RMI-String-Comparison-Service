package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;

public class StringServiceImpl extends UnicastRemoteObject implements StringService
{
	private static final long serialVersionUID = 269913374743865561L;

	public StringServiceImpl() throws RemoteException
	{
		super();
	}

	public Resultator compare(String s, String t, String algo)
			throws RemoteException
	{
		Algos algos = null;
		switch (algo) {
		case "Damerau-Levenshtein Distance":
			algos= new DamerauLevenshtein();
			
			break;

		case "Levenshtein":
			algos = new Levenshtein();
			break;
		
		
		case "HammingDistance":
			algos = new HammingDistance();
			break;
		}
		
		
		Resultator rs = new ResultatorImpl(s,t);
		algos.distance(s, t);

		return rs;
	}

}
