import java.util.Scanner;

class Circle_E46_2{
    private double x,y;
    private int radius;
    public Circle_E46_2(double x, double y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void show(){
        System.out.println(x+" "+y+" "+radius);
    }
    public int getRadius(){
        return radius;
    }
}

public class Exercise_4_6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle_E46_2 c[] = new Circle_E46_2[3];
        int max=0;

        for(int i=0; i<c.length; i++){
            System.out.print("x, y, radius >>");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            int radius = sc.nextInt();
            c[i] = new Circle_E46_2(x,y,radius);
        }
        sc.close();
        for(int i=0; i<c.length; i++){
            if(max <c[i].getRadius()){
                max = c[i].getRadius();
            }
        }
        for(int i=0; i<c.length; i++){
            if(max == c[i].getRadius()){
                c[i].show();
            }
        }
    }
}
