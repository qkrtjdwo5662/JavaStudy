package ch2;

public class HeavyPredicate implements Predicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
