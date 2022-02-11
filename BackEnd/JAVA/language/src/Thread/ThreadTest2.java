package Thread;

public class ThreadTest2 {

    public static void main(String[] args) {
        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();
        th1.start();
        th2.start();

        long startTime = System.currentTimeMillis();

        try {
            th1.join(); // main 스레드가 th1의 작업이 끝날때까지 기다린다.
            th2.join(); // main 스레드가 th2의 작업이 끝날때까지 기다린다.
            // join없이 start를 사용하면, main 스레드 먼저 종료된후 새로 생성된 스레드가 실행된다.
        } catch (InterruptedException e){}


        System.out.println("소요시간" + (System.currentTimeMillis() - startTime));
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300; i++){
            System.out.print("-");
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300; i++){
            System.out.print("|");
        }
    }
}