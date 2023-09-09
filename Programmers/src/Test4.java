public class Test4 {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "1234";

        System.out.println(s1.equals(s2));

        int a = 7;
        System.out.println(Integer.toString(a, 2));
        String b = Integer.toString(a, 2);
        System.out.println(b);
        System.out.println(Integer.parseInt(b, 2));



    }
}
