package ie.gmit.sw;

/**
 * Servlet to take in user input and create requests for processing in the RMI using an ExecutorService Thread Pool
 * 
 * @author Yvonne Grealy
 */


import java.io.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServiceHandler extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	private String remoteHost = null;
	private static long jobNumber = 0;
	private static LinkedList<Requester> inQueue = new LinkedList<Requester>();
	private static Map<String, Resultator> outQueue = new HashMap<String, Resultator>();
	private static ExecutorService executor = Executors.newFixedThreadPool(50);
	private boolean isProcessed = false;
	private String distance;

	public void init() throws ServletException
	{
		ServletContext ctx = getServletContext();
		remoteHost = ctx.getInitParameter("RMI_SERVER"); // Reads the value from
															// the
															// <context-param>
															// in web.xml
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get an instance of the StringService object
		StringService ss = null;
		try
		{
			//Ask the registry running on 10.2.2.65 and listening in port 1099 for the instannce of
			//the StringService object that is bound to the RMI registry with the name StringCompService
			ss = (StringService) Naming.lookup("rmi://127.0.0.1:1099/StringCompService");
		} catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//Initialise some request varuables with the submitted form info. These are local to this method and thread safe...
		String algorithm = req.getParameter("cmbAlgorithm");
		String s = req.getParameter("txtS");
		String t = req.getParameter("txtT");
		String taskNumber = req.getParameter("frmTaskNumber");
		
		out.print("<html><head><title>Distributed Systems Assignment</title>");		
		out.print("</head>");		
		out.print("<body>");
		
		
		if (taskNumber == null){
			taskNumber = new String("T" + jobNumber);
			//create a new Requester object with 4 String params
			Requester re = new Requester(s, t, taskNumber, algorithm);
			//add new Requester object to the inQueue for processing
			inQueue.add(re);
			//create a an instance of a Runnable object and pass it the declared StringService object, the outQueue to store a Resultator and the inQueue to be processed
			Runnable worker = new ReqWorker(ss, outQueue, inQueue);
			//start ExecutorService
            executor.execute(worker);
            //increment jobNumber for the next task
            jobNumber++;

			System.out.println("");
			
			
		}else{
			//Checks outqueue to see if task is processed
			//if outQueue has a key of the current task number, store the Resultator value to variable result
			if(outQueue.containsKey(taskNumber)) {
				Resultator result = outQueue.get(taskNumber);
				System.out.println("Checking status of Job, No:" + taskNumber);
				//if the result has been processed, get the distance result and remove the entry from the outQueue - otherwise continue to poll
				if (result.isProcessed() == true) {
					
					isProcessed=true;
					distance=result.getResult();
					outQueue.remove(taskNumber);
					System.out.println("Job" + taskNumber + " processed and removed from map");
				}
			}
		}
		
		
		//Output to web app processing page
		out.print("<H1>Processing request for Job#: " + taskNumber + "</H1>");
		out.print("<div id=\"r\"></div>");
		
		out.print("<font color=\"#993333\"><b>");
		out.print("RMI Server is located at " + remoteHost);
		out.print("<br>Algorithm: " + algorithm);		
		out.print("<br>String <i>s</i> : " + s);
		out.print("<br>String <i>t</i> : " + t);
		
		//if variable isProcessed is false, continue to poll results else output distance result
		if(isProcessed==false){
			out.print("<form name=\"frmRequestDetails\">");
		}
		else{
			out.print("<br>String distance: " + distance);
		}
		
		
		out.print("<input name=\"cmbAlgorithm\" type=\"hidden\" value=\"" + algorithm + "\">");
		out.print("<input name=\"txtS\" type=\"hidden\" value=\"" + s + "\">");
		out.print("<input name=\"txtT\" type=\"hidden\" value=\"" + t + "\">");
		out.print("<input name=\"frmTaskNumber\" type=\"hidden\" value=\"" + taskNumber + "\">");
		
		out.print("</form>");								
		out.print("</body>");	
		out.print("</html>");	
		
		out.print("<script>");
		//if not complete send this else don't return anything
		out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 10000);");
		out.print("</script>");
				

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		doGet(req, resp);
	}
}