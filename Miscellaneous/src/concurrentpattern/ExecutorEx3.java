package concurrentpattern;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/*
 * Example of assigning a task to ExecutorService using execute() method

The Java ExecutorService's execute() method takes in a runnable object and performs its 
task asynchronously. After making the call to execute method, we call the shutdown method, 
which blocks any other task to queue up in the executorService.

 */

public class ExecutorEx3 {
	
		  
	    public static void main(String[] args) throws InterruptedException, ExecutionException {  
	        ExecutorService executorService = Executors.newFixedThreadPool(10);  
	        executorService.execute(new Runnable() {  
	              
	            @Override  
	            public void run() {  
	                System.out.println("ExecutorService");  
	                  
	            }  
	        });  
	        executorService.shutdown();  
	        
/*
 Example of assigning a task to ExecutorService using submit()
 The submit() method takes in a runnable object and returns a Future object. This object is later on used to check the status of Runnable whether it has completed execution or not.
*/
	          
         
           ExecutorService executorService1 = Executors.newSingleThreadExecutor();  
           executorService1.submit(new Runnable() {  
	                      
                @Override  
                public void run() {  
                    System.out.println("ExecutorService");  
	                          
                  }  
             });  

           
/*
 * Example of assigning a task to ExecutorService using invokeAll() method

The invokeAll() method takes in a Collection of Callable objects having tasks and returns a list 
of Future objects containing the result of all the tasks.
 */
	                
           ExecutorService executorService2 = Executors.newSingleThreadExecutor();  
	                
           Set<Callable<String>> callables = new HashSet<Callable<String>>();  
	          
           callables.add(new Callable<String>() {  
              public String call() throws Exception {  
	                        return "Task 1";  
            }  
          });  
            callables.add(new Callable<String>() {  
               public String call() throws Exception {  
                      return "Task 2";  
                 }  
              });  
           callables.add(new Callable<String>() {  
               public String call() throws Exception {  
                      return "Task 3";  
                  }  
               });  
	          
            java.util.List<Future<String>> futures = executorService2.invokeAll(callables);  
	          
            for(Future<String> future : futures){  
               System.out.println("future.get = " + future.get());  
              }  
	          
            executorService.shutdown();  
	          
      
	            
	        
	    }  
	  
	}  


