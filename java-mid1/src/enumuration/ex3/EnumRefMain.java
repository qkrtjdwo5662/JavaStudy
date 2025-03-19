package enumuration.ex3;

public class EnumRefMain {
    public static void main(String[] args) {
        System.out.println(Grade.BASIC.getClass());
        System.out.println(Grade.GOLD.getClass());
        System.out.println(Grade.DIAMOND.getClass());

        System.out.println(refValue(Grade.BASIC));
        System.out.println(refValue(Grade.GOLD));
        System.out.println(refValue(Grade.DIAMOND));

        // 이를 통해 열거형도 클래스임을 확인할 수 있음
    }

    private static String refValue(Grade grade){
        return Integer.toHexString(System.identityHashCode(grade));
    }
}
