package part02;

import common.CaloricLevel;
import common.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static common.Dish.menu;
import static java.util.stream.Collectors.*;

public class ch0602 {

    public static void main(String[] args) {
       String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        System.out.println("shortMenu = " + shortMenu);
        String shortMenu1 = menu.stream().collect(reducing("", Dish::getName, (s1, s2) -> s1 + s2));
        System.out.println("shortMenu1 = " + shortMenu1);

        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println("collect = " + collect);

        Map<Dish.Type, List<Dish>> collect1 = menu.stream().collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
        System.out.println("collect1 = " + collect1);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect2 = menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy(dish ->
                        {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })
                )
        );
        System.out.println("collect2 = " + collect2);

        Map<Dish.Type, Long> collect3 = menu.stream().collect(
                groupingBy(Dish::getType, counting()));
        System.out.println("collect3 = " + collect3);

        Map<Dish.Type, Optional<Dish>> collect4 = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println("collect4 = " + collect4);

        Map<Dish.Type, Dish> collect5 = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(
                        maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get
                )));
        System.out.println("collect5 = " + collect5);

        Map<Dish.Type, Integer> collect6 = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println("collect6 = " + collect6);
    }

}
