package ie.gmit.sw;

import java.util.concurrent.*;

public class Worker implements Runnable
{
	private BlockingQueue<Runnable> queue;
	//private StringService ss;

	public Worker(BlockingQueue<Runnable> queue)
	{
		this.queue=queue;
		
	}

	public void run()
	{
		/*
		while(!queue.isEmpty()){ //while queue is not empty
			try
			{
				
				//Resultable r = queue.take();//result is taken from queue
				
								
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		*/
	}
}
