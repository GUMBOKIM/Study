package part02;

import common.Dish;

import java.util.*;
import java.util.stream.Stream;

import static common.Dish.menu;
import static java.util.stream.Collectors.toList;

public class ch0502 {

    public static void main(String[] args) {

        // 검색과 매칭
        // anyMatch - 프레디케이트가 적어도 한 요소와 일치하는지 확인
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly");
        }
        // allMatch - 프레디케이트가 전체 요소와 일치하는지 확인
        boolean isHealthy = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("isHealthy = " + isHealthy);

        // noneMath - 프레디케이트가 전체 요소와 일치하지 않는지 확인
        boolean isHealthy2 = menu.stream().noneMatch(d -> d.getCalories() >= 1000);
        System.out.println("isHealthy2 = " + isHealthy2);

        // 요소 검색
        // findAny - 결과를 찾는 즉시 실행 종료된다.
        Optional<Dish> vegetarianDish = menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println("vegetarianDish = " + vegetarianDish);

        // findFirst - 첫번쨰 결과를 반환한다.
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = someNumbers.stream().map(n -> n * n).filter(n -> n % 3 == 0).findFirst();
        System.out.println("first = " + first);

        // 리듀싱 - 모든 스트림 요소를 처리할때까지 반복적으로 동작
        // 리듀싱을 활용한 합계
        int sum = 0;
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int x : numbers) {
            sum += x;
        }
        System.out.println("numbers = " + sum);

        sum = Arrays.stream(numbers).reduce(0, (a,b) -> a + b);
        System.out.println("sum = " + sum);
        sum = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        OptionalInt reduce = Arrays.stream(numbers).reduce(Integer::sum);
        System.out.println("reduce = " + reduce);

        // 리듀싱을 활용한 최댓값 최솟값 구하기
        OptionalInt max = Arrays.stream(numbers).reduce(Integer::max);
        System.out.println("max = " + max);
        OptionalInt min = Arrays.stream(numbers).reduce(Integer::min);
        System.out.println("min = " + min);
    }

}
