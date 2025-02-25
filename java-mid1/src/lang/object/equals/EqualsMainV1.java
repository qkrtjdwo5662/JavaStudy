package lang.object.equals;

public class EqualsMainV1 {
    public static void main(String[] args) {
        UserV1 userV11 = new UserV1("id-100");
        UserV1 userV12 = new UserV1("id-100");

        System.out.println("identity =" + (userV11 == userV12));
        System.out.println("equality =" + (userV11.equals(userV12)));


    }
}
