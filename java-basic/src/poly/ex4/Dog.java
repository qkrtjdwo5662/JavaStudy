package poly.ex4;

public class Dog extends AbstractAnimal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
    // 불완전한 추상메서드를 자식 클래스에서 완전하게 만듬

    @Override
    public void move() {
        System.out.println("개이동");
    }
}
