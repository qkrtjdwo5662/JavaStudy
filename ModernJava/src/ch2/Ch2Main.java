package ch2;

import java.util.ArrayList;
import java.util.List;

public class Ch2Main {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.add(new Apple(0, "green"));
        inventory.add(new Apple(150, "green"));
        inventory.add(new Apple(200, "green"));
        inventory.add(new Apple(0, "green"));
        inventory.add(new Apple(350, "yellow"));
        inventory.add(new Apple(0, "green"));
        inventory.add(new Apple(600, "red"));

        List<Apple> greenApples1 = AppleFilter.filterApples(inventory, new ColorPredicate());
        for (Apple apple : greenApples1) {
            System.out.println(apple.getWeight() + " " + apple.getColor());
        }

        System.out.println();
        System.out.println("------익명 클래스------");
        List<Apple> redApples1 = AppleFilter.filterApples(inventory, new Predicate(){
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        });

        for (Apple apple : redApples1) {
            System.out.println(apple.getWeight() + " " + apple.getColor());
        }
        System.out.println();
        System.out.println("------람다-------");
        List<Apple> redApples2 = AppleFilter.filterApples(inventory,
                (apple) -> "red".equals(apple.getColor())
        );

        for (Apple apple : redApples2) {
            System.out.println(apple.getWeight() + " " + apple.getColor());
        }

    }

}
