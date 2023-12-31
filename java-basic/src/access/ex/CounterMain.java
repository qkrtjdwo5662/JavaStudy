package access.ex;

public class CounterMain {
    public static void main(String[] args) {
        MaxCounter2 counter = new MaxCounter2(3);
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();

        int count = counter.getCount();
        System.out.println(count);
    }
}
