package poly.ex.pay1;

public class NewPay implements Pay{
    @Override
    public boolean pay(int amount) {
        System.out.println("뉴페이 시스템과 연결");
        System.out.println(amount + "원 결제를 시도");
        return true;
    }
}
