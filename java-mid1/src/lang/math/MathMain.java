package lang.math;

public class MathMain {
    public static void main(String[] args) {
        // 기본 연산
        System.out.println(Math.max(10, 20));
        System.out.println(Math.min(10, 20));
        System.out.println(Math.abs(-200));

        // 반올림 및 정밀도
        System.out.println(Math.ceil(2.1)); // 올림
        System.out.println(Math.floor(2.3));
        System.out.println(Math.round(2.5));

        // 기타
        System.out.println(Math.sqrt(4));
        System.out.println(Math.random()); // 0.0 ~ 1.0 사이의 double값
    }
}
