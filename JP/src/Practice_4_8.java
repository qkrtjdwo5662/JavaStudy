class Power{
    private int kick;
    private int punch;
//    public Power(int k, int p){
//        kick = k;
//        punch = p;
//    }
    void show(){
        System.out.println(kick + " " + punch);
    }
    void f(){
        this.kick = 10;
        this.punch = 20;
    }
}

public class Practice_4_8 {
    public static void main(String[] args){
        //Power robot = new Power(10,20);
        Power robot = new Power();
        robot.f();
        robot.show();
    }
}
