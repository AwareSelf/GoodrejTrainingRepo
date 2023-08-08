package concurrentpattern;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureEx {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		// Create a CompletableFuture
		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
		   try {
		       TimeUnit.SECONDS.sleep(1);
		   } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		   }
		   return "Rajeev";
		});

		// Attach a callback to the Future using thenApply()
		CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
		   return "Hello " + name;
		});

		// Block and get the result of the future.
		System.out.println(greetingFuture.get()); // Hello Rajeev
		
		Executor executor = Executors.newFixedThreadPool(10);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    return "Result of the asynchronous computation";
		}, executor);
		
		CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Rajeev";
		}).thenApply(name -> {
		    return "Hello " + name;
		}).thenApply(greeting -> {
		    return greeting + ", Welcome to the CalliCoder Blog";
		});

		System.out.println(welcomeText.get());
		// Prints - Hello Rajeev, Welcome to the CalliCoder Blog
		
		/*
		thenAccept() and thenRun()
		If you don’t want to return anything from your callback function and just want to run some piece of code after the completion of the Future, then you can use thenAccept() and thenRun() methods. These methods are consumers and are often used as the last callback in the callback chain.

		CompletableFuture.thenAccept() takes a Consumer<T> and returns CompletableFuture<Void>. It has access to the result of the CompletableFuture on which it is attached.
        */
		
		// thenAccept() example
		int productId=1;
		CompletableFuture.supplyAsync(() -> {
			return ProductService.getProductDetail(productId);
		}).thenAccept(product -> {
			System.out.println("Got product detail from remote service " + product.getName());
		});
		
		/*
		While thenAccept() has access to the result of the CompletableFuture on which it is attached,
		 thenRun() doesn’t even have access to the Future’s result. It takes a Runnable and returns
		  CompletableFuture<Void> -
		  */

		// thenRun() example
		CompletableFuture.runAsync(() -> {
		    // Run some computation  
			System.out.println("inside supplyAsync using thenRun");
			
		}).thenRun(() -> {
		    // Computation Finished.
			System.out.println("inside supplyAsync using thenRun");
		});
		
		/*
		 * The task inside thenApply() is executed in the same thread where the supplyAsync() task 
		 * is executed, or in the main thread if the supplyAsync() task completes immediately 
		 * (try removing sleep() call to verify).

            To have more control over the thread that executes the callback task, you can use async
            callbacks. If you use thenApplyAsync() callback, then it will be executed in a different
            thread obtained from ForkJoinPool.commonPool() -
            
            Moreover, If you pass an Executor to the thenApplyAsync() callback then the task will 
            be executed in a thread obtained from the Executor’s thread pool.
		 */
		Executor executorr = Executors.newFixedThreadPool(2);
		CompletableFuture.supplyAsync(() -> {
		    return "Some result";
		}).thenApplyAsync(result -> {
		    // Executed in a thread obtained from the executor
		    return "Processed Result";
		}, executorr);
		
		
		/*
		 * 
		 * Combine two dependent futures using thenCompose() 
		 * https://www.callicoder.com/java-8-completablefuture-tutorial/
		 * 
		 * CompletableFuture<User> getUsersDetail(String userId) {
				return CompletableFuture.supplyAsync(() -> {
					return UserService.getUserDetails(userId);
				});	
			}

		CompletableFuture<Double> getCreditRating(User user) {
				return CompletableFuture.supplyAsync(() -> {
					return CreditRatingService.getCreditRating(user);
				});
			}
			
		CompletableFuture<Double> result = getUserDetail(userId)
			.thenCompose(user -> getCreditRating(user));
		 */
		
		/*
		 * While thenCompose() is used to combine two Futures where one future is dependent 
		 * on the other, thenCombine() is used when you want two Futures to run independently 
		 * and do something after both are complete.
		 * 
		 * System.out.println("Retrieving weight.");
		CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
    	try {
        	TimeUnit.SECONDS.sleep(1);
    		} catch (InterruptedException e) {
       			throw new IllegalStateException(e);
    		}
    			return 65.0;
			});

			System.out.println("Retrieving height.");
			CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
    		try {
        		TimeUnit.SECONDS.sleep(1);
    			} catch (InterruptedException e) {
       			throw new IllegalStateException(e);
    		}
    			return 177.8;
			});

			System.out.println("Calculating BMI.");
			CompletableFuture<Double> combinedFuture = weightInKgFuture
        		.thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
    				Double heightInMeter = heightInCm/100;
    				return weightInKg/(heightInMeter*heightInMeter);
					});

				System.out.println("Your BMI is - " + combinedFuture.get());
		 * https://www.callicoder.com/java-8-completablefuture-tutorial/
		 */
	}

}

class Product
{
	String name;
	
	Product(String name)
	{
		this.name=name;
	}
	
	String getName()
	{
		return name;
	}
}

class ProductService
{
	static Product getProductDetail(int id)
	{
		Product p = new Product("Tshirt");
		return p;
	}
}