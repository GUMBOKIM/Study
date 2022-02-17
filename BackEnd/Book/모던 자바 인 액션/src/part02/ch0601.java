package part02;

import common.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static common.Dish.menu;
import static java.util.stream.Collectors.*;

public class ch0601 {

    public static void main(String[] args) {
        Long collect = menu.stream().collect(Collectors.counting());
        System.out.println("collect = " + collect);
        long collect2= menu.stream().count();
        System.out.println("collect2 = " + collect2);

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDIsh = menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println("mostCalorieDIsh = " + mostCalorieDIsh);

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("totalCalories = " + totalCalories);

        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println("avgCalories = " + avgCalories);

        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("menuStatistics = " + menuStatistics);

        String collect1 = menu.stream().map(Dish::getName).collect(joining());
        System.out.println("collect1 = " + collect1);
        String collect3 = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println("collect3 = " + collect3);

        int totalCalories1 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("totalCalories1 = " + totalCalories1);
    }
}
