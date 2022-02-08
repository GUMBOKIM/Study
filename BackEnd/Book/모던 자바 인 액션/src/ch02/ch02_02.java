package ch02;


import common.Apple;
import common.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static common.Color.GREEN;

// step 4
public class ch02_02 implements Supplier {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}

