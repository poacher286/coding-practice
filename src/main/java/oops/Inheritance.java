package oops;

public class Inheritance {
    public static void main(String[] args) {
        C obj = new C();
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

