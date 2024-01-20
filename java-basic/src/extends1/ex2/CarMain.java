package extends1.ex2;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move(); // Car 클래스 상속
        electricCar.charge();

        GasCar gasCar = new GasCar();
        gasCar.move(); // Car 클래스 상속
        gasCar.fillUp();

    }
}
