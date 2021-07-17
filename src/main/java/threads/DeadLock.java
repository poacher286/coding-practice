package threads;

public class DeadLock {
    public static void main(String[] args) {
        CreateDeadlock createDeadlock = new CreateDeadlock();
        Thread threadA = new Thread(new ThreadA(createDeadlock));
        Thread threadB = new Thread(new ThreadB(createDeadlock));

        threadA.start();
        threadB.start();

    }

    public static class ThreadA extends Thread {
        private CreateDeadlock createDeadlock;

        public ThreadA(CreateDeadlock createDeadlock) {
            this.createDeadlock = createDeadlock;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                createDeadlock.takeA();
            }
        }
    }

    public static class ThreadB extends Thread {
        private CreateDeadlock createDeadlock;

        public ThreadB(CreateDeadlock createDeadlock) {
            this.createDeadlock = createDeadlock;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                createDeadlock.takeB();
            }
        }
    }

    public static class CreateDeadlock {
        Object a = new Object();
        Object b = new Object();

        public void takeA() {
            synchronized (a) {
                System.out.println("A");
                synchronized (b) {
                    System.out.println("B");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ignore) {
                    }
                }
            }
        }

        public void takeB() {
            synchronized (b) {
                System.out.println("B");
                synchronized (a) {
                    System.out.println("A");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ignore) {
                    }
                }
            }
        }
    }

}
