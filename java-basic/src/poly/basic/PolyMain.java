package poly.basic;

public class PolyMain {

    public static void main(String[] args) {
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();
        System.out.println();

        // 자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> child");
        Child child = new Child();
        child.parentMethod(); // 자식은 부모 인스턴스 사용가능
        child.childMethod();
        System.out.println();

        System.out.println("Parent -> Child");
        Parent poly = new Child(); // 자식을 부모에 대입
        poly.parentMethod();
        // 부모는 자식을 담을 수 있다.
        // 반대로 자식은 부모 타입을 담을 수 없음
//        Child chil1 = new Parent(); // 자식은 부모를 담을 수 없다.

        // 부모 타입은 자신뿐만 아닌 자식타입을 참조할 수 있음
        // 이것이 바로 다양한 형태를 참조할 수 있다고 해서 다형적 참조

        // poly.childMethod(); // 자식의 기능은 호출 할 수 없음
        // 자식 -> 부모방향으로 찾아 내려갈 수는 있지만 부모 -> 자식방향으로 찾아 내려갈 수는 없음



    }
}
