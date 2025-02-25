package lang.object.poly;

public class ObjectPolyExample1 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);
    }

    private static void action(Object obj){
//        obj.sound();
//        obj.move();
        // 컴파일 오류 -> Object는 sound(), move()가 없음.

        // 객체에 맞는 다운캐스팅이 필요함 -> 다형성의 한계
        ((Dog) obj).sound();
        ((Car) obj).move();

        if(obj instanceof Dog dog){
            dog.sound();
        } else if(obj instanceof Car car){
            car.move();
        }
        // Object는 모든 객체를 대상으로 다형적 참조가 가능하지만 자식 클래스에서 메서드 오버라이딩이 안된다.

    }
}
