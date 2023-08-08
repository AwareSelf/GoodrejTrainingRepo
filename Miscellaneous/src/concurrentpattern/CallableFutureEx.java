package concurrentpattern;
import java.util.concurrent.*;


public class CallableFutureEx {
//And the following program submits two tasks above to a fixed thread pool executor:
		 
	    public static void main(String[] args) {
	        ExecutorService pool = Executors.newFixedThreadPool(2);
	 
	        Future<Integer> sumResult = pool.submit(new SumCalculator(100000));
	        Future<Integer> factorialResult = pool.submit(new FactorialCalculator(8));
	 
	 
	        try {
	 
	            Integer sumValue = sumResult.get();
	 
	            System.out.println("Sum Value = " + sumValue);
	 
	            Integer factorialValue = factorialResult.get();
	 
	            System.out.println("Factorial Value = " + factorialValue);
	 
	        } catch (InterruptedException | ExecutionException ex) {
	            ex.printStackTrace();
	        }
	 
	        pool.shutdown();
	        
	        /*
	        Cancelling a Task:
	        The Future interface defines the following method that allows you to cancel a task:
	        boolean cancel(boolean mayInterruptIfRunning)

	        This method returns false if the task has already completed, has already been cancelled, or could not be cancelled for some other reason.
	        If this method returns true:
	        - The task will never run if it has not started.

	        - In case the task has already started, you can decide to interrupt the thread executing the task by specifying the flag mayInterruptIfRunning = true. Otherwise, the task continues until completes.

	        For example, the following code will cancel the task if it has been running longer than 3 seconds:
	        */
	        
	        ExecutorService pool1 = Executors.newFixedThreadPool(2);

	        Future<Integer> factorialResult1 = pool1.submit(new FactorialCalculator(8));
	         
	         
	        try {
	         
	            Integer factorialValue = null;
	         
	            try {
	         
	                factorialValue = factorialResult1.get(3, TimeUnit.SECONDS);
	         
	            } catch (TimeoutException ex ) {
	                ex.printStackTrace();
	            }
	         
	            if (factorialValue != null) {
	         
	                System.out.println("Factorial Value = " + factorialValue);
	         
	            } else {
	         
	                boolean cancelled = factorialResult1.cancel(true);
	         
	                System.out.println("Task cancelled? " + cancelled);
	            }
	         
	        } catch (InterruptedException | ExecutionException ex ) {
	            ex.printStackTrace();
	        }
	         
	        pool.shutdown();
	        
	        /*
	         * Run this code and you will see that after 3 seconds, 
	         * it throws a TimeoutException because the wait timed out, and throws an 
	         * InterruptedException because the thread executing the task was interrupted because 
	         * of the call:
			 boolean cancelled = factorialResult.cancel(true);
             In addition, the Future interface provides methods for checking the completion status:
				boolean isDone(): returns true if this task completed.
				boolean isCancelled(): returns true if this task was cancelled before it completed 
				normally.
	         */
	    }
	}




/*
 * 
 * Run this program and observe the result. The first task, SumCalculator takes 2 seconds to 
 * complete and you see the result displayed after 2 seconds:

   Sum Value = 705082704
   The second task, FactorialCalculator takes 5 seconds to complete, so you see the result 3 
   seconds after the first result:

   Factorial Value = 40320
 */




/**
 * FactorialCalculator.java
 * This class represents a task that computes and returns factorial value
 * of N numbers.
 *  */
class FactorialCalculator implements Callable<Integer> {
    private int n;
 
    public FactorialCalculator(int n) {
        this.n = n;
    }
 
    public Integer call() {
        int result = 1;
 
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
 
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
 
        return result;
    }
}


/**
 * SumCalculator.java
 * This class represents a task that computes and returns value of
 * sum of N numbers.
 * */
class SumCalculator implements Callable<Integer> {
    private int n;
 
    public SumCalculator(int n) {
        this.n = n;
    }
 
    public Integer call() {
        int sum = 0;
 
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
 
        return sum;
    }
}