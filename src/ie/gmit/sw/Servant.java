package ie.gmit.sw;

/**
 * Runner for RMI which starts the RMI registry and binds the StringServiceImpl instance
 * 
 * @author Yvonne Grealy
 */

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servant
{
	public static void main(String[] args) throws Exception
	{
		//create instance of StringServiceImpl
		StringService ss = new StringServiceImpl();
		
		//Start the RMI regstry on port 1099
		LocateRegistry.createRegistry(1099);
		
		//Bind remote object to the registry
		Naming.rebind("StringCompService", ss);
		
		System.out.println("Server ready");

	}

}
