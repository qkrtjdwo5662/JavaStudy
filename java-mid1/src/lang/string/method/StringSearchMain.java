package lang.string.method;

public class StringSearchMain {
    public static void main(String[] args) {
        String str = "Hello, Java! Welcome to Java world.";

        System.out.println(str.contains("Java"));
        System.out.println(str.indexOf("Java")); // 처음부터 문자열 찾기
        System.out.println(str.indexOf("Java", 10)); // 특정 위치부터 문자열 찾기
        System.out.println(str.lastIndexOf("Java")); // 거꾸로 찾음
    }
}
