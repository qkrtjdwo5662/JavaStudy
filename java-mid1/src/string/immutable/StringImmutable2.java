package string.immutable;

public class StringImmutable2 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = str1.concat("java");
        System.out.println(str2);

        // String은 불변 객체이기에 기존의 값을 변경하는 것이 아닌 새로운 객체를 만들어서 반환하는 것

        // String이 불변객체로 설계된 이유는?
        // 문자열 풀의 String 인스턴스 값이 중간에 변경되면 같은 문자열을 참고하는 다른 변수의 값도 함께 변경된다.
        // 즉, 사이드 이펙트 문제를 막기 위해 불변객체로 설계되었음
    }
}
