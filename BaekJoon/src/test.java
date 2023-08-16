public class test{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("---");
        sb.append("---");
        sb.append("---");

        System.out.println(sb.length());

        sb.deleteCharAt(3);
        System.out.println(sb);
        sb.insert(3, " ");
        System.out.println(sb);
    }
}
