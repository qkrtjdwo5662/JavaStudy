package ref;

public class NullMain1 {
    public static void main(String[] args) {
        Data data = null;
        System.out.println(data);

        data = new Data();
        System.out.println(data);
        System.out.println(data.value);

        data = null;
        System.out.println(data);
        System.out.println(data.value);

        // 참조현 변수에 null을 대입하면 가르키는 객체가 없다는 것임

        // 가비지 컬렉션을 통해 참조하지 않은 객체, 인스턴스이 삭제 된다.

    }
}
