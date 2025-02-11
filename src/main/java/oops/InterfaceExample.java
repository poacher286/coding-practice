package oops;

public interface InterfaceExample {
    public static final int VAL = 10; // by default all variables are public static final
    public int getData();// by default all methods are public
    void hello();

    public static void main(String[] args) {// can write main method
        System.out.println("Hello");
    }

    static interface InnerInterface{
        static final int INNER = 5;
        void innerMethod();
        default void hello(){
            System.out.println("Hey");
        }

    }
}

class Exam implements InterfaceExample.InnerInterface {
    public static void main(String[] args) {
        InterfaceExample.InnerInterface innerInterface = new Exam();
        innerInterface.hello();
    }

    @Override
    public void innerMethod() {

    }

    public void hello(){
        System.out.println("Exam Hey");
    }
}
