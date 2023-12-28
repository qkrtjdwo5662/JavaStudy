package access.ex;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    void addItem(Item item){
        if(itemCount >= items.length){
            System.out.println("가득참");
            return;
        }

        items[itemCount] = item;
        itemCount ++;
    }

    void displayItems(){
        System.out.println("장바구니 상품출력");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].getItemName() + ", 합계 : " + items[i].getTotalPrice());
        }

        System.out.println("전체 : " + totalPrice());
    }

    private int totalPrice(){
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getTotalPrice();
        }

        return total;
    }
}
