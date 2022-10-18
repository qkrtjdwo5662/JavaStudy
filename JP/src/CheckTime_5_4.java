class A{
    public A(){
        System.out.println("생성자 A");
    }
    public A(int a){
        System.out.println("매개변수 a 생성자 A");
    }
}
class B extends A{
    public B(){
        //super(30);
        System.out.println("생성자 B");
    }
    public B(int a){
        System.out.println("매개변수 a 생성자 B");
    }
}


public class CheckTime_5_4 {
    public static void main(String[] args){
        B b = new B();
    }
}
