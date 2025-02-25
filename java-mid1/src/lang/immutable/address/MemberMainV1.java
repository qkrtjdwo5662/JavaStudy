package lang.immutable.address;

public class MemberMainV1 {
    public static void main(String[] args) {
        Address address = new Address("서울");

        MemberV1 memberA = new MemberV1("회원", address);
        MemberV1 memberB = new MemberV1("회원", address);

        // 회원 A와 B는 처음 주소 모두 서울
        System.out.println(memberA);
        System.out.println(memberB);

        // 회원B의 주소를 부산으로 변경 -> 사이드 이펙트 발생
        memberB.getAddress().setValue("부산");

        System.out.println(memberA);
        System.out.println(memberB);
    }
}
