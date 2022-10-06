class TV{
    private int size;
    private String manufacturer;

    public TV(){//생성자1
        this(32,"LG");
        System.out.println(size + "인치" + manufacturer);
    }
    public TV(String manufacturer){//생성자2
        this(32,manufacturer);
        System.out.println(size + "인치" + manufacturer);
    }
    public TV(int size, String manufacturer){//생성자3
        this.size=size;
        this.manufacturer = manufacturer;
        System.out.println(size + "인치" + manufacturer);
    }


}

public class Practice_4_6 {
    public static void main(String[] args){
        TV tv = new TV(65,"삼성");
    }
}
