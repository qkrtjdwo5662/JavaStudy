package lang.immutable.solution;

public class ImmutableMyDateMain {
    public static void main(String[] args) {
        ImmutableMyDate date1 = new ImmutableMyDate(2025, 2, 25);
        ImmutableMyDate date2 = date1;

        System.out.println(date1);
        System.out.println(date2);

        date2 = date2.withYear(2023); // 불변객체에서 변경

        System.out.println(date1);
        System.out.println(date2);
    }
}
