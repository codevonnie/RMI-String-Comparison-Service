package ie.gmit.sw;

/**
 * Requester object which contains the input from the webapp i.e. two Strings for comparison, the chosen algorithm as well as
 * the allocated taskNumber.  
 * 
 * @author Yvonne Grealy
 *
 */

public class Requester
{
	private String s;
	private String t;
	private String taskNo;
	private String algorithm;
	
	//constructor takes in 4 Strings
	public Requester(String s, String t, String taskNo, String algorithm){
		this.s=s;
		this.t=t;
		this.setTaskNo(taskNo);
		this.setAlgorithm(algorithm);
	}
	
	//Getters and setters for Strings
	public String getString1(){
		return this.s;
	}
	
	public void setString1(String s){
		this.s=s;
	}
	
	public String getString2(){
		return this.t;
	}
	
	public void setString2(String t){
		this.t=t;
	}
	
	public String getTaskNo(){
		return this.taskNo;
	}
	
	public void setTaskNo(String taskNo){
		this.taskNo=taskNo;
	}
	
	public String getAlgorithm(){
		return this.algorithm;
	}
	
	public void setAlgorithm(String algorithm){
		this.algorithm=algorithm;
	}
}
