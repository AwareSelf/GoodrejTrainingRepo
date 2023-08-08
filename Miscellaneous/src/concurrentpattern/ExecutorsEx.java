package concurrentpattern;
import java.util.concurrent.*;
import static java.util.concurrent.Executors.*;

public class ExecutorsEx{
	
	public static void main(String[] args)
	{
	ExecutorService executor = Executors.newSingleThreadExecutor();
	executor.submit(() -> {
	    String threadName = Thread.currentThread().getName();
	    System.out.println("Hello " + threadName); // => Hello pool-1-thread-1
	});
	
	/*
	 * Here, it submits a Runnable task for execution and returns a Future representing that task. 
	 * Since Runnable is a functional interface, we are utilizing Java 8 lambda expressions to print
	 * the current threads name to the console.
	 */
	
	try {
	    System.out.println("attempt to shutdown executor");
	    executor.shutdown();
	    executor.awaitTermination(5, TimeUnit.SECONDS);
	}
	catch (InterruptedException e) {
	    System.err.println("tasks interrupted");
	}
	finally {
	    if (!executor.isTerminated()) {
	        System.err.println("cancel non-finished tasks");
	    }
	    executor.shutdownNow();
	    System.out.println("shutdown finished");
	}

	/*
	 * The class Executors provides convenient factory methods for creating different kinds of executor services.
	 * In this sample we use an executor with a thread pool of size one.
	 */
	ExecutorService executorService1 = Executors.newSingleThreadExecutor();
	ExecutorService executorService2 = Executors.newFixedThreadPool(5);
	
	/*
	Delegating Tasks to ExecutorService
	Below are few of the different ways that can be used to delegate tasks for execution to an ExecutorService:

	execute(Runnable command)
	submit(Callable task)
	submit(Runnable task)
	invokeAny(Collection<? extends Callable<T>> tasks)
	invokeAll(Collection<? extends Callable<T>> tasks)
	*/
	
	}

}
