package enumuration.ex1;

public class DiscountService {

    public int discount(String grade, int price){
        // 애초에 여기서 문자열을 받는것 자체가 문제임
        // 이걸 이제 enum으로

        int discountPercent = 0;

        if(grade.equals(StringGrade.BASIC)){
            discountPercent = 10;
        }else if(grade.equals(StringGrade.GOLD)){
            discountPercent = 20;
        }else if(grade.equals(StringGrade.DIAMOND)){
            discountPercent = 30;
        }else{
            System.out.println("할인 X");
        }

        return price * discountPercent / 100;
    }
}
