package ie.gmit.sw;

public class Requester
{
	private String firstString;
	private String secondString;
	private String taskNo;
	private String algorithm;
	
	
	public Requester(String firstString, String secondString, String taskNo, String algorithm){
		this.firstString=firstString;
		this.secondString=secondString;
		//this.setTaskNo(taskNo);
		this.setAlgorithm(algorithm);
	}
	
	public String getString1(){
		return this.firstString;
	}
	
	public void setString1(String firstString){
		this.firstString=firstString;
	}
	
	public String getString2(){
		return this.secondString;
	}
	
	public void setString2(String secondString){
		this.secondString=secondString;
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
