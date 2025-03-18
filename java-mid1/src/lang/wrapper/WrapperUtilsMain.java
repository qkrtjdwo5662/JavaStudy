package lang.wrapper;

public class WrapperUtilsMain {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(10);
        Integer i2 = Integer.valueOf("10");
        int intValue = Integer.parseInt("10");

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(intValue);

        int compareResult = i1.compareTo(20);
        System.out.println(compareResult);

        System.out.println(Integer.sum(10, 20));
        System.out.println(Integer.max(10, 20));
        System.out.println(Integer.min(10, 20));
    }
}
