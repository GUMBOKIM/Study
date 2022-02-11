package Thread;

public class ThreadTest6 implements Runnable {
// TODO: volatile 공부
    static boolean autoSave = false;

    public static void main(String[] args) {


        Thread thread = new Thread(new ThreadTest6());
        thread.setDaemon(true);// 메인스레드가 종료되면 같이 종료됨
        thread.start();

        try {
            for (int i = 1; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(i);

                if(i==5) autoSave = true;
            }
        } catch (InterruptedException e){}
        System.out.println("프로그램을 종료합니다.");
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(3 *1000);
            } catch (InterruptedException e){
            }
            if(autoSave) autoSave();
        }
    }

    private void autoSave() {
        System.out.println("작업파일을 저장했습니다.");
    }
}