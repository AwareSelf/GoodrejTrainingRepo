package misci;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureEx {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		CompletableFuture<String> completableFuture
		  = CompletableFuture.supplyAsync(() -> "Hello");

		CompletableFuture<String> future = completableFuture
		  .thenApply(s -> s + " World");

		//assertEquals("Hello World", future.get());
		
		    System.out.println(future.get());
		    
/*
 * If we don't need to return a value down the Future chain, we can use an 
 * instance of the Consumer functional interface. Its single method takes a 
 * parameter and returns void.
 * There's a method for this use case in the CompletableFuture. 
 * The thenAccept method receives a Consumer and passes it the result of the 
 * computation. Then the final future.get() call returns an instance of the Void 
 * type:
*/
		    
		   CompletableFuture<String> completableFuture1
		    = CompletableFuture.supplyAsync(() -> "Hello");

		  CompletableFuture<Void> future1 = completableFuture1
		    .thenAccept(s -> System.out.println("Computation returned: " + s));

		  future1.get(); 
		  
		  
/*
 * Finally, if we neither need the value of the computation, nor want to return 
 * some value at the end of the chain, then we can pass a Runnable lambda to the 
 * thenRun method. 
 * In the following example, we simply print a line in the console after calling 
 * the future.get():
*/
		  CompletableFuture<String> completableFuture2 
		  			= CompletableFuture.supplyAsync(() -> "Hello");

		  CompletableFuture<Void> future2 = completableFuture2
				  .thenRun(() -> System.out.println("Computation finished."));

		  future2.get();
		  
		  
		  
/*
 * In the following example we use the thenCompose method to chain two Futures 
 * sequentially.
   Notice that this method takes a function that returns a CompletableFuture 
   instance. The argument of this function is the result of the previous 
   computation step. This allows us to use this value inside the next 
   CompletableFuture‘s lambda:
*/

	 CompletableFuture<String> completableFuturee
		    = CompletableFuture.supplyAsync(() -> "Hello")
		      .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " Namrata"));

		//  assertEquals("Hello World", completableFuturee.get());
	 
	System.out.println(completableFuturee.get());
		  
		  
		  
/*
 * In the example below, we have a method that creates a CompletableFuture instance,
 * then spins off some computation in another thread and returns the Future 
 * immediately.
   When the computation is done, the method completes the Future by providing the 
   result to the complete method:		  
 */
		  Future<String> completableFuture3 = calculateAsync();
		  String resultt = completableFuture3.get();
		 // assertEquals("Hello", result);
		  System.out.println("result:"+resultt);
 

	}
	
	public  static Future<String> calculateAsync() throws InterruptedException {
	    CompletableFuture<String> completableFuture = new CompletableFuture<>();

	    Executors.newCachedThreadPool().submit(() -> {
	    	System.out.println("async task started..");
	        Thread.sleep(500);
	        System.out.println("async task complete..");
	        
	       //If not already completed, sets the value returned by get() and 
	        //related methods to the given value. 
	        completableFuture.complete("Hello");
	        return null;
	    });

	    return completableFuture;
	}

}

//https://www.baeldung.com/java-completablefuture
