package lang.wrapper.test;

public class WrapperTest4 {
    public static void main(String[] args) {
        String str = "100";

        Integer integer1 = Integer.valueOf(str);

        int intValue = integer1;

        Integer integer2 = integer1;
        System.out.println(integer2);
    }
}
