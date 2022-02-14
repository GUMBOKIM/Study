package part01;


import common.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static common.Color.*;

public class ch02_03 {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, GREEN),
                new Apple(100, RED),
                new Apple(120, GREEN),
                new Apple(140, RED),
                new Apple(160, GREEN));

        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());

        // 익명 클래스 사용
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });

        // 람다식 사용
        List<Apple> lamdaFilter = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));

        // 리스트 형식으로 추상화
        List<Apple> abstractFilter = filter(inventory, (Apple apple) -> RED.equals(apple.getColor()));
        List<Apple> abstractFilter2 = filter(inventory, apple -> RED.equals(apple));

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}

