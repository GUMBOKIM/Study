package Thread;

public class ThreadTest3 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < 300000; i++){
            System.out.print("-");
        }

        for(int i = 0; i < 300000; i++){
            System.out.print("|");
        }

        System.out.println("기본 소요시간" + (System.currentTimeMillis() - startTime)); // 515

        Thread3 thread3 = new Thread3();
        Thread4 thread4 = new Thread4();
        thread3.start();
        thread4.start();

        startTime = System.currentTimeMillis();


        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("스레드로 소요시간" + (System.currentTimeMillis() - startTime)); // 1119
        // Context 스위칭 떄문에 시간이 더 오래걸린다.
    }
}

class Thread3 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300000; i++){
            System.out.print("-");
        }
    }
}

class Thread4 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300000; i++){
            System.out.print("|");
        }
    }
}