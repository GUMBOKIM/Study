package Thread;

public class ThreadTest1 {

    public static void main(String[] args) {
        ExtendThread thread1 = new ExtendThread();


        Runnable runnable = new ImplementRunnable();
        Thread thread2 = new Thread(runnable);
        // OS 스케줄러가 실행순서 결정
        thread1.start(); // Start가 새로운 호출 스택을 생성한다. // main 스택 + 새로운 스택(thread1)
        thread2.start();                                    // main 스택 + 새로운 스택(thread1) + 새로운 스택(thread2)
    }
}

// 스레드 구현 방법 2개
// 1. Thread 상속
class ExtendThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "번째 스레드");
        System.out.println("ExtendThread");
    }
}
// 2. Runnable 구현
class ImplementRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "번째 스레드");
        System.out.println("ImplementRunnable");
    }
}