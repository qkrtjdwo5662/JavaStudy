package enumuration.ref3;

public class EnumRefMain3_2 {
    public static void main(String[] args) {
        int price = 10000;

        int basic = Grade.BASIC.discount(price);
        int gold = Grade.GOLD.discount(price);
        int diamond = Grade.DIAMOND.discount(price);

        System.out.println(basic);
        System.out.println(gold);
        System.out.println(diamond);

        // 더이상 discountService는 필요없게 됨
    }
}
