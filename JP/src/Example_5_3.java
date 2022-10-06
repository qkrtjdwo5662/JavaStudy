class Point_1{
    private int x,y;
    public Point_1(){
        this.x = 0;
        this.y = 0;
    }
    public Point_1(int x, int y){
        this.x = x;
        this.y = y;
        System.out.println("("+x+","+y+")");
    }
    public void showPoint(){
        System.out.println("("+x+","+y+")");
    }
}
class ColorPoint_1 extends Point_1 {
    private String color;
    public ColorPoint_1(int x, int y, String color){
        super(x,y);
        this.color = color;
    }

    public void showColorPoint(){
        System.out.print(color);
        showPoint();
    }
}

public class Example_5_3 {
    public static void main(String[] args){


        ColorPoint_1 cp_1 = new ColorPoint_1(1,2,"red");
        cp_1.showColorPoint();

    }
}
