package oops;

public abstract class AbstractClass {
    int num;
    public AbstractClass(int num){
        this.num = num;
    }

    abstract void display();
}

class Abs extends AbstractClass{

    public Abs(int num) {
        super(num);
    }

    @Override
    void display() {
        System.out.println(this.num);
    }
}

class Main{
    public static void main(String[] args) {
        Abs abs = new Abs(5);
        AbstractClass abstractClass = new Abs(6);
        abs.display();
        abstractClass.display();
    }
}
