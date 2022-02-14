package part01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ch02_04 {
    public static void main(String[] args) {
        List<Ch02_04obj> exampleList = Arrays.asList(
                new Ch02_04obj(5),
                new Ch02_04obj(2),
                new Ch02_04obj(3),
                new Ch02_04obj(1),
                new Ch02_04obj(5),
                new Ch02_04obj(6));
        exampleList.sort(new Comparator<Ch02_04obj>() {
            @Override
            public int compare(Ch02_04obj o1, Ch02_04obj o2) {
                return o1.getField().compareTo(o2.getField());
            }
        });
        exampleList.sort((o1, o2) -> o1.getField().compareTo(o2.getField()));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Hello world"));

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName1 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
        Future<String> threadName2 = executorService.submit(() -> Thread.currentThread().getName());


    }


}

class Ch02_04obj{
    private Integer field;

    public Ch02_04obj(Integer i) {
        this.field = i;
    }

    public Integer getField() {
        return  this.field;
    }
}
