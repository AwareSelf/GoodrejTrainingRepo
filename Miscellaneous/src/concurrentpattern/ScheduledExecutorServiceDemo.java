package concurrentpattern;


import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

	public class ScheduledExecutorServiceDemo {

		private void execute() {
			ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
			getTasksToRun().apply(executorService);
			executorService.shutdown();
		}

		private void executeWithMultiThread() {
			ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
			getTasksToRun().apply(executorService);
			executorService.shutdown();
		}

		private Function<ScheduledExecutorService, Void> getTasksToRun() {
			return (executorService -> {
				ScheduledFuture<?> scheduledFuture1 = executorService.schedule(() -> {
					// Task
					new FactorialTask(5);
				}, 1, TimeUnit.SECONDS);

				ScheduledFuture<?> scheduledFuture2 = executorService.scheduleAtFixedRate(() -> {
					// Task
				}, 1, 10, TimeUnit.SECONDS);

				ScheduledFuture<?> scheduledFuture3 = executorService.scheduleWithFixedDelay(() -> {
					// Task
				}, 1, 10, TimeUnit.SECONDS);

				ScheduledFuture<String> scheduledFuture4 = executorService.schedule(() -> {
					// Task
					return "Hellow world";
				}, 1, TimeUnit.SECONDS);
				return null;
			});
		}

		public static void main(String... args) {
			ScheduledExecutorServiceDemo demo = new ScheduledExecutorServiceDemo();
			demo.execute();
			demo.executeWithMultiThread();
		}
		
		


	}
	
	

class FactorialTask implements Callable<Integer> {
	    int number;

	    public FactorialTask(int number) {
	        this.number = number;
	    }

	    public Integer call() throws InvalidParamaterException {
	        int fact=1;
	        if(number < 0)
	            throw new InvalidParamaterException("Number must be positive");

	        for(int count=number;count>1;count--){
	            fact=fact * count;
	        }

	        return fact;
	    }

	    private class InvalidParamaterException extends Exception {
	        public InvalidParamaterException(String message) {
	            super(message);
	        }
	    }
	}


