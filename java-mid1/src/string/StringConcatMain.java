package string;

public class StringConcatMain {
    public static void main(String[] args) {
        String a = "hello";
        String b = "java";

        String result1 = a.concat(b);
        String result2 = a + b;

        System.out.println(result1);
        System.out.println(result2);

        // 문자열을 더할때는 concat메서드를 쓰는게 맞음
        // 근데 문자열은 자주 쓰니까 + 연산을 허용해주는 것임

    }
}
