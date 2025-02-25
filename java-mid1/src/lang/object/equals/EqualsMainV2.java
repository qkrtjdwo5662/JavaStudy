package lang.object.equals;

public class EqualsMainV2 {
    public static void main(String[] args) {
        UserV2 userV21 = new UserV2("id-100");
        UserV2 userV22 = new UserV2("id-100");

        System.out.println("identity =" + (userV21 == userV22));
        System.out.println("equality =" + (userV21.equals(userV22)));
        // equals 메서드 오버라이딩으로 재정의 했으므로 true

    }
}
