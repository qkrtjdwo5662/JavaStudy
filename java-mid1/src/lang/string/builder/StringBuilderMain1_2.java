package lang.string.builder;

public class StringBuilderMain1_2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("A").append("B").append("C").append("D")
                .insert(3, "Java") // 특정 위치에 문자열 추가
                .delete(4, 8).reverse();

        // 불변이 아니고 가변이기 때문에 메서드 사용으로 객체의 값이 변하게 됨
        String string = sb.toString();
        System.out.println(string); // String 객체를 통해 불변객체로 바꿔
    }
}
