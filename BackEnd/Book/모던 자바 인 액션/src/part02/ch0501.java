package part02;

import common.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static common.Dish.menu;
import static java.util.stream.Collectors.toList;

public class ch0501 {

    public static void main(String[] args) {

        // 필터링
        List<Dish> vegetarianDishesOuter = new ArrayList<>();
        for (Dish d : menu) {
            if (d.isVegetarian()) vegetarianDishesOuter.add(d);
        }

        // filter - Predicate를 만족하는 애들만 수집
        List<Dish> vegetarianDishesInner = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        System.out.println("vegetarianDishesInner = " + vegetarianDishesInner);
        System.out.println("vegetarianDishesOuter = " + vegetarianDishesOuter);

        // 고유요소 필터링
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        // 스트림 슬라이싱

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
                );

        List<Dish> filteredMenu = specialMenu.stream().filter(dish -> dish.getCalories() < 320).collect(toList());
        System.out.println("filteredMenu = " + filteredMenu);

        // takeWhile - predicate 가 false가 되면 중단 - 그때까지의 스트림 요소를 반환
        List<Dish> slicedMenu1 = specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320).collect(toList());
        System.out.println("slicedMenu1 = " + slicedMenu1);

        // dropWhile - predicate가 false가 되면 중단 - 그떄까지 스트림 요소를 버림
        List<Dish> slicedMenu2 = specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320).collect(toList());
        System.out.println("slicedMenu2 = " + slicedMenu2);

        // 스트림 축소
        // limit - 최대 요소 n개 반환
        List<Dish> dishes = specialMenu.stream().filter(dish -> dish.getCalories() > 300).limit(3).collect(toList());
        System.out.println("dishes = " + dishes);

        // skip - n개 요소 건너뛰기
        List<Dish> dishes1 = menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
        System.out.println("dishes1 = " + dishes1);

        //매핑
        // map - 스트림의 각 요소에 함수를 적용한다.
        List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
        System.out.println("dishNames = " + dishNames);

        List<String> words = Arrays.asList("Modern", "Java", "in", "Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
        System.out.println("wordLengths = " + wordLengths);

        List<Integer> dishNamesLength = menu.stream().map(Dish::getName).map(String::length).collect(toList());
        System.out.println("dishNamesLength = " + dishNamesLength);


        //스트림 평면화
        String[] arrayOfWords = {"GoodBye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

        List<Stream<String>> failResult = words.stream().map(word -> word.split("")).map(Arrays::stream).distinct().collect(toList());

        // flatMap 사용해 내부에서 구현된 스트림을 평면화한다.
        List<String> uniqueCharacters = words.stream().map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct().collect(toList());
        System.out.println("uniqueCharacters = " + uniqueCharacters);

    }

}
