package ch1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class ex1_2 {
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

        inventory.sort(comparing(Apple::getWeight));

        for (Apple apple : inventory) {
            System.out.println(apple);
        }
    }
}
