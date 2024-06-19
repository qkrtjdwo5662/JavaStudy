package poly.overriding;

public class OverridingMain {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println("Child -> child");
        System.out.println("value = " + child.value);
        child.method();

        System.out.println();

        // 부모 변수가 부모 인스턴스 참조
        Parent parent = new Parent();
        System.out.println("Parent -> parent");
        System.out.println("value = " + parent.value);
        parent.method();

        System.out.println();

        //부모 변수가 자식 인스턴스 참조
        Parent poly = new Child();
        System.out.println("Parent -> Child");
        System.out.println("value = " + poly.value);
        poly.method();
    }
}
