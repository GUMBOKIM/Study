package Test;

public class Sonata extends Car {

    @Override
    void beep() {
        System.out.println("Beep - -");
    }

    @Override
    public void startUp() {
        super.startUp();
        System.out.println("This is Sonanta");
    }

    @Override
    public void shutOff() {
        System.out.println("This is Sonata");
        super.shutOff();
    }
}
