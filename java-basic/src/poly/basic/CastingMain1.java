package poly.basic;

public class CastingMain1 {
    public static void main(String[] args) {
        // 부모 변수 자식 인스턴스 참조
        Parent poly = new Child();
        // 단 자식의 기능은 호출할 수 없음
        // poly.childMethod(); // 컴파일 오류

        // 방법은 있음 다운캐스팅(부모타입 -> 자식타입)
        Child child = (Child) poly; // poly 타입을 강제로 형변환
        child.childMethod();


    }
}
