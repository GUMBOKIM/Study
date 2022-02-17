package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SteamCreateTest {

    public static void main(String[] args) {
        int iter = 100000;
        System.out.println("Create List");
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < iter; i++) integerList.add(i);
        System.out.println("Create List Complete");

        long start = System.currentTimeMillis();
        int result = 0;
        for (Integer i : integerList) if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) result++;
        System.out.println("반복문 필터링 시간 " + (System.currentTimeMillis() - start));
        System.out.println("result = " + result);

        start = System.currentTimeMillis();
        System.out.println("스트림 필터링 시간 " + (System.currentTimeMillis() - start));
        System.out.println("result = " + integerList.stream().filter((i) -> i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0).count());

    }
}
