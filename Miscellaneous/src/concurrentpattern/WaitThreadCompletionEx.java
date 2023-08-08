package concurrentpattern;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/*
 * https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-concurrency-basic
 */
public class WaitThreadCompletionEx {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		ExecutorService WORKER_THREAD_POOL = Executors.newFixedThreadPool(10);

		List<DelayedCallable> callables = Arrays.asList(
		  new DelayedCallable("fast thread", 100), 
		  new DelayedCallable("slow thread", 3000));

		long startProcessingTime = System.currentTimeMillis();
		List<Future<String>> futures = WORKER_THREAD_POOL.invokeAll(callables);

		//awaitTerminationAfterShutdown(WORKER_THREAD_POOL);

		long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
		 
		System.out.println(totalProcessingTime+" >= 3000");

		String firstThreadResponse = futures.get(0).get();
		 
		System.out.println("fast thread".equals(firstThreadResponse));

		String secondThreadResponse = futures.get(1).get();
		System.out.println("slow thread".equals(secondThreadResponse));
		
		
		 ExecutorService executor = Executors.newFixedThreadPool(10);

		   

		        executor.submit(() -> {
		            new Task();
		        });

		        executor.shutdown();
		        executor.shutdownNow();
		        try {
		            executor.awaitTermination(20l, TimeUnit.NANOSECONDS);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		    
	
	}

}

class DelayedCallable implements Callable<String> {
    
    private String name;
    private long period;
    private CountDownLatch latch;
    
    public DelayedCallable(String name, long period, CountDownLatch latch) {
        this(name, period);
        this.latch = latch;
    }

    public DelayedCallable(String name, long period) {
        this.name = name;
        this.period = period;
    }

    public String call() {

        try {
            Thread.sleep(period);
            
            if (latch != null) {
                latch.countDown();
            }
            
        } catch (InterruptedException ex) {
            // handle exception
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }

        return name;
    }
}

class Task implements Runnable {

	@Override
	public void run() {
		// task details
	}

}
