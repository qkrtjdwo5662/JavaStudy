package poly.ex4;

public abstract class AbstractAnimal {
    public abstract void sound();
    public abstract void move();
    // 다형성을 위한 껍데기 역할로서만 제공

    // 순수 추상 클래스
    // 1. 인스턴스 생성 불가
    // 2. 상속시 자식은 모든 메서드를 오버라이딩 해야함
    // 3. 주로 다형성을 위해 사용된다.

    // 순수 추상 클래스 -> 인터페이스
}
