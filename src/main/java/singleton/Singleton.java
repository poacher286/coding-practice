package singleton;

public class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getBasicInstance() {
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public static Singleton getInstanceWithMultipleThread() {
        if (singleton == null){
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}

class Main{
    public static void main(String[] args) {
        Object obj1 = Singleton.getBasicInstance();
        Object obj2 = Singleton.getBasicInstance();

        System.out.println(obj1);
        System.out.println(obj2);

        ThreadLocal<Object> tObj1 = new ThreadLocal<>();
        ThreadLocal<Object> tObj2 = new ThreadLocal<>();

        tObj1.set(Singleton.getInstanceWithMultipleThread());
        tObj2.set(Singleton.getInstanceWithMultipleThread());

        System.out.println(tObj1.get());
        System.out.println(tObj2.get());
    }
}
