package concurrentpattern;

//https://howtodoinjava.com/java/multi-threading/how-to-use-blockingqueue-and-threadpoolexecutor-in-java/
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
//import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class BlockingQueueEx {
	
	 public static void main(String[] args) throws InterruptedException {
		 
		 /*
		  * What is blocking queue?
A blocking queue is a queue that blocks when you try to dequeue from it and the queue is empty, 
or if you try to enqueue items to it and the queue is already full. A thread trying to dequeue 
from an empty queue is blocked until some other thread inserts an item into the queue
		  */
		 /*
	        BlockingQueue<Runnable> blockingQueue =
	                new LinkedBlockingQueue<Runnable>();

	        CustomThreadPoolExecutor1 executor =
	                new CustomThreadPoolExecutor1(10, 20, 5, TimeUnit.SECONDS,
	                        blockingQueue, new ThreadPoolExecutor.AbortPolicy());

	        // Let start all core threads initially
	        executor.prestartAllCoreThreads();

	        for (int i = 1; i <= 100; i++) {
	            blockingQueue.offer(new DemoTask("Task " + i));
	        }

	        executor.shutdown();
	        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
	        */
		 
		 BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
		 ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, MILLISECONDS, new ArrayBlockingQueue<>(1), new GrowPolicy());
	        executor.execute(() -> waitFor(100));

	       
	        executor.execute(() -> queue.offer("First"));
	        executor.execute(() -> queue.offer("Second"));
	        executor.execute(() -> queue.offer("Third"));

	        waitFor(150);
	        List<String> results = new ArrayList<>();
	        queue.drainTo(results);
	       // assertThat(results).containsExactlyInAnyOrder("First", "Second", "Third");
		    System.out.println(results);
	    

	    }
	 
	    private static void waitFor(int millis) {
	        try {
	            Thread.sleep(millis);
	        } catch (InterruptedException ignored) {
	        }
	    }


}

class GrowPolicy implements RejectedExecutionHandler {

    private final Lock lock = new ReentrantLock();

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        lock.lock();
        try {
        	System.out.println("inside rejectedExecution.."+executor.getActiveCount()+"maxpoolsize:"+executor.getMaximumPoolSize());
            executor.setMaximumPoolSize(executor.getMaximumPoolSize() + 1);
            
            System.out.println(executor.getMaximumPoolSize());
        } finally {
            lock.unlock();
        }

        executor.submit(r);
    }
    

}


class CustomThreadPoolExecutor1 extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor1(int corePoolSize, int maximumPoolSize,
            long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue,RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println("Perform beforeExecute() logic");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null) {
            System.out.println("Perform exception handler logic");
        }
        System.out.println("Perform afterExecute() logic");
    }
}
class DemoTask implements Runnable {
    private String name = null;

    public DemoTask(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing : " + name);
    }
}