package lang.string.equals;

public class StringEqualsMain2 {
    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(isSame(str1, str2));

        String str3 = "hello";
        String str4 = "hello";
        System.out.println(isSame(str3, str4));

        // isSame의 매개변수는 new String으로 문자열을 만들었는지 문자열 리터럴을 통해 문자를 만든 것인지 알수가 없음
        // 그렇기 때문에 String을 비교할때는 ==이 아닌 equals로 비교를 해야하는 것이다.
    }

    private static boolean isSame(String x, String y){
        return x == y;
    }
}
