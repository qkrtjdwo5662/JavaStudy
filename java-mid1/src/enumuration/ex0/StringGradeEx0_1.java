package enumuration.ex0;

public class StringGradeEx0_1 {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basic = discountService.discount("BASIC", price);
        int gold = discountService.discount("GOLD", price);
        int diamond = discountService.discount("DIAMOND", price);

        System.out.println(basic);
        System.out.println(gold);
        System.out.println(diamond);

        // 이 방식은 오타가 발생할 확률이 높다.
        // 즉, 오류가 날 확률이 높다.

        int vip = discountService.discount("VIP", price);
        System.out.println(vip);
        // vip는 없지만 vip등급이 있다고 생각하고 입력하는 경우

        int gold_lower = discountService.discount("gold", price);
        System.out.println(gold_lower);
        // 잘못 기억해서 소문자로 입력하는 경우

        // 즉, 문자열이기 때문에 오타가 많이 날 수 있다는 것임
        // 컴파일 시점에 오류가 나는 것이 아니고 런타임 시점에 확인이 가능한 것이 때문에 치명적인 문제가 발생할 수 있다.
        // String 타입으로는 문자열의 안정성을 해결할 수 없다.
    }
}
