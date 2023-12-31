package static2.ex;

public class Car {
    private String name;
    public static int count;

    public Car(String name){
        this.name = name;
        count++;

        System.out.println(name);
    }

    public static void showTotalCars(){
        System.out.println(count);
    }
}
