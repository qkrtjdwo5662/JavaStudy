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

    public Fish(int startX, int startY, int distance){
        super(startX,startY,distance);
    }
    @Override
    protected void move() {

    }

    @Override
    protected char getShape() {
        return 0;
    }
}
class Bear extends Openchallenge5{
    public Bear(int x, int y, int distance){
        super(x, y, distance);
    }
    @Override
    protected void move(){

    }
    @Override
    protected char getShape(){
        return 0;
    }
}
