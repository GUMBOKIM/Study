package Thread;

public class ThreadTest7 {
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

class Account {
    private int balance = 1000;

    public int getBalance(){
        return this.balance;
    }

    public synchronized void withdraw(int money){
        if(balance >= money){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){

            }
            balance -= money;
        }
    }
}

class AccountRunnable implements Runnable {

    Account acc = new Account();

    @Override
    public void run() {
        while(acc.getBalance() > 0){
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance = " + acc.getBalance());
        }
    }

}