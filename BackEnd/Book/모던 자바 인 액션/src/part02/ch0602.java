package part02;

import common.CaloricLevel;
import common.Dish;

import javax.swing.plaf.MenuBarUI;
import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.IntStream;

import static common.Dish.menu;
import static java.util.Comparator.comparingInt;
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
                .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
        System.out.println("collect4 = " + collect4);

        Map<Dish.Type, Dish> collect5 = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(
                        maxBy(comparingInt(Dish::getCalories)), Optional::get
                )));
        System.out.println("collect5 = " + collect5);

        Map<Dish.Type, Integer> collect6 = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println("collect6 = " + collect6);
        Map<Boolean, List<Dish>> collect7 = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println("collect7 = " + collect7);

        Map<Boolean, Map<Dish.Type, List<Dish>>> collect8 =
                menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println("collect8 = " + collect8);

        Map<Boolean, Dish> collect9 = menu.stream().collect(
                partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println("collect9 = " + collect9);
    }


    public boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.range(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }

}
