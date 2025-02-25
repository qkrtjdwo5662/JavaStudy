package lang.immutable.address;

public class MemberMainV2 {
    public static void main(String[] args) {
        ImmutableAddress address = new ImmutableAddress("서울");

        MemberV2 memberA = new MemberV2("회원", address);
        MemberV2 memberB = new MemberV2("회원", address);

        // 회원 A와 B는 처음 주소 모두 서울
        System.out.println(memberA);
        System.out.println(memberB);

        // 회원B의 주소를 부산으로 변경해야함

        memberB.setAddress(new ImmutableAddress("부산"));
        System.out.println(memberA);
        System.out.println(memberB);
    }
}
