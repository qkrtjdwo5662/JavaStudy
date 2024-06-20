package poly.ex.pay1;

import java.util.Scanner;

public class PayMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayService payService = new PayService();

        while(true){
            System.out.print("결제 수단 입력 : ");
            String payOption = scanner.nextLine();

            if(payOption.equals("exit")){
                System.out.println("프로그램 종료");
                return;
            }

            System.out.print("결제 금액 입력 : ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            payService.processPay(payOption, amount);
        }
    }
}
