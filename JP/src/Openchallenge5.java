import java.util.Scanner;

public abstract class Openchallenge5 {

    protected int distance;
    protected int x,y;
    public Openchallenge5(int startX, int startY, int distance){
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean collider(Openchallenge5 p){
        if(this.x ==p.getX() && this.y==p.getY()){
            return true;
        }else return false;
    }
    protected abstract void move();
    protected abstract char getShape();
}
class Fish extends Openchallenge5{

    public Fish(int x, int y, int distance){
        super(x,y,distance);
    }
    @Override
    protected void move() {
        int n = (int)(Math.random()*5);
        if(n==0) x = x+distance;
        else if(n==1) x= x-distance;

        if(x<0) x=0;
        if(x >= OC5Game.MAX_X) x = OC5Game.MAX_X-1;

        n = (int)(Math.random()*5);
        if(n==0) y = y+distance;
        else if(n==1) y= y-distance;

        if(y<0) y=0;
        if(y >= OC5Game.MAX_Y) y = OC5Game.MAX_Y-1;


    }

    @Override
    protected char getShape() {
        return '@';
    }
}
class Bear extends Openchallenge5{
    private Scanner scanner;
    public Bear(int x, int y, int distance){
        super(x, y, distance);
        scanner = new Scanner(System.in);
    }
    @Override
    protected void move() {
        System.out.print("왼(a), 아래(s), 위(d), ������(f) >> ");
        char c;
        c = scanner.next().charAt(0);
        switch (c) {
            case 'a': // left
                x--;
                if (x < 0) x = 0;
                break;
            case 'f': // right
                x++;
                if (x >= OC5Game.MAX_X) x = OC5Game.MAX_X - 1;
                break;
            case 'd': // up
                y--;
                if (y < 0) y = 0;
                break;
            case 's': // down
                y++;
                if (y >= OC5Game.MAX_Y) y = OC5Game.MAX_Y - 1;
                break;
        }
    }
    @Override
    protected char getShape(){
        return 'B';
    }
}
