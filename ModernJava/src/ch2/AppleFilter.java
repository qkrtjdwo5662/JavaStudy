package ch2;

import java.util.ArrayList;
import java.util.List;

public class AppleFilter {
    public static List<Apple> filterApples(List<Apple> inventory, Predicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
