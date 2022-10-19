import java.util.Scanner;

class Circle_E45_2{
    private double x,y;
    private int radius;
    public Circle_E45_2(double x, double y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void show(){
        System.out.println(x+" "+y+" "+radius);
    }
}

public class Exercise_4_5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle_E45_2 c[] = new Circle_E45_2[3];
        for(int i=0; i<c.length; i++){
            System.out.print("x, y, radius >>");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            int radius = sc.nextInt();
            c[i] = new Circle_E45_2(x,y,radius);
        }
        sc.close();
        for(int i=0; i<c.length; i++){
            c[i].show();
        }
    }
}
