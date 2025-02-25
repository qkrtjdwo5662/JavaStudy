package lang.object.tostring;

public class ToStringMain2 {
    public static void main(String[] args) {
        Car car = new Car("Model Y");
        Dog dog1 = new Dog("멍멍이1", 2);
        Dog dog2 = new Dog("멍멍이2", 5);

        System.out.println("1.단순 toString");
        System.out.println(car.toString());
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());

        System.out.println();

        System.out.println("2. println 내부에서 toString");
        System.out.println(car);
        System.out.println(dog1);
        System.out.println(dog2);

        System.out.println();

        System.out.println("3. Object 다형성 활용");
        ObjectPrinter.print(car);
        ObjectPrinter.print(dog1);
        ObjectPrinter.print(dog2);
        // 자식에 재정의(오버라이딩)된 메서드가 있는지 찾아본다.
        // 없다면 자신의 메서드

        int i1 = System.identityHashCode(dog1);
        int i2 = System.identityHashCode(dog2);
        // toString 메서드를 재정의 하는 경우 객체의 참조값을 출력하고 싶다면 사용하면 됨

        System.out.println(i1);
        System.out.println(i2);

        String refVal = Integer.toHexString(i1);
        System.out.println(refVal);
        refVal = Integer.toHexString(i2);
        System.out.println(refVal);

    }
}
