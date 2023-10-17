public class Test_3_2 {
    public static void main(String[] args) {
        System.out.println(1);
        rec1();
        System.out.println(2);
    }

    public static void rec1(){
        System.out.println(3);
        rec2();
        System.out.println(4);
    }

    public static void rec2(){
        System.out.println(5);
    }
}
