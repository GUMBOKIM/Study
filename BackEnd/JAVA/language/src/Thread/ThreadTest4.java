package Thread;

public class ThreadTest4 {

    public static void main(String[] args) {
        ThreadPriority1 threadPriority1 = new ThreadPriority1();
        ThreadPriority2 threadPriority2 = new ThreadPriority2();

        threadPriority2.setPriority(7);
        System.out.println("threadPriority1.getPriority() = " + threadPriority1.getPriority());
        System.out.println("threadPriority2.getPriority() = " + threadPriority2.getPriority());
        threadPriority1.start();
        threadPriority2.start();
        // 우선순위가 높는다고 항상 먼저 작입이 끝나는것이 아님!
    }
}

class ThreadPriority1 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000; i++) sleep(1);
        } catch (Exception e){}
        System.out.println("1 끝남");
    }
}

class ThreadPriority2 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000; i++) sleep(1);
    } catch (Exception e){}
        System.out.println("2 끝남");
    }
}