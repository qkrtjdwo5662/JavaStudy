package ref.ex;

public class ProductOrderMain2 {
    public static void main(String[] args) {
        ProductOrder[] productOrders = new ProductOrder[2];

        productOrders[0] = createOrder("제품 1", 1, 2);
        productOrders[1] = createOrder("제품 2", 3, 6);

        printOrders(productOrders);
        int totalAmount = getTotalAmount(productOrders);
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


