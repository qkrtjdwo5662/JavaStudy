public class Test33 {
    public static void main(String[] args) {
        rec(10);
    }

    public static void rec(int x){
        rec(x);

        // 1. 에러 발생

    }
}
