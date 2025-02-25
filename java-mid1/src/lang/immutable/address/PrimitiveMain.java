package lang.immutable.address;

public class PrimitiveMain {
    public static void main(String[] args) {
        // 기본형은 값을 공유하지 않음
        int a = 10;
        int b = a;
        System.out.println(a);
        System.out.println(b);

        b = 20;
        System.out.println("20 -> b");
        System.out.println(a);
        System.out.println(b);
        // a와 b는 하나의 값을 공유하지 않음
    }
}
