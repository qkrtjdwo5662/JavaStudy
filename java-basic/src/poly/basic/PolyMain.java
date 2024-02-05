package poly.basic;

public class PolyMain {

    public static void main(String[] args) {
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();
        System.out.println();

        // 자식 변수 자식 인스턴스 참조
        System.out.println("Child -> child");
        Child child = new Child();
//        child.parentMethod();
//        child.
        System.out.println();

        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        System.out.println("Parent -> Child");
        Parent poly = new Child(); // 부모는 자식타입을 담을 수 있다.
        poly.parentMethod();
//        poly.childMethod(); // 자식의 기능을 사용할 수 없다.

//        Child child1 = new Parent(); // 자식은 부모를 담을 수 없다.

        // 다형성 : 부모는 자식을 담을 수 있다.
        // 왜 필요한가?
    }
}
