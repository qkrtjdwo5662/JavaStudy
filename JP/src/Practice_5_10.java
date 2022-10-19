abstract class OddDetector{
    protected int n;
    public OddDetector(int n){
        this.n = n;
    }
    public abstract boolean isOdd();
    public void f(){};
}
public class Practice_5_10 extends OddDetector{
    public Practice_5_10(int n){
        super(n);
    }
    public boolean isOdd(){
        if(n%2==0){
            return false;
        } else return true;
    }
    public static void main(String[] args) {
        Practice_5_10 p = new Practice_5_10(10);
        System.out.println(p.isOdd());
    }
}
