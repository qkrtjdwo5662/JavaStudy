package string.builder;

public class StringBuilderMain1_1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");

        System.out.println(sb);

        sb.insert(3, "Java"); // 특정 위치에 문자열 추가
        System.out.println(sb);

        sb.delete(4, 8);
        System.out.println(sb);

        sb.reverse();

        // 불변이 아니고 가변이기 때문에 메서드 사용으로 객체의 값이 변하게 됨
        String string = sb.toString();
        System.out.println(string); // String 객체를 통해 불변객체로 바꿔줌


    }
}
