package poly.ex3;

public class AbstractMain {
    public static void main(String[] args) {
//        AbstractAnimal animal = new AbstractAnimal();
        // 추상클래스 생성 불가

        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        cat.sound();
        cat.move();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);
    }

    private static void soundAnimal(AbstractAnimal animal){
        System.out.println("테스트 시작");
        animal.sound();
        System.out.println("테스트 끝");
    }
}
