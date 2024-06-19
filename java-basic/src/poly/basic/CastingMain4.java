package poly.basic;

// 다운 캐스팅 자동으로 하지 않는 이유
public class CastingMain4 {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod();
        // 문제 없음

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2;
        child2.childMethod();
        // ClassCastException 발생 -> 다운캐스팅
        // 메모리상에 child자체가 존재하지 않음

    }
}
