package enumuration.ex3;

public class ClassGradeEx3_2 {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();

//        Grade grade = new Grade();
        // enum은 내부에서 상수로 지정하는 것 외에 직접 생성은 불가능하다.

        int discount = discountService.discount(Grade.BASIC, price);
        System.out.println(discount);

    }
}
