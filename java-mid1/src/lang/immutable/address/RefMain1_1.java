package lang.immutable.address;

public class RefMain1_1 {
    public static void main(String[] args) {
        //참조형 변수는 하나의 인스턴스를 공유할 수 있다.

        Address a = new Address("서울");
        Address b = a;

        System.out.println(a);
        System.out.println(b);
        b.setValue("부산");

        System.out.println("부산 -> b");
        System.out.println(a);
        System.out.println(b);
        // b객체의 필드값을 수정했는데 a객체의 필드값도 수정됨
        // 즉, 참조형 변수들은 같은 참조 값을 통해 같은 인스턴스를 참조함
        // b = a에서 참조값을 복사해서 전달하는 것임
    }
}
