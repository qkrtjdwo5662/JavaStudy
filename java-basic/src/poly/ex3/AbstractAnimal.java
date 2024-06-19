package poly.ex3;

public abstract class AbstractAnimal {
    // 직접 인스턴스를 생성할 수 없다.
    public abstract void sound();
    // 추상 메서드가 한개라도 존재하면 추상 클래스로 만들어야함
    // 추상 메서드는 바디 부분이 없다.

    public void move(){
        System.out.println("동물이 움직인다.");
    }
    // 추상 메서드가 아님
    // 자식 클래스의 오버라이딩이 강제되지는 않는다.
}
