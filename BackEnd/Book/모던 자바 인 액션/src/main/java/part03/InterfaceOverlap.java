package part03;

public class InterfaceOverlap implements Inter1, Inter2, Inter3 {


    public static void main(String[] args) {

        new InterfaceOverlap().hello();
    }

    @Override
    public void hello() {
        Inter2.super.hello();
    }
}

interface Inter1 {
    default void hello() {
        System.out.println("A");
    }
}

interface Inter2 {
    default void hello() {
        System.out.println("B");
    }
}

interface Inter3 {
    default void hello() {
        System.out.println("C");
    }
}
