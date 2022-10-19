//interface MouseAction {
//   final int BUTTON = 1;
//   int VERSION;
//   public abstract void move();
//   protected void clicked();
//   static public void drag(){};
//   void setPoint() { x = 0; y = 0; }
//}
class SuperObject1 {
    public void paint() {
        draw();
    }

    public void draw() {
        System.out.print("SuperObject-");
    }

}
class SubObject1 extends SuperObject1 {
    public void paint() {
        super.draw();
    }

    public void draw() {
        System.out.print("SubObject-");
    }
}

public class Test {
    public static void main(String args[]) {
        SuperObject1 x = new SubObject1();
        x.paint();

    }
}