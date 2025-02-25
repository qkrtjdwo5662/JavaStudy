package lang.immutable.change;

public class ImmutableMain2 {
    public static void main(String[] args) {
        ImmutableObj obj1 = new ImmutableObj(10);
        obj1.add(20); // 반환 값이 객체인데 아무것도 안받으면 gc에서 사라짐

        System.out.println(obj1.getValue());

    }
}
