package lang.immutable.address;

public class RefMain1_3 {
    public static void main(String[] args) {
        //참조형 변수는 하나의 인스턴스를 공유할 수 있다.

        Address a = new Address("서울");
        Address b = a;

        System.out.println(a);
        System.out.println(b);

        change(b, "부산");

        System.out.println(a);
        System.out.println(b);

    }

    private static void change(Address address, String changeAddress){
        System.out.println("주소를 변경합니다.");
        address.setValue(changeAddress);
    }
}
