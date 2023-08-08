package concurrentpattern;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExceptionHandlingEx {
	//https://www.callicoder.com/java-callable-and-future-tutorial/
	public static void main(String[] args)
	{
	       ExecutorService executorService = Executors.newSingleThreadExecutor();

		        Future<String> future = executorService.submit(() -> {
		            Thread.sleep(2000);
		            return "Hello from Callable";
		        });

		        while(!future.isDone()) {
		            System.out.println("Task is still not done...");
		            try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }

		        System.out.println("Task completed! Retrieving the result");
		        try {
		        	String result = future.get();
			        System.out.println(result);
		        	}  catch (CancellationException ce) {
		              Throwable  t = ce;
		              t.printStackTrace();
		            } catch (ExecutionException ee) {
		                Throwable t = ee.getCause();
		                t.printStackTrace();
		            } catch (InterruptedException ie) {
		                Thread.currentThread().interrupt();
		            }
		        

		        executorService.shutdown();
		    }//end of main
		}
	


