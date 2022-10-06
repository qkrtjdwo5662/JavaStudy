import java.util.Scanner;
class Circle1{
    private double x,y;
    private int radius;
    public Circle1(double x, double y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void show(){
        System.out.println("(" + x + ","+y+")"+radius);
    }

    int getRadius(){
        return radius;
    }

}

public class Exercise_4_6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Circle1 []c = new Circle1[3];

        int max =0;

        for(int i=0; i<c.length; i++){
            System.out.print("x,y,radius >>");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            int radius = sc.nextInt();

            c[i] = new Circle1(x, y , radius);
        }

        for(int i=0; i<c.length; i++){
            if(max<c[i].getRadius()){
                max = c[i].getRadius();
            }
        }

        for(int i=0; i<c.length; i++){
            if(max == c[i].getRadius()){
               System.out.print("가장 면적이 큰 원은 ");
               c[i].show();
            }
        }
        sc.close();
    }
}
