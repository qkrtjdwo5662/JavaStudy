package string.equals;

public class StringEqualsMain1 {
    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(str1 == str2); // String 객체의 주소값을 비교함
        System.out.println(str1.equals(str2)); // String 객체안에 value를 비교

        String str3 = "hello";
        String str4 = "hello";

        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));

        // str3과 str4의 == 이 true로 나오는 이유?
        // 여기서 문자열 풀이라는 개념이 나옴
        // 자바는 메모리 효율성과 성능 최적화를 위해 문자열 풀을 사용함
        // 자바가 실행될때 문자열 풀에 문자열을 넣어놓는데
        // 이 문자열 풀에 기존에 이미 있는 문자열이라면 새로 생성하는 것이 아니고 기존의 것을 반환하는 것임
        // 문자열 덕분에 같은 문자열을 사용하는 경우 메모리 사용을 줄이고, 만드는 시간도 줄어서 성능최적화
        // 그렇기 때문에 str3와 str4의 ==은 true라는 결과가 나오는 것임
        // 문자열 풀은 힙 영역을 사용하고 문자열 풀에서 문자를 찾을때는 해시를 통해 찾기 때문에 O(1)로 매우 빠르게 찾을 수 있음

    }
}
