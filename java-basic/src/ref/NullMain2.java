package ref;

public class NullMain2 {
    public static void main(String[] args) {
        Data data = null;
        data.value =10; // NullPointerException 예외 발생

        System.out.println(data.value);

        // 참조형 변수에 null에다가 인스턴스를 접근하였기에 널포인터 발생

    }
}
