package part03;

public class DiamondInterface {
}

interface A {
    default void hello(){
        System.out.println("A");
    }
}

interface B extends A {
    default void hello(){
        System.out.println("B");
    }
}

class C implements B {
    public static void main(String[] args) {
        new C().hello();
    }
}