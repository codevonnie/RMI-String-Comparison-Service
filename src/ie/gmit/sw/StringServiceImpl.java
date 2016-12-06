package ie.gmit.sw;

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
		Algos algos = null;
		switch (algo) {
		case "Damerau-Levenshtein Distance":
			algos = new DamerauLevenshtein();
			break;

		case "Euclidean Distance":
			algos = new Levenshtein();
			break;

		case "Levenshtein":
			algos = new Levenshtein();
			break;

		case "Hamming Distance":
			algos = new HammingDistance();
			break;

		case "	Hirschberg's Algorithm":
			algos = new Levenshtein();
			break;

		case "JaroâWinkler Distance":
			algos = new Levenshtein();
			break;

		case "Levenshtein Distance":
			algos = new Levenshtein();
			break;

		case "	Needleman-Wunsch":
			algos = new Levenshtein();
			break;

		case "Smith Waterman":
			algos = new Levenshtein();
			break;

		default:
			algos = new Levenshtein();
			break;
		}
		
		
		Resultator rs = new ResultatorImpl();
		rs.setResult(algos.distance(s, t));
		//algos.distance(s, t);
		
		return rs;
	}

}
