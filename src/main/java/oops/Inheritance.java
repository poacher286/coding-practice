package oops;

public class Inheritance {
    public static void main(String[] args) {
        C obj = new C();
        A a = new C();
        A a1 = new B();//can assign child class object to parent class
//        B b = new A(); // can not assign parent class instance to child class
        System.out.println(obj.a);
    }
}

class A {
    int a;

    public A() {
        System.out.println("A");
        a = 10;
    }
}

class B extends A {
    int a;

    public B() {
        System.out.println("B");
        a = super.a;
    }
}

class C extends B {
    int a;

    public C() {
        System.out.println("C");
        a= super.a;
    }
}

