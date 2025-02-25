package lang.immutable.solution;

public class MyDateMain {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(2025, 2, 25);
        MyDate date2 = date1;

        System.out.println(date1);
        System.out.println(date2);

        date2.setYear(2023);

        System.out.println(date1);
        System.out.println(date2);
    }
}
