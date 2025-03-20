package nested.inner;

public class InnterOuterMain {
    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter();
        InnerOuter.Inner inner = outer.new Inner();

        // 어떤 인스턴스인지 참조 값을 알아야 내부 클래스를 생성할 수 있음
        inner.print();
        System.out.println(inner.getClass());

        // 내부 클래스는 바깥 인스턴스에 소속된다.
        // 그래서 해당 내부 클래스를 생성하기 위해서는 바깥 인스턴스의 참조값을 알아야 생성가능
    }
}
