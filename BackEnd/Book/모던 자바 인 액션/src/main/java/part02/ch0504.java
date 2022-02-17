package part02;

import common.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static common.Dish.menu;

public class ch0504 {

    public static void main(String[] args) {
        // 숫자형 스트림
        int calories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println("calories = " + calories);

//        calories = menu.stream().map(Dish::getCalories).sum(); 안됨 ㅋㅋ

        // 기본형 특화 스트림
        calories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("calories = " + calories);

        // 객체 스트림으로 복우너하기
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        // 기본값 : OptionalInt
        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
        int max = maxCalories.orElse(1); // 값이 없을 때 기본 최대값을 명시적으로 설정

        // 숫자 범위
        IntStream intStream1 = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println("intStream1 = " + Arrays.toString(intStream1.toArray()));

        // 피타고라스 수
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(1, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );
        pythagoreanTriples.map(p -> Arrays.toString(p)).forEach(System.out::println);

        // 값으로 스트리 ㅁ만들기

        Stream<String> stream3 = Stream.of("Modern", "Java", "In", "Action");
        stream3.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> empty = Stream.empty();

        // null이 될수있는 객체로 스트림을 만든다.
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream1 = homeValue == null ? Stream.empty() : Stream.of(homeValue);
        Stream<String> homeValueStream2 = Stream.ofNullable(System.getProperty("home"));

        // 배열로 스트림 만들기
        int[] numbers = {2,3,4,5,6};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("sum = " + sum);

        // 함수로 무한 스트림 만들기
        Stream.iterate(0, n -> n+2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
