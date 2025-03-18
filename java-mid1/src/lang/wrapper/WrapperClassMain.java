package lang.wrapper;

import java.util.logging.Logger;

public class WrapperClassMain {
    public static void main(String[] args) {
        Integer newInteger = new Integer(10); // 삭제예정, valueOf()를 사용해라
        Integer integerObj = Integer.valueOf(10); // -128 ~ 127 자주 사용하는 숫자 값 캐싱해서 재사용, 불변
        Long longObj = Long.valueOf(100);
        Double doubleObj = Double.valueOf(10.5);

        System.out.println(newInteger);
        System.out.println(integerObj);
        System.out.println(longObj);
        System.out.println(doubleObj);

        int intValue = integerObj.intValue();
        System.out.println(intValue);
        long longValue = longObj.longValue();
        System.out.println(longValue);

        System.out.println(newInteger == integerObj);
        System.out.println(newInteger.equals(integerObj));


    }
}
