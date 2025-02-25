package lang.object;

public class ObjectMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        String string = child.toString();
        // toString메서드는 Object 클래스의 메서드
        System.out.println(string);

        // Object 클래스가 최상위 부모 클래스인 이유는?
        // 1. 필요한 공통된 기본기능을 제공해주기 위해서
        // 이로인해 모든 객체는 공통 기능을 편리하게 사용가능
        // toString(), equals(), getClass(), etc..

        // 2. 다형성의 기본 구현
        // Object는 모든 클래스의 부모 클래스
        // 다형성을 지원하는 기본적인 매커니즘 제공 -> Object는 모든 객체를 담을 수 있다.

    }
}
