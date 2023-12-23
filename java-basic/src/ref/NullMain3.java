package ref;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println(bigData.data); // null
        System.out.println(bigData.count); // 10

        System.out.println(bigData.data.value); // null.value -> 널포인터익셉션 발생
    }
}
