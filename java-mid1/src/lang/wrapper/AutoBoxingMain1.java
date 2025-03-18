package lang.wrapper;

public class AutoBoxingMain1 {
    public static void main(String[] args) {
        int value = 7;
        Integer boxedValue = Integer.valueOf(value);

        // Wrapper -> Primitive
        int unboxedValue = boxedValue.intValue();

        System.out.println(boxedValue);
        System.out.println(unboxedValue);

        // 근데 기본형을 래퍼 클래스, 래퍼 클래스를 기본형으로 바꿔야하는 상황이 많이 발생함
        // 그래서 오토박싱이 생김
    }
}
