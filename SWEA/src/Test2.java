public class Test2 {
    public static void main(String[] args) {

        int n = 10;

        String s = Integer.toString(n, 3); // n진수로 교환
        System.out.println(Integer.parseInt(s, 2));
    }
}
