package extends1.ex3;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move(); // Car 클래스 상속
        electricCar.charge();
        electricCar.openDoor();

        GasCar gasCar = new GasCar();
        gasCar.move(); // Car 클래스 상속
        gasCar.fillUp();
        gasCar.openDoor();

        HydrogenCar hydrogenCar = new HydrogenCar();
        hydrogenCar.move();
        hydrogenCar.fillHydrogen();
        hydrogenCar.openDoor();

        // 상속으로 인해 중복을 줄이고 -> 상속받는 부모에 기능을 추가하면 자식은 그대로 사용가능
        // 부모로 부터 편리하게 확장하여 사용가능

    }
}
