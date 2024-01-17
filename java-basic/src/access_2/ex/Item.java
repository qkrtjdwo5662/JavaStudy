package access_2.ex;

public class Item {
    private String name;
    private int price;
    private int quantity;

    public Item(){

    }

    public Item(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public int getPrice() {
        return price*quantity;
    }
}
