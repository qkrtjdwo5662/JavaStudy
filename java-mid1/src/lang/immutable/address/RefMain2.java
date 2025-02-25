package lang.immutable.address;

public class RefMain2 {
    public static void main(String[] args) {
        //참조형 변수는 하나의 인스턴스를 공유할 수 있다.

        ImmutableAddress a = new ImmutableAddress("서울");
        ImmutableAddress b = a;

        System.out.println(a);
        System.out.println(b);

        // b.setValue("부산"); method가 없음, 불변객체

        b = new ImmutableAddress("부산"); // 새로운 인스턴스 생성

        System.out.println(a);
        System.out.println(b);
    }
}
