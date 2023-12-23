package ref.ex;

import java.util.Scanner;

public class ProductOrderMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("입력할 주문의 개수를 입력 : ");
        int n = scanner.nextInt();
        scanner.nextLine();

        ProductOrder[] orders = new ProductOrder[n];

        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + "번째 주문을 입력해라");
            System.out.println("상품명 :");
            String productName = scanner.nextLine();

            System.out.println("가격 :");
            int price = scanner.nextInt();

            System.out.println("수량 :");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            orders[i] = createOrder(productName, price, quantity);
        }

        printOrders(orders);
        int totalAmount = getTotalAmount(orders);
        System.out.println(totalAmount);
    }

    static ProductOrder createOrder(String productName, int price, int quantity){
        ProductOrder po = new ProductOrder();
        po.productName = productName;
        po.price = price;
        po.quantity = quantity;

        return po;
    }

    static void printOrders(ProductOrder[] orders){
        for (ProductOrder order : orders) {
            System.out.println(order.productName + " " + order.price + " " + order.quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] orders){
        int total = 0;

        for(ProductOrder order: orders){
            total += order.price * order.quantity;
        }

        return total;
    }
}
