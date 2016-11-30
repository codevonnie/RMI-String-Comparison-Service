package ie.gmit.sw;

import java.rmi.*;
import java.rmi.registry.*;

public class StringServiceRunner
{
	public static void main(String[] args) throws Exception
	{
		
		StringService ss = new StringService();
		//Start the RMI regstry on port 1099
		LocateRegistry.createRegistry(1099);
		
		//Bind our remote object to the registry with the human-readable name "howdayService"
		Naming.rebind("algoService", ms);

	}

}
