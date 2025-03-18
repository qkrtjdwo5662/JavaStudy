package string.method;

public class StringInfoMain {
    public static void main(String[] args) {
        String str = "Hello, Java !";
        System.out.println(str.length());
        System.out.println(str.isEmpty()); // 비어 있는지
        System.out.println(str.isBlank()); // 비어 있거나 공백인지
        System.out.println("    ".isBlank());

        char c = str.charAt(7);
        System.out.println(c);


    }
}
