package lang.immutable.change;

public class ImmutableMain1 {
    public static void main(String[] args) {
        ImmutableObj obj1 = new ImmutableObj(10);
        ImmutableObj obj2 = obj1.add(20);

        System.out.println(obj1.getValue());
        System.out.println(obj2.getValue());

        // 불변객체를 값을 변경해야하는 경우는
        // 기존 객체의 값은 그대로 두고 변경된 결과 자체를 새로운 객체에 담아서 반환한다.
    }
}
