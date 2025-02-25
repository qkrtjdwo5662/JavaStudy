package lang.immutable.address;

public class RefMain1_2 {
    public static void main(String[] args) {
        // 참조형 변수는 하나의 인스턴스를 공유할 수 있다.

        Address a = new Address("서울");
        Address b = new Address("서울");

        System.out.println(a);
        System.out.println(b);

        // 사이드 이펙트를 해결하기 위해 변수마다의 인스턴스를 따로 할당해줌
        b.setValue("부산");

        System.out.println("부산 -> b");
        System.out.println(a);
        System.out.println(b);

    }
}
