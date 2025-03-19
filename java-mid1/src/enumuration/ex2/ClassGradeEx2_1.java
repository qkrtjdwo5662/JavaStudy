package enumuration.ex2;

public class ClassGradeEx2_1 {
    public static void main(String[] args) {
        int price = 10000;
        DiscountService discountService = new DiscountService();
        int basic = discountService.discount(ClassGrade.BASIC, price);
        int gold = discountService.discount(ClassGrade.GOLD, price);
        int diamond = discountService.discount(ClassGrade.DIAMOND, price);

        System.out.println(basic);
        System.out.println(gold);
        System.out.println(diamond);

        // 참조값을 기반으로 타입 또한 클래스로 제한
    }
}
