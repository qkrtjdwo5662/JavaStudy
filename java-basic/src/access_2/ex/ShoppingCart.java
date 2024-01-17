package access_2.ex;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    void addItem(Item item){
        if(itemCount >= 10){
            System.out.println("가득 참");
            return;
        }

        items[itemCount] =  item;
        itemCount ++;


    }

    void displayItems(){
        System.out.println("상품 출력");

        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].getName() + " " + items[i].getPrice());
        }

        System.out.println(calculateTotalPrice());
    }

    private int calculateTotalPrice(){
        int totalPrice = 0;

        for (int i = 0; i < itemCount; i++) {
            totalPrice += items[i].getPrice();
        }

        return totalPrice;
    }

}
