package lang.string;

public class StringBasicMain {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");

        System.out.println(str1);
        System.out.println(str2);

        // String은 클래스임
        // 즉, 기본형이 아니라 참조형이다.

        // 문자열은 자주 사용되기 때문에 new String("문자열")의 형식으로 자바에서 변경해주는 것임
        // 근데 실제로는 성능 최적화를 위해 문자열 풀을 사용하긴 함

        // 정리하면 String 클래스는 직접 다루기 불편한 char[]을 내부에 감추고 String 클래스를 통해 개발자가 편리하게 문자열을 다룰 수 있도록 해줌


    }
}
