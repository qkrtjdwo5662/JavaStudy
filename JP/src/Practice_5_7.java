class A57{
    public A57(){
        System.out.println("A");
    }
    public A57(int x){
        System.out.println("A"+x);
    }
}
class B57 extends A57{
    public B57(){
        super(100);
    }
    public B57(int x){
        System.out.println("B"+x);
    }
}

public class Practice_5_7 {
    public static void main(String[] args) {
        B57 b = new B57(11);
    }
}
