package enumuration.ex2;

public class ClassGradeEx2_2 {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
//        ClassGrade newClassGrade = new ClassGrade();
        int discount = discountService.discount(ClassGrade.BASIC, price);
        System.out.println(discount);

        // 참조값을 비교하기 때문에 새로운 인스턴스를 생성하면 기존의 것과 다르게 됨
        // 이걸 막으려면 private 생성자로 막아버리면 됨

        // 이를 통해 타입안정성이 향상되고 데이터의 일관성이 보장된다.
    }
}
