package part02;

import common.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static common.Dish.menu;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class ch0401 {

    public static void main(String[] args) {
        ch0401.java7();
        ch0401.java8();
    }

    public static void java7(){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish dish : menu) {
            if(dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for(Dish dish: lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
        System.out.println("lowCaloricDishesName = " + lowCaloricDishesName);
    }

    public static void java8(){
        List<String> lowCaloricDishesName = menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
        System.out.println("lowCaloricDishesName = " + lowCaloricDishesName);
    }
}
