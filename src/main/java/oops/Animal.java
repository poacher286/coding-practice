package oops;

public class Animal {
    public static void foo() {
        System.out.println("Animal");
    }
}

class Cat extends Animal {
    public static void foo() {  // hides Animal.foo()
        System.out.println("Cat");
    }
}

class MainOver{
    public static void main(String[] args) {
        Animal.foo(); // prints Animal
        Cat.foo(); // prints Cat

        Animal a = new Animal();
        Animal b = new Cat();
        Cat c = new Cat();
        Animal d = null;

        a.foo(); // should not be done. Prints Animal because the declared type of a is Animal
        b.foo(); // should not be done. Prints Animal because the declared type of b is Animal
        c.foo(); // should not be done. Prints Cat because the declared type of c is Cat
        d.foo(); // should not be done. Prints Animal because the declared type of d is Animal
    }
}