package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class StringServiceRunner
{
	public static void main(String[] args) throws Exception
	{
		
		StringService ss = new StringServiceImpl();
		//Start the RMI regstry on port 1099
		LocateRegistry.createRegistry(1099);
		
		//Bind our remote object to the registry
		Naming.rebind("algoService", ss);
		
		System.out.println("Server ready");

	}

}
