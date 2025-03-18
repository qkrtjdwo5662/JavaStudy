package string.method;

public class StringComparisonMain {
    public static void main(String[] args) {
        String str1 = "Hello, Java!";
        String str2 = "Hello, java!";
        String str3 = "Hello, World!";

        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println("b".compareTo("a"));
        System.out.println("c".compareTo("a")); // 뭐가 더 큰 문자열인지, 얼마나 차이나는지
        System.out.println(str1.compareTo(str3));
        System.out.println(str1.compareToIgnoreCase(str2));

        System.out.println(str1.startsWith("Hello"));
        System.out.println(str1.endsWith("Java!"));

    }
}
