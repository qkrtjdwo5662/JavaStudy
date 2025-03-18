package lang.system;

import java.util.Arrays;

public class SystemMain {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);

        long currentTimeNano = System.nanoTime();
        System.out.println(currentTimeNano);

        // 환경변수 (os)
        System.out.println(System.getenv());

        // 시스템 속성을 읽는다. (java)
        System.out.println(System.getProperties());
        System.out.println(System.clearProperty("java.version"));

        // 배열을 고속으로 복사함
        char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
        char[] copiedArray = new char[5];
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);
        // system레벨에 던져서 운영체제가 통째로 읽어서 복사를 해버림
        // 속도가 굉장히 빠르다.

        System.out.println(Arrays.toString(copiedArray));

        // 프로그램 종료
        System.exit(0); // 가급적이면 사용하지 않는 것을 권장함(특히 웹 어플리케이션)
        System.out.println("hello"); // 출력 안됨
    }
}
