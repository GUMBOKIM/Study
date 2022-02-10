package Test;

public abstract class Car implements Engine {

    public CarMaker carMaker;
    public int weight;

    abstract void beep();

    @Override
    public void startUp() {
        System.out.println("Start up Engine");
    }

    @Override
    public void shutOff() {
        System.out.println("Shut off Engine");
    }
}
