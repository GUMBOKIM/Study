package part05;

import java.util.ArrayList;
import java.util.List;

public class SummaryFlow {
    public static void main(String[] args) {
        SimpleCell c3 = new SimpleCell("C3");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c1 = new SimpleCell("C1");
        c1.subscribe(c3);
        c1.onNext(10);
        c2.onNext(20);

        ArithmeticCell C3 = new ArithmeticCell("C3");
        SimpleCell C2 = new SimpleCell("C2");
        SimpleCell C1 = new SimpleCell("C1");

        C1.subscribe(C3::setLeft);
        C2.subscribe(C3::setRight);

        C1.onNext(10);
        C2.onNext(20);
        C1.onNext(15);
    }
}

class SimpleCell implements Publisher<Integer>, Subscriber<Integer>{
    private int value = 0;
    private String name;
    private List<Subscriber> subscribers = new ArrayList<>();

    public SimpleCell(String name){
        this.name = name;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    private void notifyAllSubscribers(){
        subscribers.forEach(subscriber -> subscriber.onNext(this.value));
    }

    @Override
    public void onNext(Integer newValue) {
        this.value = newValue;
        System.out.println(this.name + ":" + this.value);
        notifyAllSubscribers();
    }

    public int getValue() {
        return this.value;
    }
}

interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}

interface Subscriber<T>{
    void onNext(T t);
}

class ArithmeticCell extends SimpleCell {
    private int left;
    private int right;

    public ArithmeticCell(String name) {
        super(name);
    }

    public void setLeft(int left) {
        this.left = left;
        onNext(left + this.right);
    }

    public void setRight(int right) {
        this.right = right;
        onNext(right + this.left);
    }
}