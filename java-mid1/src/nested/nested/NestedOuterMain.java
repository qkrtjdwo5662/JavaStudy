package nested.nested;

public class NestedOuterMain {
    public static void main(String[] args) {
        NestedOuter outer = new NestedOuter();
        NestedOuter.Nested nested = new NestedOuter.Nested();
        nested.print();

        System.out.println(nested.getClass()); // 바깥 클래스의 중첩 클래스

        // 클래스 구조상 내부에 있는 것이지 중첩 정적 클래스는 기존 클래스와 연관이 없다.
    }
}
