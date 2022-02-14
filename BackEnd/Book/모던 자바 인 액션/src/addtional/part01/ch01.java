package addtional.part01;

public class ch01 {

    public static void main(String[] args) {

        int cnt = 10000;
        int iter = 4;

        int result = 0;

        for (int i = 1; i <= iter; i++) {
            int start = (cnt / iter) * (i - 1) + 1;
            int end = (cnt / iter) * i;
            ThreadTest threadTest = new ThreadTest(i, start, end);
            threadTest.start();
        }

        System.out.println("result = " + result);

    }
}

class ThreadTest extends Thread {
    private int start;
    private int end;
    private int seq;
    private int result = 0;

//    @Override
//    public void run() {
//        System.out.println(seq + "번 스레드 시작 입니다.");
//        for (int i = start; i <= end; i++) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            result += i;
//        }
//        this.callback
//        System.out.println(seq + "번 스레드 종료 결과는 " + result + " 입니다.");
//    }

    public int getResult(){
        return result;
    }

    public ThreadTest(int seq, int start, int end) {
        this.seq = seq;
        this.start = start;
        this.end = end;
    }
}