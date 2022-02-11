package Thread;

public class ThreadTest5 {

    static boolean find = false;

    public static void main(String[] args) {
        // 일반스레드 / 데몬스레드 - 일반스레드를 도와주는 보조역할
        // 일반 쓰레드가 종료되면 자동적으로 종료된다.
        // 가비지 컬렉터, 자동저장, 화면 자동갱신 등에 사용된다.
        // 무한루프와 조건문을 이용해서 실행 후 대기하다가 특정조건이 만족되면 작업을 수행하고 다시 대기하도록한다.

        NormalThread normalThread = new NormalThread();
        DemonThread demonThread = new DemonThread();
        normalThread.start();
        demonThread.start();
    }

}

class NormalThread extends Thread{
    volatile int a = 123;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                sleep(100);
                System.out.println(i);
                if(i == 77) ThreadTest5.find = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class DemonThread extends Thread{
    @Override
    public void run() {
        boolean on = true;
        while(on){
            try {
                Thread.sleep(500);
                System.out.println("체크");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ThreadTest5.find) {
                System.out.println("77 찾았다");
                on = false;
            }
        }
    }
}