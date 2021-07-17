package threads;

public class PrintNumbers {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new PrintOdd();
        Thread threadB = new PrintEven();
        threadA.start();
        threadB.start();

    }

    static int n = 100;
    static int count = 1;

    public static class PrintOdd extends Thread {
        @Override
        public void run() {
            synchronized (this) {
                while (count < n) {
                    if (count % 2 == 1) {
                        System.out.println(count);
                        count++;
                    }
                    notify();
                }
            }
        }
    }

    public static class PrintEven extends Thread {
        @Override
        public void run() {
            synchronized (this) {
                while (count <= n) {
                    if (count % 2 == 0) {
                        System.out.println(count);
                        count++;
                    }
                    notify();
                }
            }
        }
    }

}
