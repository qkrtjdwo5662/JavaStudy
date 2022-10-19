class A51{
    private int a;
    public void set(int a){
        this.a = a;
    }
}
class B51 extends A51{
    protected int b,c;
}
class C51 extends B51{
    public int d,e;
}
class D51 extends C51{
    public void f(){
        //a=1;
        set(10);
        b=20;
        d=30;
    }
}

public class Practice_5_1 {
    public static void main(String[] args) {
        B51 A = new B51();
    }
}
