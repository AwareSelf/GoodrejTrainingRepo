package concurrentpattern;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorEx2 {
	
	/**
	 
	 * Tasks are executed concurrently in a thread pool
	 */
	

	 public static void main(String[] args) {
		 // concurrent executor
		 ExecutorService concurrentThreadExecutor = Executors.newCachedThreadPool();// or
	                  // newFixedThreadPool(3)
	  List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();

	  // create dummy tasks
	  for (int i = 1; i <= 5; i++) {
	   tasks.add(createTask(i));
	  }

	  // submit the tasks to the concurrentThreadExecutor
	  try {
	       concurrentThreadExecutor.invokeAll(tasks);

	  } catch (InterruptedException e) {
	       e.printStackTrace();
	  }

	  System.out.println("Completed .........");

	 }

	 private static Callable<Boolean> createTask(final int i) {

	  Callable<Boolean> task = new Callable<Boolean>() {

	   @Override
	   public Boolean call() throws Exception {
	      System.out.println("Performing task " + i + " on thread - " + Thread.currentThread().getName());
	      return true;
	   }

	  };

	  return task;

	 }
	}




