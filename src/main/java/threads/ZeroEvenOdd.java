package threads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Semaphore sZero;
    private Semaphore sEven;
    private Semaphore sOdd;

    //0102030405 --> initially 0 is permit
    public ZeroEvenOdd(int n) {
        this.n = n;
        sZero = new Semaphore(1);
        sEven = new Semaphore(0);
        sOdd = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= this.n; i++){
            sZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                sEven.release();
            } else {
                sOdd.release();
            }
        }
    }

    //acquire even no
    //release 0
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= this.n; i += 2){
            sEven.acquire();
            printNumber.accept(i);
            sZero.release();
        }
    }

    //acquire Odd no
    //release 0
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= this.n; i += 2){
            sOdd.acquire();
            printNumber.accept(i);
            sZero.release();
        }
    }
}

class Printer{
    public static void main(String[] args) {
        ZeroEvenOdd zeo = new ZeroEvenOdd(5);
        Thread tZero = new Thread(() -> {
            try {
                zeo.zero(value -> {
                    System.out.println(value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread tEven = new Thread(() -> {
            try {
                zeo.even(value -> {
                    System.out.println(value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread tOdd = new Thread(() -> {
            try {
                zeo.odd(value -> {
                    System.out.println(value);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        tZero.start();
        tOdd.start();
        tEven.start();
    }
}