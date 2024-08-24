package threads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private Semaphore sFizz;
    private Semaphore sBuzz;
    private Semaphore sFizzBuzz;
    private Semaphore sNum;

    public FizzBuzz(int n) {
        this.n = n;
        sNum = new Semaphore(1);
        sFizz = new Semaphore(0);
        sBuzz = new Semaphore(0);
        sFizzBuzz = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                sFizz.acquire();
                printFizz.run();
                sNum.release();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                sBuzz.acquire();
                printBuzz.run();
                sNum.release();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sFizzBuzz.acquire();
                printFizzBuzz.run();
                sNum.release();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            sNum.acquire();
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                sNum.release();
            } else if (i % 3 == 0 && i % 5 == 0) {
                sFizzBuzz.release();
            } else if (i % 3 == 0) {
                sFizz.release();
            } else {
                sBuzz.release();
            }
        }
    }
}

class PrintFizzBuzz{
    public static void main(String[] args) {
        int n = 15; // Change this value to test with a different range
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        Thread threadFizz = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadBuzz = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadFizzBuzz = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadNumber = new Thread(() -> {
            try {
                fizzBuzz.number(number -> System.out.print(number + ", "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start all threads
        threadFizz.start();
        threadBuzz.start();
        threadFizzBuzz.start();
        threadNumber.start();
    }
}