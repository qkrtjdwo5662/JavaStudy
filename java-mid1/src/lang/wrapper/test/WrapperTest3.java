package lang.wrapper.test;

public class WrapperTest3 {
    public static void main(String[] args) {
        String str = "100";

        Integer integer1 = Integer.valueOf(str);

        int intValue = integer1.intValue();

        Integer integer2 = Integer.valueOf(intValue);
        System.out.println(integer2);
    }
}
