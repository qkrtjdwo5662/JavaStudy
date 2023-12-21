package class1.ex;

public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder[] productOrders = new ProductOrder[3];

        ProductOrder po1 = new ProductOrder();
        po1.productName = "두부";
        po1.price = 2000;
        po1.quantity = 2;

        ProductOrder po2 = new ProductOrder();
        po2.productName = "김치";
        po2.price = 5000;
        po2.quantity = 1;

        ProductOrder po3 = new ProductOrder();
        po3.productName = "콜라";
        po3.price = 1500;
        po3.quantity = 2;

        productOrders[0] = po1;
        productOrders[1] = po2;
        productOrders[2] = po3;

        int total = 0;
        for (ProductOrder po : productOrders) {
            System.out.println(po.productName + " " + po.price + " " + po.quantity);
            total += po.price * po.quantity;
        }

        System.out.println(total);
    }
}
