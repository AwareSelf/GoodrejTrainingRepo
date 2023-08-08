package misci;

import java.util.concurrent.Callable;  
import java.util.concurrent.ExecutionException;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
import java.util.concurrent.Future;  

public class FutureInterfaceEx  
{  

	public static void main(String args[])  
	{ 
		//creating ExecutorService with pool of 4 threads  
		ExecutorService es = Executors.newFixedThreadPool(4);  //newFixedThreadPool is (static) factory method to create ExecutorService 
		
		//submitting 6 tasks  
		Future<String> f1 = es.submit(new PrintSting("Java"));  
		Future<String> f2 = es.submit(new PrintSting("Python"));  
		Future<String> f3 = es.submit(new PrintSting("Flutter"));  
	//	Future<String> f4 = es.submit(new PrintSting("MySQL")); 
		Future<Integer> f4 = es.submit(new MyLoop(100)); 
		Future<String> f5 = es.submit(new PrintSting("Bash"));  
		Future<String> f6 = es.submit(new PrintSting("Go"));  

		//invoking some other methods  
		anotherMethod();  
		try   
		{  
			//invoking get() method to get the future value  
			System.out.println("1. " + f1.get());  
			System.out.println("2. " + f2.get());  
			System.out.println("3. " + f3.get());  
			
			if(!f4.isDone())
			{
				if(f5.isDone())
					System.out.println("5. " + f5.get());  
				if(f6.isDone())
					System.out.println("6. " + f6.get());
			}
			while(!f4.isDone())  
			{  
				System.out.println("waiting for task f4 to finish..");  
						
				Thread.sleep(10);  
			}             
			System.out.println("4. " + f4.get());  
			
		}  
				//catching exception if any  
		catch (InterruptedException | ExecutionException e)   
		{  
			//prints exception      
			e.printStackTrace();  
		}  
			//shutting down the ExecutorService  
			es.shutdown();  
	}  

	public static void anotherMethod()  
	{  
		System.out.println("I am in temp method");  
	}  
}  


//implementing callable  
class PrintSting implements Callable<String>   
{  
	String str;  
	
	PrintSting(String str)  
	{  
		this.str = str;  
	}  

	@Override  
	public String call() throws Exception   
	{  
		System.out.println("In call method of PrintString class " + str);  
		StringBuffer sb = new StringBuffer();  
		return (sb.append("Length of string ").append(str).append(" is ").append(str.length())).toString();  
	}  
}  

class MyLoop implements Callable<Integer>
{
	int no;
	
	MyLoop(int no)
	{
		this.no=no;
	}
	
	public Integer call() throws InterruptedException
	{
		int sum=0;
		for(int i=0;i<no;i++)
		{
		   	sum += i;
		   	System.out.println("Thread name:"+Thread.currentThread().getName()+", i="+i);
		   	Thread.sleep(100);
		}
		
		return sum;
		
	}
	
}