package com.hello;


import java.util.Arrays;
import java.util.List;

public class Test implements Runnable 
{

	List<String> l = Arrays.asList("N","O","K","II","A");
    int counter = 0;
	public  synchronized Integer getCounter() 
	{
		counter = counter++;
		return counter;
	}

	public synchronized void setCounter(Integer counter) 
	{
		this.counter = counter;
	}

	public static void main(String[] args) 
	{
			Thread t1 = new Thread(new Test(),"1");
			Thread t2 = new Thread(new Test(),"2");
			t1.start();
			t2.start();
	
	}

	@Override
	public void run() 
	{
		while (true)
		{
				printData();
		}
	}

	/**
	 * 
	 */
	private synchronized void printData() 
	{

		//System.out.println(Thread.currentThread().getName());
		
		if (Thread.currentThread().getName().equals("1"))
		{
			counterUpdation();

			System.out.print("_" + l.get(counter++));
			notifyAll();
			try 
			{
				Thread.sleep(500);
				//l.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		else
		{
			counterUpdation();
			System.out.print("_" + l.get(counter++));
			notifyAll();
			try {
				Thread.sleep(500);
				//l.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void counterUpdation() {
		counter = counter>4?0:counter;		
		if(counter==0)
			System.out.println();
	}

}
