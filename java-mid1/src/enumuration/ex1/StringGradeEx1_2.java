package enumuration.ex1;

public class StringGradeEx1_2 {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();

        int vip = discountService.discount("VIP", price);
        System.out.println(vip);
        // vip는 없지만 vip등급이 있다고 생각하고 입력하는 경우

        int gold = discountService.discount("gold", price);
        System.out.println(gold);
        // 잘못 기억해서 소문자로 입력하는 경우

    }
}
