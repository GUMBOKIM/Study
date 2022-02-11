package Thread;

import java.util.ArrayList;

public class ThreadTest8 {
    //쓰레드의 동기화(synchronization) -> 한 쓰레드가 진행중인 작업을 다른 쓰레드가 간섭하지 못하게 막는 것
    // 멀티 쓰레드 프로세스에서는 다른 쓰레드의 작업에 영향을 미칠 수 있다.
    // 진행중인 작업이 다른 쓰레드에게 간섭받지 않게하려면 ' 동기화'가 필요
    // 동기화하려면 간섭받지 않아야 하는 문장들을 '임계 영역'으로 설정
    // 임계영역은 락을 얻은 단하나의 쓰레드만 출입 가능(객체 1개에 락 1개)
    //
    // synchronized를 이용해 동기화 할수있다.

    public static void main(String[] args) {
        Runnable r = new AccountRunnable();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
    }

}


class Customer implements Runnable {
    private Table table;
    private String food;


    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String name = Thread.currentThread().getName();
            if(eatFood()) System.out.println(name + " ate a " + food);
            else System.out.println(name + " fail to eat");

        }
    }
    boolean eatFood() { return table.remove(food);}

}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) {this. table = table;}

    @Override
    public void run() {
        while(true){
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Table {
    String[] dishNames = {"donut","pizza","burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();
    public synchronized void add(String dish){
        if(dishes.size() >= MAX_FOOD){
            return;
        }
        dishes.add(dish);
        System.out.println("Dishes: " + dishes.toString());
    }

    public boolean remove(String dishName){
        synchronized (this){
            while(dishes.size() == 0){
                String name = Thread.currentThread().getName();
                System.out.println(name + "is waiting");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for(int i=0; i<dishes.size(); i++){
                    if(dishName.equals(dishes.get(i))){
                        dishes.remove(i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int dishNum() {
        return dishes.size();
    }
}