package ch2;

public class ColorPredicate implements Predicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}
