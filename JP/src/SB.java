public class SB {
    public static void main(String[] args) {
        String a = "";
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(2);
        String str = sb.toString();
        System.out.println(sb);
        System.out.println(str);

    }
}
