package enumuration.ex1;

public class StringGradeEx1_1 {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basic = discountService.discount(StringGrade.BASIC, price);
        int gold = discountService.discount(StringGrade.GOLD, price);
        int diamond = discountService.discount(StringGrade.DIAMOND, price);

        System.out.println(basic);
        System.out.println(gold);
        System.out.println(diamond);

        // 이방법은 컴파일 시점에 오류를 발견할 수 있다.
        // 하지만 잘못입력하는 문제를 근본적으로 해결할수는 없음
    }
}
