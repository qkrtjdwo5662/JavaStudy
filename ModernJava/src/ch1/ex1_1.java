package ch1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ex1_1 {
    public static class Apple{
        private int weight;

        public Apple(int weight){
            this.weight = weight;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        Apple apple1 = new Apple(50);
        Apple apple2 = new Apple(30);
        Apple apple3 = new Apple(40);
        Apple apple4 = new Apple(10);
        Apple apple5 = new Apple(20);

        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);
        inventory.add(apple4);
        inventory.add(apple5);

        Collections.sort(inventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        for (Apple apple : inventory) {
            System.out.println(apple);
        }
    }
}
