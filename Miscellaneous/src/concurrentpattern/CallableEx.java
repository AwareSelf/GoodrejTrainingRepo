package concurrentpattern;

import java.util.concurrent.Callable;



public class CallableEx {

}

class FactorialTask1 implements Callable<Integer> {
    int number;

    public FactorialTask1(int number) {
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