package construct;

public class ConstructMain1 {
    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("user1", 15, 90);
        show(member1);

        // 생성자를 사용하면 필수 값 입력을 보장할 수 있다.
    }

    static void show(MemberConstruct member){
        System.out.println(member.name + " " + member.age + " " + member.grade);
    }
}
